import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{ HttpClientModule }from'@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { signInAComponent } from './signIn-Authority/signInA.component'
import { signInIComponent } from './signIn-Individual/signInI.component'
import { signUpAComponent } from './signUp-Authority/signUpA.component'
import { signUpIComponent } from './signUp-Individual/signUpI.component'
import { profileAComponent } from './profile-Authority/profileA.component'
import { profileIComponent } from './profile-Individual/profileI.component'
import { EditAComponent } from './Edit-profile-Authority/EditA.component'
import { EditIComponent } from './Edit-Profile-Individual/EditI.component'
import { ForgotPasswordAComponent } from './forgot-pass-Authority/forgotPassA.component';
import { ForgotPasswordIComponent } from './forgot-pass-Individual/forgotPassI.component';
import { WelcomeAComponent } from './welcome-Authority/welcomeA.component'
import { ThankComponent } from './thankDonation/thank.component'
import { DonationComponent } from './donation/donation.component'
import { InvalidDonateComponent } from './invalidDonate/invalidDonate.component'
import { DonationListComponent } from './donation-list/dList.component'
import { DonationTicketComponent } from './Donation-ticket/ticketDonation.component'
import { AcceptionListComponent } from './acception-list/aList.component'
import { HelperComponent } from './Helper/Helper.component'
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'

@NgModule({
  declarations: [
    AppComponent, 
    HomeComponent,
    signInAComponent,
    signInIComponent,
    signUpAComponent,
    signUpIComponent,
    profileAComponent,
    profileIComponent,
    EditAComponent,
    EditIComponent,
    ForgotPasswordAComponent,
    ForgotPasswordIComponent,
    WelcomeAComponent,
    ThankComponent,
    DonationComponent,
    InvalidDonateComponent,
    DonationListComponent,
    DonationTicketComponent,
    AcceptionListComponent,
    HelperComponent
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
