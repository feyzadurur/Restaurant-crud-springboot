package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Food;
import com.example.restaurant_crud.model.Order;
import com.example.restaurant_crud.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final FoodService foodService;

    public OrderService(OrderRepository orderRepository, FoodService foodService) {
        this.orderRepository = orderRepository;
        this.foodService = foodService;
    }


    public Order createOrder(Order order){
        return orderRepository.save(order);
    }


    public Order updateOrder(Integer orderId, Order updatedOrder){
        Order existingOrder=orderRepository.findById(orderId)
                .orElseThrow(()->new EntityNotFoundException("Sipariş bulunamadı."));

        existingOrder.setOrderQuantity(updatedOrder.orderQuantity());
        existingOrder.setOrderStatus(updatedOrder.orderStatus());

        return orderRepository.save(existingOrder);
    }

    public  Order getOrderById(Integer orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(()->new EntityNotFoundException("Sipariş bulunamadı."));
    }

    public void deleteOrder(Integer orderId){
        Order existingOrder=orderRepository.findById(orderId)
                .orElseThrow(()->new EntityNotFoundException("Sipariş bulunamadı."));
        orderRepository.delete(existingOrder);
    }

    public Order findOrderById(Integer orderId){
         return orderRepository.findById(orderId)
                .orElseThrow(()->new EntityNotFoundException("Sipariş bulunamadı."));
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public boolean addOrder(Order order) {
        Food food=order.food();
        boolean foodAvailable=foodService.isFoodInTheMenu(food);
        if(foodAvailable){
            orderRepository.save(order);
            return true;
        } else{
            return false;
        }
    }


}
