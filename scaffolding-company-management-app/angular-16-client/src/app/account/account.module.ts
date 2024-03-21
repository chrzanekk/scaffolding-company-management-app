import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {accountState} from "./account.route";
import {UserRegisterComponent} from "./register/user-register.component";
import {ProfileComponent} from "./profile/user-profile.component";
import {UserLoginComponent} from "./login/user-login.component";
import {InitPasswordResetComponent} from "./init-password-reset/init-password-reset.component";
import {PasswordResetComponent} from "./password-reset/password-reset.component";
import {SharedModule} from "../shared/shared.modules";


@NgModule({
  imports:
    [SharedModule,
      RouterModule.forChild(accountState)],
  declarations: [
    UserRegisterComponent,
    ProfileComponent,
    UserLoginComponent,
    PasswordResetComponent,
    InitPasswordResetComponent
  ]
})
export class AccountModule {
}
