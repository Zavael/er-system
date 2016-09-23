// - Routes instead of RouteConfig
// - RouterModule instead of provideRoutes
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {
	ProjectPersonListComponent,
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
		redirectTo: 'home',
		pathMatch: 'full'
	},
	{
		path: 'projects',
		component: ProjectListComponent,
		// children: [
		// 	{
		// 		path: ':id',
		// 		component: ProjectDetailComponent
		// 	}
		// ]
	},
	{ path: 'projects/:id', component: ProjectDetailComponent },
	{ path: 'home', component: HomeComponent },
	{ path: 'login', component: LoginComponent },
	{ path: 'register', component: RegisterComponent },
	{ path: '**', pathMatch: 'full', component: PageNotFoundComponent }
];

// - Updated Export
export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

export const appRoutingProviders: any[] = [
	ProjectPersonListComponent,
	ProjectListComponent, ProjectDetailComponent,
	LoginComponent,
	RegisterComponent,
	HomeComponent,
	ReviewListComponent, ReviewAddComponent,
	PageNotFoundComponent
];
