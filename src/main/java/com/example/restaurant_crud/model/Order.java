package com.example.restaurant_crud.model;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer orderId;
    private Integer orderQuantity;
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="food_id")

    //Getter and setter
    private Food food;

    public Integer orderQuantity() {
        return orderQuantity;
    }

    public Order setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
        return this;
    }

    public Integer orderId() {
        return orderId;
    }

    public Order setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderStatus orderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Food food() {
        return food;
    }

    public Order setFood(Food food) {
        this.food = food;
        return this;
    }
}
