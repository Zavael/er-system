// - Routes instead of RouteConfig
// - RouterModule instead of provideRoutes
import { Routes, RouterModule } from '@angular/router';
import { PersonListComponent, ProjectListComponent } from './components';

const routes: Routes = [
	{
		path: '',
		redirectTo: '/projects',
		pathMatch: 'full'
	},
	{
		path: 'projects',
		component: ProjectListComponent
	}
];

// - Updated Export
export const routing = RouterModule.forRoot(routes);
