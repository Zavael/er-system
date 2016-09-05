import { Component } from '@angular/core';
import { NavBarComponent } from './components';
import { LoginService, RegisterService } from './services';
import {HTTP_PROVIDERS} from '@angular/http';
import {ROUTER_DIRECTIVES} from '@angular/router';

@Component({
	selector: 'my-app',
	directives: [ROUTER_DIRECTIVES],
	providers: [LoginService, RegisterService, HTTP_PROVIDERS],
	template: `
    <nav-bar></nav-bar>
	<div class="ui text container" style="padding-top:65px;">
    	<router-outlet></router-outlet>
	</div>
	`
})
export class AppComponent { }
