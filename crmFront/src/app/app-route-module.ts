
import {Routes} from "@angular/router";

export const routes: Routes = [
    {path:'login',loadChildren: './login/login.module#LoginModule'
    },
    {
        path:'forgetpwd',loadChildren:'./forgetpwd/forgetpwd.module#ForgetpwdModule'
    },
    {
        path: '',loadChildren: './dashboard/dashboard.module#DashboardModule'
    }
];