import {Injectable} from '@angular/core';
import {AccountService} from "./account.service";
import {AuthService} from "./auth.service";
import {UserLogin} from "../../models/user-login.model";

type JwtToken = {
  id_token: string;
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private accountService: AccountService, private authService: AuthService) {
  }
//todo simplify services to login/account/register/ etc. flow
  login(credentials: UserLogin): any {
    this.authService.login(credentials).subscribe(
      (jwtToken: JwtToken) => {
        this.accountService.getUserInfo().subscribe();
      }
    );
  }

  logout(): void {
    this.accountService.clearAccount();
    this.authService.logout();
  }
}
