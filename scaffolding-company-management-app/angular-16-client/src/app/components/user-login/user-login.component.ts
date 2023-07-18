import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {UserLogin} from "../../models/user-login.model";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  submitted = false;
  loginForm: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private builder: FormBuilder,
              private toastr: ToastrService,
              private authService: AuthService,
              private router: Router) {
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
      this.authService.login(loginUser).subscribe(res => {
        this.toastr.success(res.toString());
      })
    }
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
