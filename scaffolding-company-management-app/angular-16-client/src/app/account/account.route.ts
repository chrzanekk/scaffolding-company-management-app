import {Routes} from "@angular/router";
import {userRegisterRoute} from "./register/user-register.route";
import {userLoginRoute} from "./login/user-login.route";
import {userProfileRoute} from "./profile/user-profile.route";
import {passwordResetRoute} from "./password-reset/password-reset.route";
import {initPasswordResetRoute} from "./init-password-reset/init-password-reset.route";


const ACCOUNT_ROUTES = [
  userRegisterRoute,
  userLoginRoute,
  userProfileRoute,
  passwordResetRoute,
  initPasswordResetRoute
];

export const accountState: Routes = [
  {
    path: '',
    children: ACCOUNT_ROUTES
  }
]
