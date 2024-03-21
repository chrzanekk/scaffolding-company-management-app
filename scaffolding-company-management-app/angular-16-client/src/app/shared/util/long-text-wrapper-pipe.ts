import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'longTextWrapperPipe',
})
export class LongTextWrapperPipe implements PipeTransform {
  transform(text: string, size: number): string {
    if (!text) {
      return '';
    } else if (text.length > size) {
      return text.substring(0, size) + '...';
    } else {
      return text;
    }
  }
}
