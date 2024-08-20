package com.example.restaurant_crud.model;


import jakarta.persistence.*;


@Entity
@Table(name="foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer foodId;
    private String foodTitle;
    private String foodDescription;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private String foodImage;
    private Double foodPrice;


    @ManyToOne()
    @JoinColumn(name="order_id",nullable = false)
    private Order order ;


    //Getter and setter
    public Integer foodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String foodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public String foodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public FoodType foodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String foodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public Double foodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Order order() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
