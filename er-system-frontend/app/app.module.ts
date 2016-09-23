import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { RouterModule }    from '@angular/router';
import { HttpModule }    from '@angular/http';
import { AppComponent }  from './app.component';
import { routing, appRoutingProviders } from './app.routes';
import { NavBarComponent, LoginComponent, RegisterComponent, HomeComponent, PageNotFoundComponent } from './components';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  declarations: [AppComponent, NavBarComponent].concat(appRoutingProviders),
  bootstrap: [AppComponent]
})
export class AppModule { }
