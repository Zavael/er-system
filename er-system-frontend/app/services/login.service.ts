import { Injectable } from '@angular/core';
import { User } from '../models';

@Injectable()
export class LoginService {

    private logged: boolean = false;
    private _user: User = null;
    private _token: string = null;

    constructor() { }

    setLoggedUser(user: User, token: string) {
        this._user = user;
        this._token = token;
    }

    logout() {
        this._user = null;
        this._token = null;
    }

    isLogged(): boolean {
        return this._user != null && this._token != null;
    }

    get token(): string {
        return this._token;
    }

    get user() {
        return this._user;
    }
}