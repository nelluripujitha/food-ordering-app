package com.food.foodcatalogue.Controller;

import com.food.foodcatalogue.DTO.FoodCataloguePage;
import com.food.foodcatalogue.DTO.FoodItemDTO;
import com.food.foodcatalogue.Entity.FoodItem;
import com.food.foodcatalogue.Service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/foodcatalogue")
public class CatalogueController {

    @Autowired
     CatalogueService catalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO)
    {
        FoodItemDTO addedItem=catalogueService.AddItem(foodItemDTO);
        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
    }
    @GetMapping("/foodCatalogueById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> getFoodCatalogueById(@PathVariable Integer restaurantId)
    {
        FoodCataloguePage foodCataloguePage= catalogueService.fetchFoodCatalogueByRestaurantId(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }
}
