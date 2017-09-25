import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {ForgetpwdComponent} from "./forgetpwd.component";
import {FormsModule} from "@angular/forms";
const routes : Routes= [
    {path:'',component:ForgetpwdComponent}
]

@NgModule({
  imports: [
    CommonModule,
      FormsModule,
      RouterModule.forChild(routes)
  ],
  declarations: [ForgetpwdComponent]
})
export class ForgetpwdModule { }
