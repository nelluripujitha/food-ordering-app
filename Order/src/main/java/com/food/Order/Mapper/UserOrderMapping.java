package com.food.Order.Mapper;

import com.food.Order.DTO.UserOrderDTO;
import com.food.Order.Entity.UserOrder;
import org.springframework.stereotype.Component;

@Component
public class UserOrderMapping
{

    public UserOrder mapuserOrderDTOToUserOrder(UserOrderDTO userOrderDTO)
    {
        UserOrder userOrder = new UserOrder();
        userOrder.setUserOrderID(userOrderDTO.getUserOrderID());
        userOrder.setRestaurant(userOrderDTO.getRestaurantDTO());
        userOrder.setUser(userOrderDTO.getUser());

        return userOrder;
    }

    public UserOrderDTO mapuserOrderToUserOrderDTO(UserOrder userOrder)
    {
        UserOrderDTO userOrderDTO = new UserOrderDTO();
        userOrderDTO.setUserOrderID(userOrder.getUserOrderID());
        userOrderDTO.setRestaurantDTO(userOrder.getRestaurant());
        userOrderDTO.setFoodItemList(userOrder.getFoodItemList());
        userOrderDTO.setUser(userOrder.getUser());

        return userOrderDTO;
    }

}
