package com.food.Order.DTO;

import lombok.Data;

import java.util.List;
@Data
public class UserOrderDTO {

    private Integer UserOrderID;
    private List<FoodItemDTO> foodItemList;
    private RestaurantDTO restaurantDTO;
    private UserDTO user;

    public Integer getUserOrderID() {
        return UserOrderID;
    }

    public void setUserOrderID(Integer userOrderID) {
        UserOrderID = userOrderID;
    }

    public List<FoodItemDTO> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItemDTO> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public RestaurantDTO getRestaurantDTO() {
        return restaurantDTO;
    }

    public void setRestaurantDTO(RestaurantDTO restaurantDTO) {
        this.restaurantDTO = restaurantDTO;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


}
