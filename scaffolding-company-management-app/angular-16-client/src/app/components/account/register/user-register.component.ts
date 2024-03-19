import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {IUserRegister, UserRegister} from "../../../models/user-register.model";
import Validation from "../../../utils/validation";
import {AuthService} from "../../../services/account/auth.service";

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {
  doNotMatch = false;
  success = false;
  submitted = false;
  registerForm: FormGroup = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    confirmPassword: new FormControl('')
  });


  constructor(private builder: FormBuilder,
              private toastr: ToastrService,
              private authService: AuthService,
              private router: Router) {

  }

  ngOnInit() {
    this.registerForm = this.builder.group({
        username: this.builder.control('',
          [
            Validators.required,
            Validators.minLength(4),
            Validators.maxLength(25),
            Validators.pattern('^[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$|^[_.@A-Za-z0-9-]+$'),]),
        email: this.builder.control('',
          [
            Validators.required,
            Validators.email]),
        password: this.builder.control('',
          [
            Validators.required,
            Validators.minLength(8),
            Validators.maxLength(50)]),
        confirmPassword: this.builder.control('', [
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(50)]),
      },
      {
        validators: [Validation.match('password', 'confirmPassword')]
      });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.registerForm.controls;
  }


  proceedRegistration() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    } else {
      const registerUser = this.createFromForm();
      this.authService.register(registerUser).subscribe(() => {
        this.toastr.success('Registered successfully, confirmation email sent');
        this.router.navigate([''])
      })
    }
  }

  resetForm() {
    this.submitted = false;
    this.registerForm.reset();
  }


  createFromForm(): IUserRegister {
    return {
      ...new UserRegister(),
      username: this.registerForm.get(['username'])!.value,
      email: this.registerForm.get(['email'])!.value,
      password: this.registerForm.get(['password'])!.value,
    };
  }
}
