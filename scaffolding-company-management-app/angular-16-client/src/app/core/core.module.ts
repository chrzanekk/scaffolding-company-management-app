import {DatePipe} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {LOCALE_ID, NgModule} from "@angular/core";
import {Title} from "@angular/platform-browser";
import {FaIconLibrary} from "@fortawesome/angular-fontawesome";
import {NgbDateAdapter, NgbDatepickerConfig} from "@ng-bootstrap/ng-bootstrap";
import {NgxWebstorageModule} from "ngx-webstorage";
import {fontAwesomeIcons} from "./icons/font-awesome-icons";
import {NgbDateMomentAdapter} from "../shared/util/datepicker-adapter";
import moment from "moment";


@NgModule({
  imports: [
    HttpClientModule,
    NgxWebstorageModule.forRoot({prefix: '', separator: '-'}),
  ],
  providers: [
    Title,
    {
      provide: LOCALE_ID,
      useValue: 'pl',
    },
    {provide: NgbDateAdapter, useClass: NgbDateMomentAdapter},
    DatePipe,
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: AuthInterceptor,
    //   multi: true,
    // },
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: AuthExpiredInterceptor,
    //   multi: true,
    // },
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: ErrorHandlerInterceptor,
    //   multi: true,
    // },
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: NotificationInterceptor,
    //   multi: true,
    // },
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: LoadingInterceptor,
    //   multi: true,
    // },
  ],
})
export class CoreModule {
  constructor(iconLibrary: FaIconLibrary, dpConfig: NgbDatepickerConfig) {
    iconLibrary.addIcons(...fontAwesomeIcons);
    dpConfig.minDate = {year: moment().year() - 100, month: 1, day: 1};
  }
}
