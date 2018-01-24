import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
//import { routing, appRoutingProviders } from './app.routes';
import { AppRoutingModule, appRoutingProviders } from './app-routing.module';
import { NavBarComponent, LoginComponent, RegisterComponent, HomeComponent, PageNotFoundComponent } from './components';
import { LoginService, RegisterService, ProjectService, HeadersService } from './services';
import { Http } from '@angular/http';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  declarations: [AppComponent, NavBarComponent].concat(appRoutingProviders),
  providers: [LoginService, RegisterService, ProjectService, HeadersService, Http],
  // declarations: [AppComponent, NavBarComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
