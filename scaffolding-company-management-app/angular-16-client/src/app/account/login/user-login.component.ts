import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";
import {LoginRequest} from "../../core/login/login.model";
import {LoginService} from "../../core/login/login.service";
import {Observable} from "rxjs";
import {Account} from "../../core/account/account.model";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  accountCache$: Observable<Account | null>
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
              private loginService: LoginService,
              private router: Router) {
    this.accountCache$ = authService.accountCache$;
  }

  ngOnInit() {
    this.loginForm = this.builder.group({
      username: this.builder.control('',
        [Validators.required]),
      password: this.builder.control('', [Validators.required])
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.loginForm.controls;
  }

  login(): void {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    } else {
      const loginUser = this.createFromForm();
      this.loginService.login(loginUser).subscribe({
        next: () => {
          this.isLoginFailed = false;
          this.isLoggedIn = true;
          this.toastr.success('Zalogowano pomyślnie');
          this.router.navigate(['']);
        },
        error: (err: { error: { message: string; }; }) => {
          this.errorMessage = err.error.message;
          this.toastr.error('Błąd logowania: ' + err.error.message)
          this.isLoginFailed = true;
        }
      });

    }
  }

  createFromForm(): LoginRequest {
    return {
      ...new LoginRequest(),
      username: this.loginForm.get(['username'])!.value,
      password: this.loginForm.get(['password'])!.value
    };
  }

  resetForm() {
    this.submitted = false;
    this.loginForm.reset();
  }

  requestResetPassword() {
    this.router.navigate(['account/init-password-reset'])
  }

}
