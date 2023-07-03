import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {BASE_URL} from "../app.constants";
import {IFuelType} from "../models/fuel-type.model";

type EntityResponseType = HttpResponse<IFuelType>;
type EntityArrayResponseType = HttpResponse<IFuelType[]>;

@Injectable({
  providedIn: 'root'
})
export class FuelTypeService {

  public resourceUrl = BASE_URL + '/fuelTypes'

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<EntityArrayResponseType> {
    return this.http.get<IFuelType[]>(this.resourceUrl + '/all', {observe: 'response'});
  }

  get(id: number): Observable<EntityResponseType> {
    return this.http.get<IFuelType>(`${this.resourceUrl +'/getById'}/$id`, {observe: 'response'});
  }
  create(fuelType: IFuelType): Observable<EntityResponseType> {
    return this.http.post<IFuelType>(this.resourceUrl + '/add', fuelType, {observe: 'response'});
  }

  update(fuelType: IFuelType): Observable<EntityResponseType> {
    return this.http.put<IFuelType>(this.resourceUrl + '/update', fuelType, {observe: 'response'});
  }

  delete(id: number): Observable<EntityResponseType> {
    return this.http.delete<IFuelType>(`${this.resourceUrl +'/delete'}/$id`, {observe: 'response'});
  }

}
