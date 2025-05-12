package com.food.foodcatalogue.Service;

import com.food.foodcatalogue.DTO.FoodCataloguePage;
import com.food.foodcatalogue.DTO.FoodItemDTO;
import com.food.foodcatalogue.DTO.Restaurant;
import com.food.foodcatalogue.Entity.FoodItem;
import com.food.foodcatalogue.Mapper.RestaurantCatalogueMapper;
import com.food.foodcatalogue.Repository.CatalogueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CatalogueService {
    @Autowired
    CatalogueRepo catalogueRepo;
    @Autowired
    RestaurantCatalogueMapper restaurantCatalogueMapper;
    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO AddItem(FoodItemDTO foodItemDTO)
    {

        FoodItem savedfoodItem = catalogueRepo.save(restaurantCatalogueMapper.mapFoodItemDTOToFoodIem(foodItemDTO));
        return restaurantCatalogueMapper.mapFoodItemToFoodItemDTO(savedfoodItem);
    }

    public FoodCataloguePage fetchFoodCatalogueByRestaurantId(Integer restaurantId)
    {   List<FoodItem> listOfFoodItems= listAllFoodItems(restaurantId);
        Restaurant restaurant=getRestaurantDetailsMS(restaurantId);
        return createFoodCatalogue(listOfFoodItems,restaurant);
    }

    private FoodCataloguePage createFoodCatalogue(List<FoodItem> listOfFoodItems, Restaurant restaurant)
    {
        FoodCataloguePage foodcataloguepage= new FoodCataloguePage();
        foodcataloguepage.setRestaurant(restaurant);
        foodcataloguepage.setFoodItems(listOfFoodItems);
        return foodcataloguepage;

    }

    private Restaurant getRestaurantDetailsMS(Integer restaurantId)
    {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/"+restaurantId, Restaurant.class);
    }

    private List<FoodItem> listAllFoodItems(Integer restaurantId)
    {
        return catalogueRepo.findByRestaurantId(restaurantId);

    }
}
