import { Component, OnInit } from '@angular/core';
import { LoginService, UserService } from '../services';
import { User } from '../models';

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    providers: [UserService]
})
export class LoginComponent implements OnInit {
    model: User = new User();
    private errorMessage: string = null;

    constructor(private loginService: LoginService, private userService: UserService) { }

    ngOnInit() { }

    onSubmit(event) {
        console.debug('submitting login');
        event.preventDefault();
        this.errorMessage = null;
        this.userService.login(this.model).subscribe(
            result => this.onLoginResult(result),
            error => this.onLoginError(error)
        );
    }

    isLogged(): boolean {
        return this.loginService.isLogged();
    }

    onLoginResult(result) {
        console.log(result);
        this.loginService.setLoggedUser(result.user, result.token);
        //this.router.navigate(['/home'])
    }

    onLoginError(error) {
        console.error(error);
        this.resetModel();
        this.errorMessage = error._body;
    }

    resetModel() {
        this.model = new User();;
    }
}