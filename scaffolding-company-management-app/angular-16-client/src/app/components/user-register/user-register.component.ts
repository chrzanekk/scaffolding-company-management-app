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

  constructor(private builder: FormBuilder,
              private toastr: ToastrService,
              private authService: AuthService,
              private router: Router) {
  }

  registerForm = this.builder.group({
    id: this.builder.control('', Validators.compose([Validators.required])),
    username: this.builder.control('', Validators.required),
    email: this.builder.control('', Validators.compose([Validators.required, Validators.email])),
    password: this.builder.control('', Validators.required)
  });

  proceedRegistration() {
    if (this.registerForm.valid) {
      const registerUser = this.createFromForm();
      this.authService.register(registerUser).subscribe(res => {
        this.toastr.success('Registered successfully, confirmation email sent');
        this.router.navigate(['home']).then(r => true);
      })
    } else {
      this.toastr.warning('Enter correct data');
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
