import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantService } from '../service/restaurant.service';
import { Restaurant } from 'src/app/shared/restaurant';

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrls: ['./restaurant-listing.component.css'],
})
export class RestaurantListingComponent implements OnInit {
  public restaurantList: Restaurant[] = [];

  constructor(
    private router: Router,
    private restaurantService: RestaurantService
  ) {}

  ngOnInit() {
    this.getAllRestaurants();
  }

  getAllRestaurants() {
    this.restaurantService
      .getAllRestaurants()
      .subscribe((data: Restaurant[]) => {
        // Ensure that each restaurant object gets a fixed image based on the index
        this.restaurantList = data.map(
          (restaurant: Restaurant, index: number) => ({
            ...restaurant,
            imageUrl: `assets/restaurant-pics/${(index % 8) + 1}.jpg`, // Loop through images 1 to 8
          })
        );
      });
  }

  onButtonClick(id: number) {
    this.router.navigate(['/food-catalogue/', id]);
  }
}
