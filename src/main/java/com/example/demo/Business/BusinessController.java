package com.example.demo.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;

import com.example.demo.Queue.OrdersInQueue;
import com.example.demo.Queue.OrdersInQueueRepository;
import com.example.demo.Queue.OrdersInQueueService;
import com.example.demo.Table.TableService;
import com.example.demo.Table.Tables;

import java.util.List;

@CrossOrigin
@RestController
public class BusinessController {
    private BusinessService businessService;
    private TableService tableService;
    private BCryptPasswordEncoder encoder;
    private OrdersInQueueService ordersInQueueService;
    private OrdersInQueueRepository ordersInQueueRepository;

    @Autowired
    public BusinessController(BusinessService businessService, TableService tableService, OrdersInQueueService ordersInQueueService, OrdersInQueueRepository ordersInQueueRepository) {
        this.businessService = businessService;
        this.tableService = tableService;
        this.ordersInQueueService = ordersInQueueService;
        this.ordersInQueueRepository = ordersInQueueRepository;
    }

    @GetMapping(path = "/business", produces = "application/json")
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping(path = "/business/bid/{bid}", produces = "application/json")
    public Business getBusinessByBid(@PathVariable Long bid) {
        return businessService.getBusinessById(bid);
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

    // obtains list from queue where status = 0 is in queue and status = 1 is in store 
    @GetMapping(path = "/business/bid/{bid}/status/{status}", produces = "application/json")
    public List<OrdersInQueue> getOrdersInQueueByBidAndStatus(@PathVariable Long bid, @PathVariable int status) {
        return ordersInQueueService.getOrdersInQueueByBidAndStatus(bid, status);
    }

    // changes customer status from in queue to in store
    @PutMapping(path = "/business/bid/{bid}/oid/{oid}", produces = "application/json")
    public void updateQueueToStore(@PathVariable Long bid, @PathVariable Long oid) {
        ordersInQueueService.updateQueueToStore(bid, oid);
    }

    // removing customer from store, status = 2 is done
    @DeleteMapping(path = "/business/bid/{bid}/oid/{oid}", produces = "application/json")
    public void removeOrderFromQueue(@PathVariable Long bid, @PathVariable Long oid) {
        ordersInQueueService.removeOrderFromQueue(bid, oid);
    }


} 