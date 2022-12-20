import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { signUpAComponent } from './signUp-Authority/signUpA.component'
import { signInAComponent } from './signIn-Authority/signInA.component'


const routes: Routes = [
  { path: '' ,redirectTo: 'home' , pathMatch: 'full' },
  { path: 'home', component:HomeComponent},
  { path: 'signUpA', component:signUpAComponent},
  { path: 'signInA', component:signInAComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
