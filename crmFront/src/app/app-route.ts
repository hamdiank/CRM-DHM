
import {Route} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {DashboardComponent} from "./dashboard/dashboard.component";

export const AppRoute : Route[]=[
  {path:'login',component:LoginComponent},
  {path:'',component:DashboardComponent}
]

