import { NgModule } from '@angular/core';
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

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const appRoutingProviders: any[] = [
	UserListComponent,
	ProjectListComponent, ProjectDetailComponent,
	LoginComponent,
	RegisterComponent,
	HomeComponent,
	ReviewListComponent, ReviewAddComponent,
	PageNotFoundComponent
];