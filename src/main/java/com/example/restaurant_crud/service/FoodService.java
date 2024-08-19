package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Food;
import com.example.restaurant_crud.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }



    public void addFoodItem(Food food){
        foodRepository.save(food);
    }

    public boolean isFoodInTheMenu(Food food){
        Integer id=food.getFoodId();
        return foodRepository.existsById(id);
    }

    public List<Food> getAllFoodItems(){
        return foodRepository.findAll();
    }
}
