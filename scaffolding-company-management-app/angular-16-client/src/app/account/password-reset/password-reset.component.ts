import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AuthService} from "../auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import Validation from "../../utils/validation";
import {IPasswordReset, PasswordReset} from "../../core/account/password-reset.model";

@Component({
  selector: 'app-password-reset',
  templateUrl: './password-reset.component.html',
  styleUrls: ['./password-reset.component.css']
})
export class PasswordResetComponent implements OnInit {
  submitted = false;
  passwordMatch = false;
  errorMessage = '';
  initialized = false;
  token = '';
  resetPasswordForm: FormGroup = new FormGroup({
    password: new FormControl(''),
    confirmPassword: new FormControl('')
  });

  constructor(private builder: FormBuilder,
              private toastr: ToastrService,
              private authService: AuthService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      if (params['token']) {
        this.token = params['token'];
      }
      this.initialized = true;
    });

  this.resetPasswordForm= this.builder.group({
    password: this.builder.control('',
      [
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(50)]),
    confirmPassword: this.builder.control('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(50)]),
  }, {
    validators: [Validation.match('password', 'confirmPassword')]
  })
  }


  finishResetPassword() {
    this.submitted = true;
    if (this.resetPasswordForm.invalid) {
      return;
    } else {
      const passwordReset = this.createFromForm();
      this.authService.finishPasswordReset(passwordReset).subscribe({
        next: (message) => {
          this.toastr.success(message.message)
          this.router.navigate(['login'])
          this.passwordMatch = false;
          this.initialized = false;
        },
        error: (err: { error: { message: string; }; }) => {
          this.errorMessage = err.error.message;
          this.toastr.error("Błąd:" + err.error.message)
          this.passwordMatch = false;
          this.initialized = false;
        }
      })
    }
  }

  resetForm() {
    this.submitted = false;
    this.resetPasswordForm.reset();
  }

  get f(): { [key: string]: AbstractControl } {
    return this.resetPasswordForm.controls;
  }

  createFromForm(): IPasswordReset {
    return {
      ...new PasswordReset(),
      token: this.token,
      password: this.resetPasswordForm.get(['password'])!.value,
      confirmPassword: this.resetPasswordForm.get(['confirmPassword'])!.value,
    }
  }

}
