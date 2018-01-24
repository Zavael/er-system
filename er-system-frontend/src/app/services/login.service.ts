import { Injectable } from '@angular/core';
import { Person } from '../models';

@Injectable()
export class LoginService {

    private logged: boolean = false;
    private _person: Person = null;
    private _token: string = null;

    constructor() { }

    setLoggedUser(person: Person, token: string) {
        this._person = person;
        this._token = token;
    }

    logout() {
        this._person = null;
        this._token = null;
    }

    isLogged(): boolean {
        return this._person != null && this._token != null;
    }

    get token(): string {
        return this._token;
    }

    get person() {
        return this._person;
    }
}