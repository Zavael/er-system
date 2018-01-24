import {Component} from '@angular/core';
import { LoginService } from '../services';

@Component({
    selector: 'nav-bar',
    templateUrl: './nav-bar.component.html'
})
export class NavBarComponent {
    /**
     *
     */
    constructor(private loginService: LoginService) {
    }
}