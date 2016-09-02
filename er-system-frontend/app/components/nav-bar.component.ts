import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router';
import { LoginService } from '../services';

@Component({
    selector: 'nav-bar',
    directives: [ROUTER_DIRECTIVES],
    templateUrl: 'app/components/nav-bar.component.html'
})
export class NavBarComponent {
    /**
     *
     */
    constructor(private loginService: LoginService) {
    }

    onClick() {
        console.log("login");
    }
}