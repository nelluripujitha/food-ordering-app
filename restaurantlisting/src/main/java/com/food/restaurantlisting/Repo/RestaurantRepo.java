package com.food.restaurantlisting.Repo;

import com.food.restaurantlisting.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository <Restaurant, Integer>{
}
