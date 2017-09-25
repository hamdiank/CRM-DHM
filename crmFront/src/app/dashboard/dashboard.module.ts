import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardComponent} from "./dashboard.component";
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {dashroutes} from "./dashbord-route.module";
import {NavigationComponent} from "../shared/header-navigation/navigation.component";
import {BreadcrumbComponent} from "app/shared/breadcrumb/breadcrumb.component";
import {SidebarComponent} from "app/shared/sidebar/sidebar.component";
import {RightSidebarComponent} from "../shared/right-sidebar/rightsidebar.component";


@NgModule({
  imports: [
    CommonModule,
      FormsModule,
      RouterModule.forChild(dashroutes),

  ],
  declarations: [DashboardComponent,
      NavigationComponent,
      BreadcrumbComponent,
      SidebarComponent,
      RightSidebarComponent]
})
export class DashboardModule { }
