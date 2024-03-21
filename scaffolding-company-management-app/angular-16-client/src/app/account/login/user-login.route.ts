import {Route} from '@angular/router';
import {UserLoginComponent} from './user-login.component';

export const userLoginRoute: Route = {
  path: 'login',
  component: UserLoginComponent,
  data: {
    authorities: [],
    pageTitle: 'Logowanie',
  },
};
