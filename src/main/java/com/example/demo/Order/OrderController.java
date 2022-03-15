package com.example.demo.Order;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import jdk.jshell.spi.ExecutionControl.UserException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.Order.*;


@RestController
@CrossOrigin
public class OrderController {
    
    private OrderRepository orderRepo;
    private OrderService orderService;

    @Autowired
    public OrderController(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }

    @PostMapping(value="/create_order", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public Order newOrder(@RequestBody Order newOrder) {
        //orderService.createOrder();
        return newOrder;
    }
}
