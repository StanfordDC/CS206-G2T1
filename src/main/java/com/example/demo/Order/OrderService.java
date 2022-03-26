package com.example.demo.Order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Food.Food;
import com.example.demo.Food.FoodRepository;
import com.example.demo.Food.FoodService;
import com.example.demo.Order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private Order_FoodService order_FoodService;
    private FoodService foodService;

    @Autowired
    public OrderService(Order_FoodService order_FoodService, FoodService foodService) {
        this.order_FoodService = order_FoodService;
        this.foodService = foodService;
    }

    public void createOrder (Order newOrder, Long bid, Long cid){
        newOrder.setBid(bid);
        newOrder.setCid(cid);
        newOrder.setOrder_status(0);
        newOrder.setPayment_status(0);
        newOrder.setPrice((float) 0.00);
        newOrder.setDate(LocalDateTime.now());
        orderRepository.save(newOrder);
    }

    public void submitOrder (List <Order_Food> order_FoodList, String price, Long oid){
        for (int i = 0; i < order_FoodList.size(); i++){
            order_FoodList.get(i).setOid(oid);
            order_FoodService.saveOrder_Food(order_FoodList.get(i));
            foodService.updateQuantity(order_FoodList.get(i).getQuantity(), order_FoodList.get(i).getFid());
        }

        Order searchOrder = orderRepository.findById(oid).get();
        searchOrder.setOrder_status(1);
        searchOrder.setPrice(Float.parseFloat(price));
        orderRepository.save(searchOrder);
    }

    public void payOrder (Long oid){
        Order searchOrder = orderRepository.findById(oid).get();
        searchOrder.setPayment_status(1);
        orderRepository.save(searchOrder);
    }

    public void serveOrder (Long oid){
        Order searchOrder = orderRepository.findById(oid).get();
        searchOrder.setOrder_status(2);
        orderRepository.save(searchOrder);
    }
}
