package com.food.Order.DTO;

import java.util.List;

public class OrderDTOFromFE {

   private List<FoodItemDTO> foodItems;
    private Integer userId;
    private RestaurantDTO restaurant;

    public RestaurantDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTO restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<FoodItemDTO> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItemDTO> foodItems) {
        this.foodItems = foodItems;
    }



}
