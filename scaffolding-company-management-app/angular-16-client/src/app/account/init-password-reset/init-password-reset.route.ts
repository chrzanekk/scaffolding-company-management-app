import {Route} from '@angular/router';
import {InitPasswordResetComponent} from './init-password-reset.component';

export const initPasswordResetRoute: Route = {
  path: 'init-password-reset',
  component: InitPasswordResetComponent,
  data: {
    authorities: [],
    pageTitle: 'Resetowanie hasła',
  },
};
