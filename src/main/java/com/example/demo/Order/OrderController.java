package com.example.demo.Order;

import java.sql.JDBCType;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
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

    private OrderRepository orderRepository;
    private OrderService orderService;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping(value = "/create_order", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody Order newOrder) {
        newOrder.setOrder_status(0);
        newOrder.setPayment_status(0);
        newOrder.setPrice((float) 0.00);
        newOrder.setDate(LocalDateTime.now());
        orderRepository.save(newOrder);
    }

    @GetMapping(value = "/get_all_order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getAllOrder() {
        return orderRepository.listAllOrder();
    }

    @GetMapping(value = "/get_all_order/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrderBycid(@PathVariable Long cid) {
        return orderRepository.listOrderbycid(cid);
    }
}
