package com.example.demo.Order;

import java.util.List;

import com.example.demo.Order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

}
