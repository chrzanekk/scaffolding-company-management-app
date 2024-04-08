import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, map, Observable} from 'rxjs';
import {LoginRequest} from "../core/login/login.model";
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {Account} from "../core/account/account.model";
import {RegisterRequest} from "../core/account/register.model";
import {MessageResponse} from "../models/message-response.model";
import {RequestPasswordReset} from "../core/account/request-password-reset.model";
import {PasswordReset} from "../core/account/password-reset.model";
import {SERVER_URL} from "../app.constants";

type JwtToken = {
  id_token: string;
};

const AUTH_API = SERVER_URL + '/api/auth';
const ACCOUNT_API = SERVER_URL + '/api/account'

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private accountCache = new BehaviorSubject<Account | null>(null);
  private authenticated = false;
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
    this.authenticated = false;
    return true;
  }

  isAuthenticated(): boolean {
    return this.authenticated;
  }

  getToken(): string {
    return this.$localStorage.retrieve('authenticationToken') || '';
  }

  private authenticateSuccess(response: JwtToken): void {
    const jwt = response.id_token;
    this.authenticated = true;
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

  clearAccount(): void {
    this.accountCache.next(null);
  }

  register(register: RegisterRequest): Observable<MessageResponse> {
    return this.http.post(AUTH_API + '/register', register, httpOptions)
  }

  initPasswordReset(requestPasswordReset: RequestPasswordReset): Observable<MessageResponse> {
    return this.http.put(AUTH_API + '/request-password-reset', requestPasswordReset, httpOptions)
  }

  finishPasswordReset(passwordReset: PasswordReset): Observable<MessageResponse> {
    return this.http.put(AUTH_API + '/reset-password', passwordReset)
  }
}
