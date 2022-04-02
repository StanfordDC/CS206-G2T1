package com.example.demo.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.validation.Valid;

import com.example.demo.Table.TableService;
import com.example.demo.Table.Tables;

import java.util.List;

@CrossOrigin
@RestController
public class BusinessController {
    private BusinessService businessService;
    private TableService tableService;
    @Autowired
    private BCryptPasswordEncoder encoder;
    private BusinessRepository businesses;

    @Autowired
    public BusinessController(BusinessService businessService, TableService tableService, BusinessRepository businesses) {
        this.businessService = businessService;
        this.tableService = tableService;
        this.businesses = businesses;
    }

    @GetMapping(path = "/business", produces = "application/json")
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping(path = "/business/uen/{UEN}", produces = "application/json")
    public Business getBusinessByUEN(@PathVariable String UEN) {
        return businessService.getBusinessByUEN(UEN);
    }

    @GetMapping(path = "/business/mid/{mid}", produces = "application/json")
    public List<Business> getBusinessByUEN(@PathVariable Long mid) {
        return businessService.getBusinessesByMid(mid);
    }

    @PostMapping(value = "/business", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public Business addBusiness(@Valid @RequestBody Business newBusiness) {
        Business checkUser = businesses.findByUEN(newBusiness.getUEN()).orElse(null);
        if(checkUser != null){
            throw new BusinessAlreadyRegisteredException(newBusiness.getUEN());
        }

        newBusiness.setAuthorities("ROLE_USER");
        newBusiness.setPassword(encoder.encode(newBusiness.getPassword()));

        Business business = businessService.addBusiness(newBusiness);
        long bid = business.getBid();
        int noOf2Pax = 5;
        int noOf5Pax = 5;

        for (int i = 0; i < noOf2Pax; i++) {
            Tables table = new Tables(2);
            tableService.addTable(bid, table);
        }
        for (int i = 0; i < noOf5Pax; i++) {
            Tables table = new Tables(5);
            tableService.addTable(bid, table);
        }

        return business;
    }

    @GetMapping("/business/login/{UEN}/{password}")
    public Business login(@PathVariable("UEN") String UEN, @PathVariable("password") String password) {
        // checks if the email exists
        Business user = businesses.findByUEN(UEN).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException(UEN);
        }

        // checks if the password keyed in matches existing password
        if (!encoder.matches(password, user.getPassword())) {
            throw new UsernameNotFoundException(UEN);
        }

        return user;
    }
} 