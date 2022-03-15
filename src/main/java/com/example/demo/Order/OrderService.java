package com.example.demo.Order;

import com.example.demo.Order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository customerRepository;

    //Create a new order
    public Order createOrder(){
        Order newOrder = new Order();
        return customerRepository.save(newOrder);
    }
}
