import {Route} from '@angular/router';
import {ProfileComponent} from './user-profile.component';

export const userProfileRoute: Route = {
  path: 'profile',
  component: ProfileComponent,
  data: {
    authorities: [],
    pageTitle: 'Profil użytkownika',
  },
};
