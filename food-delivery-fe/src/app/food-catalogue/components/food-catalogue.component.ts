import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodItemService } from '../service/fooditem.service';
import { FoodCataloguePage } from 'src/app/shared/FoodCataloguePage';
import { FoodItem } from 'src/app/shared/FoodItem';
import { Restaurant } from 'src/app/shared/restaurant';

@Component({
  selector: 'food-catalogue',
  templateUrl: './food-catalogue.component.html',
  styleUrls: ['./food-catalogue.component.css'],
})
export class FoodCatalogueComponent implements OnInit {
  restaurantId: number = 0;
  foodItemResponse: FoodCataloguePage;
  foodItemCart: FoodItem[] = [];

  constructor(
    private route: ActivatedRoute,
    private foodItemService: FoodItemService,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      const idParam = params.get('id');
      if (idParam !== null) {
        this.restaurantId = +idParam;
        this.getFoodItemsByRestaurant(this.restaurantId);
      } else {
        console.error('Restaurant ID is null');
      }
    });
  }

  getFoodItemsByRestaurant(restaurantId: number) {
  this.foodItemService.getFoodItemsByRestaurant(restaurantId).subscribe(
    (data) => {
      console.log('API response received:', data);

      this.foodItemResponse = {
        foodItemsList: data.foodItems.map((item: any) => ({
          id: item.itemId,                    
          itemName: item.itemName,
          itemDescription: item.itemDescription,
          isVeg: item.veg,                     
          price: item.price,
          restaurantId: item.restaurantId,
          quantity: 0                         
        })),
        restaurant: data.restaurant,
      };
    },
    (error) => {
      console.error('Error fetching food items:', error);
    }
  );
}


  increment(food: FoodItem) {
    food.quantity++;

    const index = this.foodItemCart.findIndex((item) => item.id === food.id);

    if (index === -1) {
      // Deep copy using spread operator and only relevant fields
      this.foodItemCart.push({
        id: food.id,
        itemName: food.itemName,
        price: food.price,
        quantity: food.quantity,
        restaurantId: food.restaurantId,
        itemDescription: food.itemDescription,
        isVeg: food.isVeg,
      });
    } else {
      this.foodItemCart[index].quantity = food.quantity;
    }
  }
  decrement(food: FoodItem) {
    if (food.quantity > 0) {
      food.quantity--;
      const index = this.foodItemCart.findIndex(
        (item) => item.id === food.id
      );
      if (food.quantity === 0 && index !== -1) {
        this.foodItemCart.splice(index, 1);
      } else if (index !== -1) {
        this.foodItemCart[index].quantity = food.quantity;
      }
    }
  }

  onCheckOut() {
    const orderSummary: FoodCataloguePage = {
      foodItemsList: this.foodItemCart,
      restaurant: this.foodItemResponse.restaurant,
    };

    console.log('Food items in cart:', this.foodItemCart); // ✅ Add this
    this.router.navigate(['/orderSummary'], {
      queryParams: { data: JSON.stringify(orderSummary) },
    });
  }
}
