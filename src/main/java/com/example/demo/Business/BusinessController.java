package com.example.demo.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin
// (origins = "http://localhost:8080")
@RestController
public class BusinessController {
    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    // @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/business", produces = "application/json")
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    // @CrossOrigin(origins = "http://localhost:8080") // do i need this?
    @GetMapping(path = "/business/uen/{UEN}", produces = "application/json")
    public Business getBusiness(@PathVariable String UEN) {
        return businessService.getBusiness(UEN);
    }

    @PostMapping(path = "/business", consumes = "application/json")
    public Business addBusiness(@Valid @RequestBody Business business) {
        return businessService.addBusiness(business);
    }

    @GetMapping(path = "/business/no", produces = "application/json")
    public String test() {
        return "hello world";
    }
} 
