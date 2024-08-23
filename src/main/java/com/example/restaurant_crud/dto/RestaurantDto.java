package com.example.restaurant_crud.dto;

public class RestaurantDto {

    private String restaurantName;
    private String restaurantPhone;
    private String email;


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
}
