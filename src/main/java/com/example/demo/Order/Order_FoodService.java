package com.example.demo.Order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Food.Food;
import com.example.demo.Food.FoodRepository;
import com.example.demo.Order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Order_FoodService {

    @Autowired
    private Order_FoodRepository order_FoodRepository;

    public void saveOrder_Food (Order_Food newOrder_Food){
        order_FoodRepository.save(newOrder_Food);
    }
}
