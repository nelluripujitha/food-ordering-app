import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
// import { API_URL_FC } from 'src/app/constants/urls';
import { k8ExternalIp } from 'src/app/constants/urls';

@Injectable({
  providedIn: 'root',
})
export class FoodItemService {
  private apiUrl = k8ExternalIp +'/foodcatalogue/foodCatalogueById/';

  constructor(private http: HttpClient) {}

  getFoodItemsByRestaurant(id: number): Observable<any> {
    return this.http
      .get<any>(`${this.apiUrl + id}`)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(error.message || error);
  }
}
