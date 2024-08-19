package com.example.restaurant_crud.model;


import jakarta.persistence.*;


@Entity
@Table(name="foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private final Integer foodId;
    private final String foodTitle;
    private final String foodDescription;

    @Enumerated(EnumType.STRING)
    private final FoodType foodType;
    private final String foodImage;
    private final Double foodPrice;


    @ManyToOne()
    @JoinColumn(name="order_id",nullable = false)
    private Order order ;

    public Food(String foodTitle, Integer foodId, String foodDescription, FoodType foodType, Double foodPrice, String foodImage) {
        this.foodTitle = foodTitle;
        this.foodId = foodId;
        this.foodDescription = foodDescription;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
    }

    public Integer getFoodId() {
        return foodId;
    }

}
