import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router';
import { LoginService } from '../services';

@Component({
    selector: 'nav-bar',
    directives: [ROUTER_DIRECTIVES],
    providers: [LoginService],
    templateUrl: 'app/components/nav-bar.component.html'
})
export class NavBarComponent {
    /**
     *
     */
    constructor(private loginService: LoginService) {
    }
}