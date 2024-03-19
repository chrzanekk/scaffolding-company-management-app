import {Component, OnInit} from '@angular/core';
import {Account} from "../../../models/account.model";
import {FormBuilder, Validators} from '@angular/forms';
import {Eroles} from "../../../models/enums/eroles.string";
import {AuthService} from "../../../services/account/auth.service";
import {Observable} from "rxjs";


@Component({
  selector: 'app-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class ProfileComponent implements OnInit {
  accountCache$: Observable<Account | null>
  success = false;
  authorities?: IterableIterator<Eroles> | undefined;
  accountForm = this.fb.group({
    username: ['', [Validators.required,
      Validators.minLength(4),
      Validators.maxLength(25),
      Validators.pattern('^[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$|^[_.@A-Za-z0-9-]+$')]],
    email: ['', [Validators.required,
      Validators.email]],
  });

  constructor(private authService: AuthService, private fb: FormBuilder) {
    this.accountCache$ = authService.accountCache$;
    // debugger;
  }

  ngOnInit(): void {

  }

  protected readonly JSON = JSON;
}
