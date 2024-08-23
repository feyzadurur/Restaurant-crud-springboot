package com.example.restaurant_crud.controller;

import com.example.restaurant_crud.model.Restaurant;
import com.example.restaurant_crud.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public List<Restaurant> list(){
        return restaurantService.listRestaurants();
    }

    @GetMapping ("{id}")
    public Optional<Restaurant> findById(@PathVariable Long id) {
        return restaurantService.findRestaurantById(id);
    }

    @PostMapping
    public Restaurant addRestaurant( @RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        return restaurantService.deleteRestaurant(id);
    }
}
