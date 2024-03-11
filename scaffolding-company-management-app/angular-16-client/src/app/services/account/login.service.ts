import {Injectable} from '@angular/core';
import {AccountService} from "./account.service";
import {AuthService} from "./auth.service";
import {UserLogin} from "../../models/user-login.model";
import {Observable} from "rxjs";
import {Account} from "../../models/account.model";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private accountService: AccountService, private authService: AuthService) {}
//todo after login need to get user info and attach to user-profile - HOW??
  login(credentials: UserLogin): Observable<Account | null> {
    this.authService.login(credentials);
  }

}
