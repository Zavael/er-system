// - Routes instead of RouteConfig
// - RouterModule instead of provideRoutes
import { Routes, RouterModule } from '@angular/router';
import { PersonListComponent, ProjectListComponent, LoginComponent, PageNotFoundComponent } from './components';

const routes: Routes = [
	{
		path: '',
		redirectTo: '',
		pathMatch: 'full'
	},
	{ path: 'projects', component: ProjectListComponent },
	{ path: 'login', component: LoginComponent },
	{ path: '**', pathMatch: 'full', component: PageNotFoundComponent }
];

// - Updated Export
export const routing = RouterModule.forRoot(routes);
