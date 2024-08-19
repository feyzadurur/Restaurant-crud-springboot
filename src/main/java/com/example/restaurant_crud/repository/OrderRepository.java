package com.example.restaurant_crud.repository;

import com.example.restaurant_crud.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
