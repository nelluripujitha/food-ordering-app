import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
 { path:'', redirectTo:'restaurant-listing', pathMatch:'full'},
  { path: 'food-catalogue',
    loadChildren: () => import('./food-catalogue/food-catalogue.module').then(m => m.FoodCatalogueModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
