import {Component, OnInit} from '@angular/core';
import {AuthService} from "./services/account/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'Scaffolding Management App';

  constructor(private authService: AuthService) {
  }

  ngOnInit() {

  }

  logout() {
    this.authService.logout();
    window.location.reload();
  }
}
