import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {MainComponent} from './layouts/main/main.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from "ngx-toastr";
import {CommonModule} from "@angular/common";
import {httpInterceptorProviders} from "./helpers/auth.interceptor";
import {NgxWebstorageModule} from "ngx-webstorage";
import {CoreModule} from "./core/core.module";
import {HomeModule} from "./home/home.module";
import {SharedModule} from "./shared/shared.modules";
import {NavbarComponent} from "./layouts/navbar/navbar.component";

@NgModule({
  declarations: [
    NavbarComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    AppRoutingModule,
    CoreModule,
    SharedModule,
    HomeModule,
    NgxWebstorageModule.forRoot({prefix: '', separator: '-'}),
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [MainComponent]
})
export class AppModule {
}
