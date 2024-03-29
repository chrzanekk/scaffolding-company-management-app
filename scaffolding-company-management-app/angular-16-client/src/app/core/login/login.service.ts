import {Injectable} from '@angular/core';
import {AuthService} from "../../account/auth.service";
import {LoginRequest} from "./login.model";
import {mergeMap, Observable} from "rxjs";
import {Account} from "../account/account.model";
import {Router} from "@angular/router";

type JwtToken = {
  id_token: string;
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private authService: AuthService, private router: Router) {
  }

  login(credentials: LoginRequest): Observable<Account | null> {
    return this.authService.login(credentials).pipe(mergeMap(() => this.authService.getUserInfo()))
  }

  logout() {
    this.authService.logout();
    this.router.navigate([''])
  }

}
