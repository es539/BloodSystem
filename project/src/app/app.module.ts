import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{ HttpClientModule }from'@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { signUpAComponent } from './signUp-Authority/signUpA.component'
import { signInAComponent } from './signIn-Authority/signInA.component'
import { signInIComponent } from './signIn-Individual/signInI.component'
import { signUpIComponent } from './signUp-Individual/signUpI.component'
import { profileAComponent } from './profile-Authority/profileA.component'

import { NgbModule } from '@ng-bootstrap/ng-bootstrap'

@NgModule({
  declarations: [
    AppComponent, 
    HomeComponent,
    signUpAComponent,
    signInAComponent,
    signInIComponent,
    signUpIComponent,
    profileAComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
