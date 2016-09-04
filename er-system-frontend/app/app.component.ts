import { Component } from '@angular/core';
import { NavBarComponent } from './components';

@Component({
	selector: 'my-app',
	directives: [NavBarComponent],
	template: `
    <nav-bar></nav-bar>
    <div class="ui main text container">
    <router-outlet></router-outlet>
    </div>
  `
})
export class AppComponent { }
