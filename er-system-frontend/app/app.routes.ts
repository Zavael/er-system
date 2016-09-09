// - Routes instead of RouteConfig
// - RouterModule instead of provideRoutes
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {
	UserListComponent,
	ProjectListComponent,
	ProjectDetailComponent,
	LoginComponent,
	RegisterComponent,
	HomeComponent,
	ReviewListComponent,
	ReviewAddComponent,
	PageNotFoundComponent
} from './components';

const routes: Routes = [
	{
		path: '',
		redirectTo: 'login',
		pathMatch: 'full'
	},
	{
		path: 'projects',
		component: ProjectListComponent,
		// children: [
		// 	{
		// 		path: ':id',
		// 		component: PersonListComponent
		// 	}
		// ]
	},
	{ path: 'home', component: HomeComponent },
	{ path: 'login', component: LoginComponent },
	{ path: 'register', component: RegisterComponent },
	{ path: '**', pathMatch: 'full', component: PageNotFoundComponent }
];

// - Updated Export
export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

export const appRoutingProviders: any[] = [
	UserListComponent,
	ProjectListComponent, ProjectDetailComponent,
	LoginComponent,
	RegisterComponent,
	HomeComponent,
	ReviewListComponent, ReviewAddComponent,
	PageNotFoundComponent
];
