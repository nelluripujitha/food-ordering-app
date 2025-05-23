import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrderSummaryRoutingModule } from './order-summary-routing.module';
import { OrderSummaryComponent } from './components/order-summary.component';


@NgModule({
  declarations: [
    OrderSummaryComponent
  ],
  imports: [
    CommonModule,
    OrderSummaryRoutingModule,
  ],
  exports: [OrderSummaryComponent], 
})
export class OrderSummaryModule { }
