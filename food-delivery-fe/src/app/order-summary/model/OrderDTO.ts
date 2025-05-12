import { FoodItem } from "src/app/shared/FoodItem";
import { Restaurant } from "src/app/shared/restaurant";

export interface OrderDTO {
  foodItemsList?: FoodItem[];
  userId?: number;
  restaurant?: Restaurant;
}
