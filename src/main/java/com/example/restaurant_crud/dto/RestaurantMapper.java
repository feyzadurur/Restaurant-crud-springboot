package com.example.restaurant_crud.dto;

import com.example.restaurant_crud.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public RestaurantDto toDto(Restaurant restaurant) {
        RestaurantDto dto = new RestaurantDto();
        dto.setRestaurantName(restaurant.restaurantName());
        dto.setEmail(restaurant.email());
        dto.setRestaurantPhone(restaurant.restaurantPhone());
        return dto;
    }

    public Restaurant toEntity(RestaurantDto dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(dto.restaurantName());
        restaurant.setRestaurantPhone(dto.restaurantPhone());
        restaurant.setEmail(dto.email());
        return restaurant;
    }


}
