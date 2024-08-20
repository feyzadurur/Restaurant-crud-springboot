package com.example.restaurant_crud.controller;


import com.example.restaurant_crud.model.Order;
import com.example.restaurant_crud.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sipariş başarıyla oluşturuldu.");
    }

    @GetMapping
    public ResponseEntity<Order> getOrderById(@PathVariable Integer orderId){
        Order order=orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/update/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable Integer orderId,@RequestBody Order order){
        orderService.updateOrder(orderId,order);
        return ResponseEntity.ok("Sipariş başarıyla güncellendi.");
    }

    @GetMapping("/delete/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Sipariş başarıyla silindi.");
    }
}
