import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, map, Observable} from 'rxjs';
import {UserLogin} from "../../models/user-login.model";
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {Account} from "../../models/account.model";
import {UserRegister} from "../../models/user-register.model";
import {MessageResponse} from "../../models/message-response.model";

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

  login(login: UserLogin): Observable<void> {
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
    if(this.accountCache.getValue()) {
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

  register(register: UserRegister): Observable<MessageResponse> {
    return this.http.post(AUTH_API + '/register', register, httpOptions)
  }
}
