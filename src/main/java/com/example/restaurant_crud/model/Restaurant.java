package com.example.restaurant_crud.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Long restaurantId;


    @Column(name = "restaurant_name",nullable = false)
    private String restaurantName;

    @Column(name = "restaurant_phone")
    private String restaurantPhone;

    @Column(name = "restaurant_email",nullable = false)
    private String email;

    @OneToMany(mappedBy = "restaurantId")
    private List<Product> menu;

    public Restaurant(Long restaurantId, String restaurantName, String restaurantPhone, String email, List<Product> menu) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantPhone = restaurantPhone;
        this.email = email;
        this.menu = menu;
    }

    public Long restaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String restaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String restaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> menu() {
        return menu;
    }

    public void setMenu(List<Product> menu) {
        this.menu = menu;
    }
}
