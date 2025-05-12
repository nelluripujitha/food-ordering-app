package com.food.restaurantlisting.Controller;

import com.food.restaurantlisting.DTO.RestaurantDTO;
import com.food.restaurantlisting.Model.Restaurant;
import com.food.restaurantlisting.Repo.RestaurantRepo;
import com.food.restaurantlisting.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
    @Autowired
    private RestaurantRepo restaurantRepo;

    @GetMapping("/getallrestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllrestuarants()
    {
        List<RestaurantDTO> allrestuarants= restaurantService.findallrestaurants();
        return new ResponseEntity<>(allrestuarants, HttpStatus.OK);
    }
    @PostMapping( "/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO)
    {
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<RestaurantDTO>(restaurantAdded, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id)
    {
       return restaurantService.findingById(id);
    }
    public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO)
    {
        RestaurantDTO restaurantUpdated = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<RestaurantDTO>(restaurantUpdated, HttpStatus.CREATED);
    }
}
