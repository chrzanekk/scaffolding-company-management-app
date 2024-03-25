import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {ToastrModule} from 'ngx-toastr';
import {SharedLibsModule} from './shared-libs.module';
import {UtilModule} from './util/util.module';

@NgModule({
  imports: [
    SharedLibsModule,
    ToastrModule.forRoot({
      positionClass: 'toast-bottom-right',
      preventDuplicates: true,
    }),
    RouterModule,
    UtilModule
  ],
  declarations: [
    // HasAnyAuthorityDirective,
  ],
  exports: [
    SharedLibsModule,
    // HasAnyAuthorityDirective,
  ],
})
export class SharedModule {}
