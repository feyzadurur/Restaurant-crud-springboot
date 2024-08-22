package com.example.restaurant_crud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_user")
    private Long orderUser;

    @Column(name = "order_address")
    private String orderAddress;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_status")
    private Integer orderStatus;

    @OneToMany(mappedBy = "orderId")
    private List<OrderItem> orderItems;

    public Order(Long orderId, Long orderUser, String orderAddress, Date orderDate, Integer orderStatus, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.orderUser = orderUser;
        this.orderAddress = orderAddress;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
    }

    public Long orderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long orderUser() {
        return orderUser;
    }

    public void setOrderUser(Long orderUser) {
        this.orderUser = orderUser;
    }

    public String orderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Date orderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer orderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> orderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

