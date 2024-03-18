import {Injectable} from '@angular/core';
import {AuthService} from "./auth.service";
import {UserLogin} from "../../models/user-login.model";

type JwtToken = {
  id_token: string;
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private authService: AuthService) {
  }

  login(credentials: UserLogin): any {
    this.authService.login(credentials).subscribe(
      (jwtToken: JwtToken) => {
        this.authService.getUserInfo().subscribe();
      }
    );
  }

  logout(): void {
    this.authService.clearAccount();
    this.authService.logout();
  }
}
