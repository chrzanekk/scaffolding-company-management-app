import {Injectable} from '@angular/core';
import {AuthService} from "./auth.service";
import {UserLogin} from "../../models/user-login.model";
import {mergeMap, Observable} from "rxjs";
import {Account} from "../../models/account.model";

type JwtToken = {
  id_token: string;
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private authService: AuthService) {
  }

  login(credentials: UserLogin): Observable<Account | null> {
    return this.authService.login(credentials).pipe(mergeMap(()=> this.authService.getUserInfo()))
    // this.authService.login(credentials).subscribe(
    //   (jwtToken: JwtToken) => {
    //     this.authService.getUserInfo().subscribe();
    //   }
    // );
  }

  logout(): void {
    this.authService.clearAccount();
    this.authService.logout();
  }
}
