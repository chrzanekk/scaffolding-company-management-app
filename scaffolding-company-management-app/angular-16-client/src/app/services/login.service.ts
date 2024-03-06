import {Injectable} from '@angular/core';
import {AccountService} from "./account.service";
import {AuthService} from "./auth.service";
import {UserLogin} from "../models/user-login.model";
import {mergeMap, Observable} from "rxjs";
import {Account} from "../models/account.model";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private accountService: AccountService, private authService: AuthService) {}

  login(credentials: UserLogin): Observable<Account | null> {
    return this.authService.login(credentials).pipe(mergeMap(()=> this.accountService.identity(true)));
  }

  logOut(): void {
    if(this.authService.logout()) {
      this.accountService.authenticate(null);
    }
  }

}
