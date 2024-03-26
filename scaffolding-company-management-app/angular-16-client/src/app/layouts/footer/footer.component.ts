import {Component} from '@angular/core';
import {VERSION} from '../../app.constants';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.css']
})
export class FooterComponent {
  version: string;
  title = 'Scaffolding Management App'

  constructor() {
    this.version = VERSION ? (VERSION.toLowerCase().startsWith('v') ? VERSION : 'v' + VERSION) : '';
  }
}
