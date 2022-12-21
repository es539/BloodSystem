import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { signUpAComponent } from './signUp-Authority/signUpA.component'
import { signInAComponent } from './signIn-Authority/signInA.component'
import { signInIComponent } from './signIn-Individual/signInI.component'
import { signUpIComponent } from './signUp-Individual/signUpI.component'
import { profileAComponent } from './profile-Authority/profileA.component'

const routes: Routes = [
  { path: '' ,redirectTo: 'home' , pathMatch: 'full' },
  { path: 'home', component:HomeComponent},
  { path: 'signUpA', component:signUpAComponent},
  { path: 'signInA', component:signInAComponent},
  { path: 'signInI', component:signInIComponent},
  { path: 'signUpI', component:signUpIComponent},
  { path: 'profileA', component:profileAComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
