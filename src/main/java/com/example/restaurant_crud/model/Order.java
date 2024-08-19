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
    private Food food;

}
