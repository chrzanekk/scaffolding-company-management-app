import {Injectable} from '@angular/core';
import {BASE_URL} from "../app.constants";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user.model";

type EntityResponseType = HttpResponse<User>
type EntityArrayResponseType = HttpResponse<User[]>

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public resourceUrl = BASE_URL + '/api/users'

  constructor(private http: HttpClient) {
  }


  getAll(): Observable<EntityArrayResponseType> {
    return this.http.get<User[]>(this.resourceUrl + '/all', {observe: 'response'})
  }

  getById(id: number): Observable<EntityResponseType> {
    return this.http.get<User>(`${this.resourceUrl +'/getById'}/$id`, {observe: 'response'})
  }
}
