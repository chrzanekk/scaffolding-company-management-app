import {Component} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {IUserRegister, UserRegister} from "../../models/user-register.model";

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent {
  doNotMatch = false;
  error = false;
  errorEmailExists = false;
  errorUserExists = false;
  success = false;

  constructor(private builder: FormBuilder,
              private toastr: ToastrService,
              private authService: AuthService,
              private router: Router) {
  }

  registerForm = this.builder.group({
    username: this.builder.control('',
      Validators.compose([
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(25),
        Validators.pattern('^[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$|^[_.@A-Za-z0-9-]+$'),])),
    email: this.builder.control('',
      Validators.compose([
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(70),
        Validators.email])),
    password: this.builder.control('',
      Validators.compose([
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(50)])),
    confirmPassword: this.builder.control('',
      Validators.compose([
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(50)])),
  });

  proceedRegistration() {
    const password = this.registerForm.get(['password'])!.value;
    const confirmPassword = this.registerForm.get(['confirmPassword'])!.value;
    if (password !== confirmPassword) {
      this.doNotMatch = true;
    } else {
      const registerUser = this.createFromForm();
      this.authService.register(registerUser).subscribe(res => {
        this.toastr.success('Registered successfully, confirmation email sent');
      })
    }
  }

  private createFromForm(): IUserRegister {
    return {
      ...new UserRegister(),
      username: this.registerForm.get(['username'])!.value,
      email: this.registerForm.get(['email'])!.value,
      password: this.registerForm.get(['password'])!.value,
    };
  }
}
