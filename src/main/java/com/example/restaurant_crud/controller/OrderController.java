package com.example.restaurant_crud.controller;

import com.example.restaurant_crud.model.Order;
import com.example.restaurant_crud.model.OrderItem;
import com.example.restaurant_crud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> list(){
        return orderService.listOrders();
    }

    @GetMapping ("{id}")
    public Optional<Order> findById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @GetMapping ("/{id}/items")
    public ResponseEntity<Collection<OrderItem>> findProductsByOrderId(@PathVariable Long id) {
        return orderService.findItemsByOrderId(id);
    }

	@PostMapping
	public Order addOrder( @RequestBody Order order) {
		return orderService.addOrder(order);
	}

    @PutMapping("/{id}")
    public ResponseEntity<Order> cancel(@PathVariable Long id) {
        return orderService.cancelOrder(id);
    }
}
