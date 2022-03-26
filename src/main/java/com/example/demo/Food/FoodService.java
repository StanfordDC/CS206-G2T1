package com.example.demo.Food;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;
    
    public void createFood (Food newFood, Long bid){
        newFood.setBid(bid);
        System.out.print(newFood);
        foodRepository.save(newFood);
    } 

    public void modifyFood (Food modifiedFood, Long fid){
        Food searchFood = foodRepository.findById(fid).get();
        searchFood.setAvailability(modifiedFood.isAvailability());
        searchFood.setImage(modifiedFood.getImage());
        searchFood.setName(modifiedFood.getName());
        searchFood.setPrice(modifiedFood.getPrice());
        searchFood.setQuantity(modifiedFood.getQuantity());
        foodRepository.save(searchFood);
    }

    public void updateQuantity (Integer orderQty, Long fid){
        Food searchFood = foodRepository.findById(fid).get();
        Integer foodQty = searchFood.getQuantity();
        if (foodQty - orderQty == 0){
            searchFood.setAvailability(false);
        }
        searchFood.setQuantity(foodQty - orderQty);
        foodRepository.save(searchFood);
    }
}
