import {Injectable} from '@angular/core';
import {BASE_URL} from "../app.constants";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user.model";

type EntityResponseType = HttpResponse<User>
type EntityArrayResponseType = HttpResponse<User[]>

const API_URL = 'http://localhost:8080/api/test/';

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


  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }
}
