import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {UserLogin} from "../../models/user-login.model";
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';

type JwtToken = {
  id_token: string;
};

const AUTH_API = 'http://localhost:8080/api/auth';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private $localStorage: LocalStorageService, private $sessionStorage: SessionStorageService) {
  }

  login(login: UserLogin): Observable<void> {
    this.$localStorage.clear();
    this.$sessionStorage.clear();
    return this.http
      .post<JwtToken>(AUTH_API + '/login', login)
      .pipe(map(response => this.authenticateSuccess(response)));
  };

  logout(): boolean {
    this.$localStorage.clear('authenticationToken');
    this.$sessionStorage.clear('authenticationToken');
    return true;
  }

  getToken(): string {
    return this.$localStorage.retrieve('authenticationToken') || '';
  }

  private authenticateSuccess(response: JwtToken): void {
    const jwt = response.id_token;
    this.$localStorage.store('authenticationToken', jwt);
  }
}
