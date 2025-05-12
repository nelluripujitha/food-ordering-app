import { FoodItem } from './FoodItem';
import { Restaurant } from './restaurant';

export interface FoodCataloguePage {
  foodItemsList: FoodItem[];
  restaurant: Restaurant | null;
}
