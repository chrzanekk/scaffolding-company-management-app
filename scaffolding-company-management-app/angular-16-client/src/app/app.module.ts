import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FuelTypeAddComponent} from './components/fuel-type-add/fuel-type-add.component';
import {FuelTypeDetailsComponent} from './components/fuel-type-details/fuel-type-details.component';
import {FuelTypeListComponent} from './components/fuel-type-list/fuel-type-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './components/home/home.component';
import {ProfileComponent} from './components/user-profile/user-profile.component';
import {UserRegisterComponent} from './components/user-register/user-register.component';
import {UserLoginComponent} from './components/user-login/user-login.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from "ngx-toastr";
import {UsersComponent} from './components/users/users.component';
import {UpdatePopupComponent} from './components/update-popup/update-popup.component';
import {CommonModule} from "@angular/common";
import {httpInterceptorProviders} from "./helpers/auth.interceptor";
import {NgxWebstorageModule} from "ngx-webstorage";
import {JwtInterceptor} from "./helpers/jwt.interceptor";

@NgModule({
  declarations: [
    AppComponent,
    FuelTypeAddComponent,
    FuelTypeDetailsComponent,
    FuelTypeListComponent,
    HomeComponent,
    ProfileComponent,
    UserRegisterComponent,
    UserLoginComponent,
    UsersComponent,
    UpdatePopupComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    CommonModule,
    NgxWebstorageModule.forRoot({ prefix: 'scma', separator: '-' }),
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true}, httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
