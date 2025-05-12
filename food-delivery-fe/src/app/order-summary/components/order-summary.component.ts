import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../service/order.service';
import { OrderDTO } from '../model/OrderDTO';
import { OrderSummaryModule } from '../order-summary.module';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css'],
})
export class OrderSummaryComponent {
  orderSummary?: OrderDTO;
  obj: any;
  total?: any;
  showDialog: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private orderService: OrderService,
    private router: Router
  ) {}

  ngOnInit() {
    const data = this.route.snapshot.queryParams['data'];
    this.obj = JSON.parse(data);
    this.obj.userId = 1;
    this.orderSummary = this.obj;

    // Check if foodItems exists before accessing it
    if (this.orderSummary?.foodItemsList) {
      this.total = this.orderSummary.foodItemsList.reduce(
        (accumulator, currentValue) => {
          return (
            accumulator + (currentValue.quantity ?? 0) * (currentValue.price ?? 0)
          );
        },
        0
      );

    } else {
      // Handle the case where foodItems is undefined or null
      console.error('No food items found in the order summary.');
      this.total = 0; // Optionally set a default total value
    }
  }

  saveOrder() {
    this.orderService.saveOrder(this.orderSummary).subscribe(
      (response) => {
        this.showDialog = true;
      },
      (error) => {
        console.error('Failed to save data:', error);
      }
    );
  }

  closeDialog() {
    this.showDialog = false;
    this.router.navigate(['/']); // Replace '/home' with the actual route for your home page
  }
}
