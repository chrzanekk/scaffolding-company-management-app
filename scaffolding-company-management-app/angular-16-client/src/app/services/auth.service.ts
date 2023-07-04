import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserLogin} from "../models/user-login.model";
import {UserRegister} from "../models/user-register.model";
import {JwtResponse} from "../models/jwt-response.model";
import {MessageResponse} from "../models/message-response.model";


const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  login(login: UserLogin): Observable<JwtResponse> {
    return this.http.post(AUTH_API + 'login', login, httpOptions)
  };

  register(register: UserRegister): Observable<MessageResponse> {
    return this.http.post(AUTH_API + 'register', register, httpOptions)
  }

  logout(): Observable<any> {
    return this.http.post(AUTH_API + 'logout', {}, httpOptions)
  }
}
