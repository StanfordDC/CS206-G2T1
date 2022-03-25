package com.example.demo.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class BusinessController {
    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
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
        return businessService.addBusiness(newBusiness);
    }
} 