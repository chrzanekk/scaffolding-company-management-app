import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";
import {IRequestPasswordReset, RequestPasswordReset} from "../../core/account/request-password-reset.model";

@Component({
  selector: 'app-init-password-reset',
  templateUrl: './init-password-reset.component.html',
  styleUrls: ['./init-password-reset.component.css']
})
export class InitPasswordResetComponent implements OnInit {
  submitted = false;
  emailCheckFailed = false;
  errorMessage = '';
  initResetPasswordForm: FormGroup = new FormGroup({
    email: new FormControl('')
  });


  constructor(private builder: FormBuilder,
              private toastr: ToastrService,
              private authService: AuthService,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.initResetPasswordForm = this.builder.group({
      email: this.builder.control('', [
        Validators.required,
        Validators.email])
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.initResetPasswordForm.controls;
  }

  processInitPasswordReset() {
    this.submitted = true;
    if (this.initResetPasswordForm.invalid) {
      return;
    } else {
      const initResetPassword = this.createFromForm();
      this.authService.requestPasswordReset(initResetPassword).subscribe({
        next: () => {
          this.toastr.success('Prośba o zresetowanie hasła została wysłana.')
          this.router.navigate([''])
          this.emailCheckFailed = false;
        },
        error: (err: { error: { message: string; }; }) => {
          this.errorMessage = err.error.message;
          this.toastr.error('Błąd resetowania: ' + err.error.message)
          this.emailCheckFailed = true;
        }
      });
    }
  }

  resetForm() {
    this.submitted = false;
    this.initResetPasswordForm.reset();
  }

  createFromForm(): IRequestPasswordReset {
    return {
      ...new RequestPasswordReset(),
      email: this.initResetPasswordForm.get(['email'])!.value,
    };
  }
}
