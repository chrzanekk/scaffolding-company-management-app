import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {UserLogin} from "../../models/user-login.model";
import {StorageService} from "../../services/storage.service";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  submitted = false;
  isLoggedIn = false;
  isLoginFailed = false;
  roles: string[] = [];
  errorMessage = '';
  loginForm: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private builder: FormBuilder,
              private toastr: ToastrService,
              private authService: AuthService,
              private storageService: StorageService,
              private router: Router) {
  }

  ngOnInit() {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
    }
    this.loginForm = this.builder.group({
      username: this.builder.control('',
        [Validators.required]),
      password: this.builder.control('', [Validators.required])
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.loginForm.controls;
  }
//todo create AccountService to take information about user for userProfile also
  login(): void {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    } else {
      const loginUser = this.createFromForm();
      this.authService.login(loginUser).subscribe({
        next: res => {
          this.isLoginFailed = false;
          this.isLoggedIn = true;
          this.reloadPage();
        },
        error: err => {
          this.errorMessage = err.error.message;
          this.isLoginFailed = true;
        }
      });
    }
  }

  reloadPage(): void {
    window.location.reload();
  }

  createFromForm(): UserLogin {
    return {
      ...new UserLogin(),
      username: this.loginForm.get(['username'])!.value,
      password: this.loginForm.get(['password'])!.value
    };
  }

  resetForm() {
    this.submitted = false;
    this.loginForm.reset();
  }
}
