import { Component } from '@angular/core';
import { NavBarComponent } from './components';
import { LoginService, RegisterService, ProjectService, HeadersService } from './services';

@Component({
	selector: 'my-app',
	providers: [LoginService, RegisterService, ProjectService, HeadersService],
	template: `
    <nav-bar></nav-bar>
	<div class="ui text container" style="padding-top:65px;">
    	<router-outlet></router-outlet>
	</div>
	`
})
export class AppComponent { }
