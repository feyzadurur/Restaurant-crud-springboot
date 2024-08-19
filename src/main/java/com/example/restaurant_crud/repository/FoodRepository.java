package com.example.restaurant_crud.repository;

import com.example.restaurant_crud.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Integer> {
}
