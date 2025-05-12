package com.food.restaurantlisting.Mapper;

import com.food.restaurantlisting.DTO.RestaurantDTO;
import com.food.restaurantlisting.Model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class OwnRestaurantMapper {
    public Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO) {
        if ( restaurantDTO == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDTO.getId());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setCity(restaurantDTO.getCity());
        restaurant.setDescription(restaurantDTO.getDescription());


        return restaurant;
    }


    public RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantDTO restaurantDTO = new RestaurantDTO();

        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setCity(restaurant.getCity());
        restaurantDTO.setDescription(restaurant.getDescription());
        return restaurantDTO;
    }
}
