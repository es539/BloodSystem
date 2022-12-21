import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { signUpAComponent } from './signUp-Authority/signUpA.component'
import { signInAComponent } from './signIn-Authority/signInA.component'
import { signInIComponent } from './signIn-Individual/signInI.component'
import { signUpIComponent } from './signUp-Individual/signUpI.component'
import { profileAComponent } from './profile-Authority/profileA.component'
import { profileIComponent } from './profile-Individual/profileI.component'
import { EditAComponent } from './Edit-profile-Authority/EditA.component'
import { EditIComponent } from './Edit-Profile-Individual/EditI.component'
import { ForgotPasswordAComponent } from './forgot-pass-Authority/forgotPassA.component';
import { ForgotPasswordIComponent } from './forgot-pass-Individual/forgotPassI.component';


const routes: Routes = [
  { path: '' ,redirectTo: 'home' , pathMatch: 'full' },
  { path: 'home', component:HomeComponent},
  { path: 'signUpA', component:signUpAComponent},
  { path: 'signInA', component:signInAComponent},
  { path: 'signInI', component:signInIComponent},
  { path: 'signUpI', component:signUpIComponent},
  { path: 'profileA', component:profileAComponent},
  { path: 'profileI', component:profileIComponent},
  { path: 'EditA', component:EditAComponent},
  { path: 'EditI', component:EditIComponent},
  { path: 'forgotA', component:ForgotPasswordAComponent},
  { path: 'forgotI', component:ForgotPasswordIComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
