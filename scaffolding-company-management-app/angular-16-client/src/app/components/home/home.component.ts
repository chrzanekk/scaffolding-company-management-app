import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {Observable} from "rxjs";
import {Account} from "../../models/account.model";
import {AuthService} from "../../services/account/auth.service";
import {Eroles} from "../../models/enums/eroles.string";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content?: string;
  accountCache$: Observable<Account | null>;

  constructor(private userService: UserService, private authService: AuthService) {
    this.accountCache$ = authService.accountCache$
  }

  ngOnInit() {
    this.accountCache$.subscribe({
      next: value => {
        if (value == null) {
         this.getPublicContent();
        } else if (value.roles?.includes(Eroles.ROLE_USER)) {
          this.getUserBoard();
        } else if (value.roles?.includes(Eroles.ROLE_ADMIN)) {
          this.getAdminBoard();
        } else if (value.roles?.includes(Eroles.ROLE_MODERATOR)) {
          this.getModBoard();
        }
      },error: err => {
        console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    })
  }

  getPublicContent(): void {
    this.userService.getPublicContent().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {
        console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    });
  }

  getUserBoard(): void {
    this.userService.getUserBoard().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {
        console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    });
  }
  getModBoard(): void {
    this.userService.getModeratorBoard().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {
        console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    });
  }
  getAdminBoard(): void {
    this.userService.getAdminBoard().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {
        console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    });
  }
}
