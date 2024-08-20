package com.example.restaurant_crud.controller;


import com.example.restaurant_crud.model.Food;
import com.example.restaurant_crud.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooditems")
public class FoodController {
    private FoodService foodService;

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<?> createFoodItem(@RequestBody Food foodItem){
        foodService.createFood(foodItem);
        return ResponseEntity.status(HttpStatus.CREATED).body("Food item başarıyla oluşturuldu.");
    }

    //FOODITEMS LIST
    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoodItems(){
        List<Food> foodItems=foodService.getAllFoodItems();
        return ResponseEntity.ok(foodItems);
    }

    //FOOD
    @GetMapping("/{foodId}")
    public ResponseEntity<Food> findFoodItemById(@PathVariable Integer foodId){
        Food foodItem=foodService.findFoodById(foodId);
        return ResponseEntity.ok(foodItem);
    }

    //UPDATE
    @PutMapping("/update/{foodId}")
    public ResponseEntity <?> updateFoodItem(@PathVariable Integer foodId, @RequestBody Food food) {
        foodService.updateFood(foodId, food);
        return ResponseEntity.ok("Food item başarıyla güncellendi.");
    }

    //DELETE
    @DeleteMapping("/delete/{foodId}")
    public ResponseEntity<?> deleteFoodItem(@PathVariable Integer foodId){
        foodService.deleteFood(foodId);
        return ResponseEntity.ok("Food item başarıyla silindi.");
    }

    //SEARCH
    @PostMapping("/search/{foodId}")
    public ResponseEntity<List<Food>> searchFoodItem(){
        //return new ResponseEntity<>(foodService)
        return null;
    }
}
