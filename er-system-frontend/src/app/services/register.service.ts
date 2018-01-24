import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import { User } from '../models/user';

@Injectable()
export class RegisterService {
    /**
     *
     */
    constructor(private http: Http) { }

    /**
     * sendUser
     */
    public sendUser(user: User) {
        // let url = "http://localhost:8080/user/register";
        // let header = new Headers({ 'Content-Type': 'application/json' });

        // return this.http.post(url, JSON.stringify(user), { headers: header });
		return Observable.create((subscriber) => subscriber.next(user));
    }
}