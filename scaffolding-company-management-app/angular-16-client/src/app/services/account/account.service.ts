import {Injectable} from '@angular/core';
import {Account} from "../../models/account.model";
import {Observable, ReplaySubject} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {SessionStorageService} from "ngx-webstorage";
import {StateStorageService} from "../state-storage.service";


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
  private userIdentity: Account | null = null;
  private authenticationState = new ReplaySubject<Account | null>(1);
  private accountCache$?: Observable<Account | null>;

  constructor(
    private sessionStorage: SessionStorageService,
    private http: HttpClient,
    private stateStorageService: StateStorageService,
    private router: Router
  ) {
  }

}
