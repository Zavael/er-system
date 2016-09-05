import { Injectable } from '@angular/core';
import { User } from '../models';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class UserService {

    constructor() { }

    public login(userModel) {
        console.debug('logging ' + userModel);
        return Observable.create((subscriber) => subscriber.next({ user: userModel, token: 'hhh' }));
    }
}