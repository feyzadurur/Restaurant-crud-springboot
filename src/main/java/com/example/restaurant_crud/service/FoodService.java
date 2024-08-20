package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Food;
import com.example.restaurant_crud.repository.FoodRepository;
import com.example.restaurant_crud.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    private final OrderRepository orderRepository;

    public FoodService(FoodRepository foodRepository, OrderRepository orderRepository) {
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
    }

    public Food createFood(Food food){
        return  foodRepository.save(food);
    }

    public Food updateFood(Integer foodId,Food updatedFood){
        Food existingFood=foodRepository.findById(foodId)
                .orElseThrow(()-> new EntityNotFoundException("Yiyecek bulunamadı."));
        existingFood.setFoodTitle(updatedFood.foodTitle());
        existingFood.setFoodDescription(updatedFood.foodDescription());
        existingFood.setFoodType(updatedFood.foodType());

        return foodRepository.save(existingFood);
    }

    public void deleteFood(Integer foodId){
        Food existingFood=foodRepository.findById(foodId).
                orElseThrow(()->new EntityNotFoundException("Yiyecek bulunamadı."));
        foodRepository.delete(existingFood);
    }

    public Food findFoodById(Integer foodId){
        return foodRepository.findById(foodId).
                orElseThrow(()->new EntityNotFoundException("Yiyecek bulunamadı."));
    }

    public void addFoodItem(Food food){
        foodRepository.save(food);
    }

    public boolean isFoodInTheMenu(Food food){
        Integer id=food.foodId();
        return foodRepository.existsById(id);
    }

    public boolean orderPlaced(Integer foodId){
        return orderRepository.existsById(foodId);
    }

    public List<Food> getAllFoodItems(){
        return foodRepository.findAll();
    }
}
