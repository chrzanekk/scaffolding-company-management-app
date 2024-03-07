import {Injectable} from '@angular/core';
import {Account} from "../../models/account.model";
import {catchError, Observable, of, ReplaySubject, shareReplay, tap} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {SessionStorageService} from "ngx-webstorage";
import {StateStorageService} from "../state-storage.service";
import {UserRegister} from "../../models/user-register.model";
import {MessageResponse} from "../../models/message-response.model";
import {Eroles} from "../../models/enums/eroles.string";


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

  register(register: UserRegister): Observable<MessageResponse> {
    return this.http.post(AUTH_API + '/register', register, httpOptions)
  }

  save(account: Account): Observable<{}> {
    return this.http.post(URL + '/account/save', account)
  }

  authenticate(identity: Account | null): void {
    this.userIdentity = identity;
    this.authenticationState.next(this.userIdentity);
  }

  hasAnyAuthority(authorities: Eroles[] | Eroles): boolean {
    if (!this.userIdentity || !this.userIdentity.authorities) {
      return false;
    }
    if (!Array.isArray(authorities)) {
      authorities = [authorities];
    }
    return this.userIdentity.authorities.some((authority: Eroles) => authorities.includes(authority));
  }

  identity(force?: boolean): Observable<Account | null> {
    if (!this.accountCache$ || force || !this.isAuthenticated()) {
      this.accountCache$ = this.fetch().pipe(
        catchError(() => {
          return of(null);
        }),
        tap((account: Account | null) => {
          this.authenticate(account);
          //todo here need to implement in future set locale language
          if (account) {
            this.router.navigate([''])
          }
        }),
        shareReplay()
      );
    }
    return this.accountCache$;
  }

  isAuthenticated(): boolean {
    return this.userIdentity !== null;
  }

  getAuthenticationState(): Observable<Account | null> {
    return this.authenticationState.asObservable();
  }

  private fetch(): Observable<Account> {
    return this.http.get<Account>(ACCOUNT_API + '/get');
  }

  //todo need to check if this work correct especially in line 98
  private navigateToStoredUrl(): void {
    // previousState can be set in the authExpiredInterceptor and in the userRouteAccessService
    // if login is successful, go to stored previousState and clear previousState
    const previousUrl = this.stateStorageService.getUrl();
    if (previousUrl) {
      this.stateStorageService.clearUrl();
      this.router.navigateByUrl(previousUrl).then(r => this.stateStorageService.storeUrl(""));
    }
  }
}
