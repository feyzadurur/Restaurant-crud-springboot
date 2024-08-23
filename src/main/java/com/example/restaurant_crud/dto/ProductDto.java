package com.example.restaurant_crud.dto;

public class ProductDto {

    private String productName;

    private String productDescription;

    private Double productPrice;

    //private Long restaurantId;

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
}
