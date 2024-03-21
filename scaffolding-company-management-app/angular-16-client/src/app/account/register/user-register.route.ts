import {Route} from '@angular/router';
import {UserRegisterComponent} from './user-register.component';

export const userRegisterRoute: Route = {
  path: 'register',
  component: UserRegisterComponent,
  data: {
    authorities: [],
    pageTitle: 'Rejestracja',
  },
};
