import {Component, OnInit} from '@angular/core';
import {Account} from "../../../models/account.model";
import {FormBuilder, Validators} from '@angular/forms';
import {AccountService} from "../../../services/account/account.service";
import {Eroles} from "../../../models/enums/eroles.string";


@Component({
  selector: 'app-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class ProfileComponent implements OnInit {
  account!: Account;
  success = false;
  authorities!: Eroles[];
  accountForm = this.fb.group({
    username: [undefined, [Validators.required,
      Validators.minLength(4),
      Validators.maxLength(25),
      Validators.pattern('^[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$|^[_.@A-Za-z0-9-]+$')]],
    email: [undefined, [Validators.required,
      Validators.email]],
  });

  constructor(private accountService: AccountService, private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.accountService.identity().subscribe(account => {
      if (account) {
        this.accountForm.patchValue({
          username: account.username,
          email: account.email,
        });
        this.account = account;
        this.authorities = account.authorities;
      }
    })
  }

}
