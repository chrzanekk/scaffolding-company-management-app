import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {SessionStorageService} from 'ngx-webstorage';
import {LoginService} from "../../core/login/login.service";
import {AuthService} from "../../account/auth.service";
import {Observable} from "rxjs";
import {Account} from "../../core/account/account.model";


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['navbar.css'],
})
export class NavbarComponent implements OnInit {
  title = 'Scaffolding Management App';
  accountCache$: Observable<Account | null>;

  constructor(
    private loginService: LoginService,
    private sessionStorage: SessionStorageService,
    private authService: AuthService,
    private router: Router
  ) {
    this.accountCache$ = authService.accountCache$;
  }


  ngOnInit() {

  }


  isAuthenticated() : boolean {
    return !!this.accountCache$;
  }


  logout() {
    this.loginService.logout();
    this.router.navigate(['']);
  }


}

