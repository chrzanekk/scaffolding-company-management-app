import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './home/home.component';
import {ProfileComponent} from './account/profile/user-profile.component';
import {UserRegisterComponent} from './account/register/user-register.component';
import {UserLoginComponent} from './account/login/user-login.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from "ngx-toastr";
import {UsersComponent} from './entities/users/users.component';
import {CommonModule} from "@angular/common";
import {httpInterceptorProviders} from "./helpers/auth.interceptor";
import {PasswordResetComponent} from './account/password-reset/password-reset.component';
import {InitPasswordResetComponent} from './account/init-password-reset/init-password-reset.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {NgxWebstorageModule} from "ngx-webstorage";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProfileComponent,
    UserRegisterComponent,
    UserLoginComponent,
    UsersComponent,
    PasswordResetComponent,
    InitPasswordResetComponent,

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
    NgxWebstorageModule.forRoot({prefix: '', separator: '-'}),
    NgbModule,
    FontAwesomeModule,
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
