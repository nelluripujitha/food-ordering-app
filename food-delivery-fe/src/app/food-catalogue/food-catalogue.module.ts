import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FoodCatalogueRoutingModule } from './food-catalogue-routing.module';
import { FoodCatalogueComponent } from './components/food-catalogue.component';
import { OrderSummaryModule } from '../order-summary/order-summary.module';

@NgModule({
  declarations: [FoodCatalogueComponent],
  imports: [CommonModule, FoodCatalogueRoutingModule,OrderSummaryModule],
})
export class FoodCatalogueModule {}
