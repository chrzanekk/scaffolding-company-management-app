import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, map, Observable} from 'rxjs';
import {LoginRequest} from "../core/login/login.model";
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {Account} from "../core/account/account.model";
import {RegisterRequest} from "../core/account/register.model";
import {MessageResponse} from "../models/message-response.model";
import {RequestPasswordReset} from "../core/account/request-password-reset.model";

type JwtToken = {
  id_token: string;
};
const URL = 'http://localhost:8080/api';
const AUTH_API = URL + '/auth';
const ACCOUNT_API = URL + '/account'

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private accountCache = new BehaviorSubject<Account | null>(null);
  accountCache$: Observable<Account | null> = this.accountCache.asObservable();

  constructor(private http: HttpClient, private $localStorage: LocalStorageService, private $sessionStorage: SessionStorageService) {
  }

  login(login: LoginRequest): Observable<void> {
    this.$localStorage.clear();
    this.$sessionStorage.clear();
    return this.http
      .post<JwtToken>(AUTH_API + '/login', login)
      .pipe(map(response => {
        this.authenticateSuccess(response)
      }));
  };

  logout(): boolean {
    this.$localStorage.clear('authenticationToken');
    this.$sessionStorage.clear('authenticationToken');
    this.clearAccount();
    return true;
  }

  getToken(): string {
    return this.$localStorage.retrieve('authenticationToken') || '';
  }

  private authenticateSuccess(response: JwtToken): void {
    const jwt = response.id_token;
    this.$localStorage.store('authenticationToken', jwt);
  }

  getUserInfo(): Observable<Account | null> {
    if (this.accountCache.getValue()) {
      return this.accountCache$;
    } else {
      return this.http.get<Account>(ACCOUNT_API + "/get").pipe(map(
        (responseFromApi: Account) => {
          this.accountCache.next(responseFromApi);
          return responseFromApi;
        }
      ))
    }
  }


//todo need to implement method to check if user is authenticated?

  clearAccount(): void {
    this.accountCache.next(null);
  }

  register(register: RegisterRequest): Observable<MessageResponse> {
    return this.http.post(AUTH_API + '/register', register, httpOptions)
  }

  requestPasswordReset(requestPasswordReset: RequestPasswordReset): Observable<MessageResponse> {
    return this.http.put(AUTH_API + '/request-password-reset', requestPasswordReset, httpOptions)
  }
}
