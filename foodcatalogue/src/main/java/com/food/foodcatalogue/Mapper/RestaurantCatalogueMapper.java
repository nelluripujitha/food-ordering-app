package com.food.foodcatalogue.Mapper;

import com.food.foodcatalogue.DTO.FoodItemDTO;
import com.food.foodcatalogue.Entity.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class RestaurantCatalogueMapper {


    public FoodItem mapFoodItemDTOToFoodIem(FoodItemDTO foodItemDTO) {
        if ( foodItemDTO == null ) {
            return null;
        }

        FoodItem foodItem = new FoodItem();
        foodItem. setItemId(foodItemDTO.getItemId());
        foodItem .setItemName(foodItemDTO.getItemName());
        foodItem .setItemDescription(foodItemDTO.getItemDescription());
        foodItem .setIsVeg(foodItemDTO.isVeg());
        foodItem .setPrice(foodItemDTO.getPrice());
        foodItem .setRestaurantId(foodItemDTO.getRestaurantId());
        foodItem.setQuantity(foodItemDTO.getQuantity());



        return foodItem ;
    }


    public FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem) {

        if ( foodItem == null ) {
            return null;
        }

        FoodItemDTO foodItemDTO = new FoodItemDTO();
        foodItemDTO .setItemId(foodItem.getItemId());
        foodItemDTO.setItemName(foodItem.getItemName());
        foodItemDTO .setItemDescription(foodItem.getItemDescription());
        foodItemDTO .setIsVeg(foodItem.isVeg());
        foodItemDTO .setPrice(foodItem.getPrice());
        foodItemDTO .setRestaurantId(foodItem.getRestaurantId());
        foodItemDTO.setQuantity(foodItem.getQuantity());

        return foodItemDTO;
    }

}
