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

import com.example.demo.Food.Food;
import com.example.demo.Order.*;

@RestController
@CrossOrigin
public class OrderController {

    private OrderRepository orderRepository;
    private OrderService orderService;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @PostMapping(value = "/create_order/{bid}/{cid}")
    public void createOrder(@RequestBody Order newOrder, @PathVariable("bid") Long bid, @PathVariable("cid") Long cid) {
        orderService.createOrder(newOrder, bid, cid);
    }

    // order history - list of all orders made by customer
    @GetMapping(value = "/get_all_order/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrderByCid(@PathVariable Long cid) {
        return orderRepository.listOrderByCid(cid);
    }

    // business order history - list of all orders made by customer
    @GetMapping(value = "/get_all_order_business/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrderByBid(@PathVariable Long bid) {
        return orderRepository.listOrderByBid(bid);
    }

    // order history - order details
    @GetMapping(value = "/get_order/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable Long oid) {
        return orderRepository.getOrder(oid);
    }

    @PostMapping(value = "submit_order/{oid}")
    public void submitOrder(@RequestPart List<Order_Food> order_FoodList, @RequestPart String price, @PathVariable Long oid){
        orderService.submitOrder(order_FoodList, price, oid);
    }

    @PostMapping(value = "pay_order/{oid}")
    public void makePayment(@PathVariable Long oid){
        orderService.payOrder(oid);
    }

    @PostMapping(value = "serve_order/{oid}")
    public void serveOrder(@PathVariable Long oid){
        orderService.serveOrder(oid);
    }
}
