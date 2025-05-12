package com.food.restaurantlisting.Service;

import com.food.restaurantlisting.DTO.RestaurantDTO;
import com.food.restaurantlisting.Mapper.OwnRestaurantMapper;
import com.food.restaurantlisting.Model.Restaurant;
import com.food.restaurantlisting.Repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    OwnRestaurantMapper ownRestaurantMapper;

    public List<RestaurantDTO> findallrestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOlist = restaurants.stream().map(restaurant -> ownRestaurantMapper.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return restaurantDTOlist;
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = ownRestaurantMapper.mapRestaurantDTOToRestaurant(restaurantDTO);
        Restaurant saved = restaurantRepo.save(restaurant);
        return ownRestaurantMapper.mapRestaurantToRestaurantDTO(saved);
    }

    public ResponseEntity<RestaurantDTO> findingById(Integer id)
    {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if (restaurant.isPresent())
            return new ResponseEntity<>(ownRestaurantMapper.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    public RestaurantDTO saveRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = ownRestaurantMapper.mapRestaurantDTOToRestaurant(restaurantDTO);
        Restaurant saved = restaurantRepo.save(restaurant);
        return ownRestaurantMapper.mapRestaurantToRestaurantDTO(saved);
    }

}
