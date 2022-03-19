package com.example.demo.Business;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import jdk.jshell.spi.ExecutionControl.UserException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.Business.*;


@RestController
@CrossOrigin
public class BusinessController {
    
    private BusinessRepository businesses;

    @Autowired
    public BusinessController(BusinessRepository businesses){
        this.businesses = businesses;
    }

    @GetMapping("/business")
    public List<Business> getBusinesses() {
        // return businesses.findAll();
        Long l= Long.valueOf(103);
        return businesses.findByMallId(l);
    }
}
