import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {

    private logged : boolean = false;

    constructor() { }

    checkLogin(){
        return this.logged;
    }

    setLogged(){
        this.logged = true;
    }

    getUserName(){
        return "newUser";
    }
}