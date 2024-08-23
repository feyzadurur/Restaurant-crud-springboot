package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Restaurant;
import com.example.restaurant_crud.repository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> listRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> findRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public ResponseEntity<Restaurant> updateRestaurant(Long id, Restaurant restaurant) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant == null) {
            return ResponseEntity.notFound().build();
        }

        Restaurant restaurant1=optionalRestaurant.get();
        BeanUtils.copyProperties(restaurant, restaurant1, "id");
        restaurant1 = restaurantRepository.save(restaurant1);
        return ResponseEntity.ok(restaurant1);

    }


    public ResponseEntity<Void> deleteRestaurant(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant == null) {
            return ResponseEntity.notFound().build();
        }
        Restaurant restaurant1=optionalRestaurant.get();
        restaurantRepository.delete(restaurant1);

        return ResponseEntity.noContent().build();
    }
}
