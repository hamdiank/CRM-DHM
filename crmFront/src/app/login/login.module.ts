import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login.component";
import {FormsModule} from "@angular/forms";

const routes: Routes = [
    {path:'',component:LoginComponent}]


@NgModule({
  imports: [
    CommonModule,
      FormsModule,
      RouterModule.forChild(routes)
  ],
  declarations: [LoginComponent]
})
export class LoginModule { }
