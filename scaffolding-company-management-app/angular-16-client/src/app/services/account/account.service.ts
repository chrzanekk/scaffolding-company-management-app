import {Injectable} from '@angular/core';
import {Account} from "../../models/account.model";
import {BehaviorSubject, map, Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {SessionStorageService} from "ngx-webstorage";

const URL = 'http://localhost:8080/api';

const AUTH_API = URL + '/auth';
const ACCOUNT_API = URL + '/account'

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private accountCache = new BehaviorSubject<Account | null>(null);
  accountCache$: Observable<Account | null> = this.accountCache.asObservable();

  constructor(
    private sessionStorage: SessionStorageService,
    private http: HttpClient,
    private router: Router
  ) {}

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
}
