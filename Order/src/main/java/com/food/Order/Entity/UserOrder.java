package com.food.Order.Entity;

import com.food.Order.DTO.FoodItemDTO;
import com.food.Order.DTO.RestaurantDTO;
import com.food.Order.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document("UserOrderDetails")

public class UserOrder {


    @Id
    private Integer UserOrderID;
    private List<FoodItemDTO> foodItemList;
    private RestaurantDTO restaurant;
    private UserDTO user;

    public UserOrder() {
    }

    public UserOrder(Integer userOrderID, List<FoodItemDTO> foodItems, RestaurantDTO restaurant, UserDTO user) {
        this.UserOrderID = userOrderID;
        this.foodItemList = foodItems;
        this.restaurant = restaurant;
        this.user = user;
    }


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

    public RestaurantDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTO restaurant) {
        this.restaurant = restaurant;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


}
