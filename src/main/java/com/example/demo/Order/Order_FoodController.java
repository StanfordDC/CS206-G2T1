package com.example.demo.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Order_FoodController {
    private Order_FoodRepository order_FoodRepository;
    private Order_FoodService order_FoodService;

    @Autowired
    public Order_FoodController(Order_FoodRepository order_FoodRepository, Order_FoodService order_FoodService) {
        this.order_FoodRepository = order_FoodRepository;
        this.order_FoodService = order_FoodService;
    }

    // order history - list of all orders by oid
    @GetMapping(value = "/get_all_order_food/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order_Food> getOrderByOid(@PathVariable Long oid) {
        return order_FoodRepository.listOrderByOid(oid);
    }

    @GetMapping(value = "/get_order_food/{ofid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order_Food getOrder_Food(@PathVariable Long ofid) {
        return order_FoodRepository.getOrder_Food(ofid);
    }
}
