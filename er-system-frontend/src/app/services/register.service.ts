import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import { Person } from '../models';
import { HeadersService } from '../services';
import { ErrorUtil } from '../utils';

@Injectable()
export class RegisterService {

    private errorUtil: ErrorUtil = new ErrorUtil();

    constructor(private http: Http, private headersService: HeadersService) { }

    /**
     * sendUser
     */
    public sendPerson(person: Person) {
        // let url = "http://localhost:8080/user/register";
        // let header = new Headers({ 'Content-Type': 'application/json' });

        // return this.http.post(url, JSON.stringify(user), { headers: header });
        console.debug('sendUser: ' + person);
        return this.http
            .get(this.headersService.publicUrl + '/register', this.headersService.getJsonHeaders())
            .map(res => res.json)
            .catch(this.errorUtil.simpleHandler);
    }
}