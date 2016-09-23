import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Person } from '../models';
import { HeadersService } from '../services';
import { ErrorUtil } from '../utils';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class PersonService {

    private errorUtil: ErrorUtil = new ErrorUtil();

    constructor(private http: Http, private headersService: HeadersService) { }

    public login(personModel: Person) {
        console.debug('logging ', personModel);
        return this.http
            .post(this.headersService.publicUrl + '/login', personModel, this.headersService.getJsonHeaders())
            .catch(this.errorUtil.simpleHandler);

        //return Observable.create((subscriber: any) => subscriber.next({ user: userModel, token: 'hhh' }));
    }
}