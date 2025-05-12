import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { RestaurantListingRoutingModule } from './restaurant-listing-routing.module';
import { RestaurantListingComponent } from './components/restaurant-listing.component';

@NgModule({
  declarations: [RestaurantListingComponent],
  imports: [CommonModule, RestaurantListingRoutingModule,HttpClientModule],
})
export class RestaurantListingModule {}
