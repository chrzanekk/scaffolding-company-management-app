import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FuelTypeListComponent} from "./components/fuel-type-list/fuel-type-list.component";
import {FuelTypeDetailsComponent} from "./components/fuel-type-details/fuel-type-details.component";
import {FuelTypeAddComponent} from "./components/fuel-type-add/fuel-type-add.component";
import {HomeComponent} from "./components/home/home.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'fuelTypes', component: FuelTypeListComponent},
  {path: 'home', component: HomeComponent},
  {path: 'fuelTypes/:id', component: FuelTypeDetailsComponent},
  {path: 'add', component: FuelTypeAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}