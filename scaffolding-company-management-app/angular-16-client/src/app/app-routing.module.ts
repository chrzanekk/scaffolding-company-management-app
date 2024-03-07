import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FuelTypeListComponent} from "./components/fuel-type-list/fuel-type-list.component";
import {FuelTypeDetailsComponent} from "./components/fuel-type-details/fuel-type-details.component";
import {FuelTypeAddComponent} from "./components/fuel-type-add/fuel-type-add.component";
import {HomeComponent} from "./components/home/home.component";
import {UsersComponent} from "./components/users/users.component";
import {UserRegisterComponent} from "./components/account/register/user-register.component";
import {UserLoginComponent} from "./components/account/login/user-login.component";
import {ProfileComponent} from "./components/account/profile/user-profile.component";

const routes: Routes = [
  {path: 'fuelTypes', component: FuelTypeListComponent},
  {path: '', component: HomeComponent},
  {path: 'register', component: UserRegisterComponent},
  {path: 'login', component: UserLoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'user', component: UsersComponent},
  {path: 'fuelTypes/:id', component: FuelTypeDetailsComponent},
  {path: 'add', component: FuelTypeAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
