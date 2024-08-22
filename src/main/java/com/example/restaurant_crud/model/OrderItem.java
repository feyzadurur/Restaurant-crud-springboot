package com.example.restaurant_crud.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="order_items")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="order_item_id")
    private Long orderItemId;

    @Column(name = "order_item_order")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "order_item_product")
    private Product product;

    @Column(name="order_item_quantity")
    private Integer quantity;

    public OrderItem(Long orderItemId, Long orderId, Product product, Integer quantity) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public Long orderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long orderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer quantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product product() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
