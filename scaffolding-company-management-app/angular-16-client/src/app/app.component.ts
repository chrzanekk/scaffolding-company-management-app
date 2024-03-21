import {Component, OnInit} from '@angular/core';
import {AuthService} from "./account/auth.service";
import {Observable} from "rxjs";
import {Account} from "./core/account/account.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'Scaffolding Management App';
  accountCache$ : Observable<Account | null>;
  constructor(private authService: AuthService) {
    this.accountCache$ = authService.accountCache$
  }

  ngOnInit() {

  }

  logout() {
    this.authService.logout();
    window.location.reload();
  }
}
