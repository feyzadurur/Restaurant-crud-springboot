package com.example.restaurant_crud.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    public Long productId() {
        return productId;
    }

    public Product(Long productId, String productName, String productDescription, Double productPrice, Long restaurantId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.restaurantId = restaurantId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String productName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String productDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double productPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Long restaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
