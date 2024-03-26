import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../account/auth.service";
import {Observable} from "rxjs";
import {Account} from "../../core/account/account.model";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
})
export class MainComponent implements OnInit {
  title = 'Scaffolding Management App';
  accountCache$ : Observable<Account | null>;
  constructor(
    private authService: AuthService
  ) {
    this.accountCache$ = authService.accountCache$
  }

  ngOnInit() {
  }
}
