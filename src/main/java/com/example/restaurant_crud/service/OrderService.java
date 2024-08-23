package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Order;
import com.example.restaurant_crud.model.OrderItem;
import com.example.restaurant_crud.model.TypeStatus;
import com.example.restaurant_crud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Long id) {;
        return orderRepository.findById(id);
    }

	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

    public ResponseEntity<Order> cancelOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (!optionalOrder.isPresent()) { // optionalOrder == null değil, isPresent() kontrolü yapılmalı
            return ResponseEntity.notFound().build();
        }

        Order order = optionalOrder.get();
        order.setOrderStatus(TypeStatus.CANCELED.getCode());
        order = orderRepository.save(order);

        return ResponseEntity.ok(order);
    }


    public ResponseEntity<Collection<OrderItem>> findItemsByOrderId(Long id) {

        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            return new ResponseEntity<>(order.orderItems(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



}
