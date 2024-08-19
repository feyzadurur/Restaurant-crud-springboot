package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Food;
import com.example.restaurant_crud.model.Order;
import com.example.restaurant_crud.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final FoodService foodService;

    public OrderService(OrderRepository orderRepository, FoodService foodService) {
        this.orderRepository = orderRepository;
        this.foodService = foodService;
    }


    public boolean addOrder(Order order) {
        Food food=order.getFood();
        boolean foodAvailable=foodService.isFoodInTheMenu(food);

        if(foodAvailable){
            orderRepository.save(order);
            return true;
        }
        else
            return false;
    }

}
