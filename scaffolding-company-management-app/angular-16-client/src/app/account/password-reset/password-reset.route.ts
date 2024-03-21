import {Route} from '@angular/router';
import {PasswordResetComponent} from './password-reset.component';

export const passwordResetRoute: Route = {
  path: 'password-reset',
  component: PasswordResetComponent,
  data: {
    authorities: [],
    pageTitle: 'Reset hasła',
  },
};
