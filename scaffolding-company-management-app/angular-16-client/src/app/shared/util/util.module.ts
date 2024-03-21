import {NgModule} from '@angular/core';
import {LongTextWrapperPipe} from './long-text-wrapper-pipe';

@NgModule({
  declarations: [LongTextWrapperPipe],
  exports: [LongTextWrapperPipe],
})
export class UtilModule {}
