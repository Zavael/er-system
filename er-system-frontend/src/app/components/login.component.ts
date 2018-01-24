import { Component, OnInit } from '@angular/core';
import { LoginService, PersonService } from '../services';
import { Person } from '../models';

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    providers: [PersonService]
})
export class LoginComponent implements OnInit {
    model: Person = new Person();
    private errorMessage: string = null;

    constructor(private loginService: LoginService, private userService: PersonService) { }

    ngOnInit() { }

    onSubmit(event: any) {
        console.debug('submitting login');
        event.preventDefault();
        this.errorMessage = null;
        this.userService.login(this.model).subscribe(
            result => this.onLoginResult(this.model, result),
            error => this.onLoginError(error)
        );
    }

    isLogged(): boolean {
        return this.loginService.isLogged();
    }

    onLoginResult(user: Person, result: any) {
        console.log(result);
        this.loginService.setLoggedUser(user, result);
        //this.router.navigate(['/home'])
    }

    onLoginError(error: any) {
        console.error(error);
        this.resetModel();
        this.errorMessage = error._body;
    }

    resetModel() {
        this.model = new Person();;
    }
}