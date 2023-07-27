import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {LocalStorageService} from 'ngx-webstorage';
import {Observable} from "rxjs";

const BASE_URL = 'http://localhost:8080/';


@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(private localStorage: LocalStorageService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (!req || !req.url || (req.url.startsWith('http') && !(BASE_URL && req.url.startsWith(BASE_URL)))) {
      return next.handle(req);
    }

    const token = this.localStorage.retrieve('authenticationToken');
    if (token) {
      req = req.clone({
        setHeaders: {
          Authorization: 'Bearer ' + token,
        },
      });
    }
    return next.handle(req);
  }
}
