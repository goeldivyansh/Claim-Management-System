import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SubmitClaimComponent } from './components/submit-claim/submit-claim.component';
import { ViewBillComponent } from './components/view-bill/view-bill.component';
import { ViewClaimComponent } from './components/view-claim/view-claim.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {
    path:"",
    component:HomeComponent,
    pathMatch:"full"
   },
   {
       
    path:"dashboard",
    component:DashboardComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]

   },
  {
    path:'login',
    component:LoginComponent,
    pathMatch:"full"
  },
  {
    path:'view-bills',
    component:ViewBillComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'view-claim',
    component:ViewClaimComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'submit-claim',
    component:SubmitClaimComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{enableTracing:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
