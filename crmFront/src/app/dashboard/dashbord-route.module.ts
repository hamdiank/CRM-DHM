import {Routes} from "@angular/router";
import {DashboardComponent} from "./dashboard.component";
import {HomeComponent} from "./home/home.component";

export const dashroutes: Routes = [
    {path:'',component:DashboardComponent,
        children: [
            {path:'',loadChildren:'./home/home.module#HomeModule'}
        ]

    }]
