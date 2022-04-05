package com.example.demo.Food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FoodController {

    private FoodRepository foodRepository;
    private FoodService foodService;

    @Autowired
    public FoodController(FoodRepository foodRepository, FoodService foodService) {
        this.foodRepository = foodRepository;
        this.foodService = foodService;
    }

    @GetMapping(value = "/get_all_food")
    public List<Food> getAllFood() {
        return foodRepository.listAllFood();
    }

    @GetMapping(value = "/get_all_food/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Food> getFoodByBid(@PathVariable Long bid) {
        return foodRepository.listFoodByBid(bid);
    }

    @GetMapping(value = "/get_food/{fid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Food getFood(@PathVariable Long fid) {
        return foodRepository.getFood(fid);
    }

    @PostMapping(value = "/create_food/{bid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createFood(@RequestBody Food newFood, @PathVariable Long bid){   
        foodService.createFood(newFood, bid);
    }

    @PostMapping(value ="modify_food/{fid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modifyFood(@RequestBody Food modifiedFood, @PathVariable Long fid){   
        foodService.modifyFood(modifiedFood, fid);
    }
}
