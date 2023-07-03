import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FuelTypeAddComponent} from './components/fuel-type-add/fuel-type-add.component';
import {FuelTypeDetailsComponent} from './components/fuel-type-details/fuel-type-details.component';
import {FuelTypeListComponent} from './components/fuel-type-list/fuel-type-list.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './components/home/home.component';
import {ProfileComponent} from './components/user-profile/user-profile.component';
import {UserRegisterComponent} from './components/user-register/user-register.component';
import {UserLoginComponent} from './components/user-login/user-login.component';

@NgModule({
  declarations: [
    AppComponent,
    FuelTypeAddComponent,
    FuelTypeDetailsComponent,
    FuelTypeListComponent,
    HomeComponent,
    ProfileComponent,
    UserRegisterComponent,
    UserLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
