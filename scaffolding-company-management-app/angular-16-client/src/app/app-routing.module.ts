import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {navbarRoute} from "./layouts/navbar/navbar.route";


const LAYOUT_ROUTES = [navbarRoute];

@NgModule({
  imports: [RouterModule.forRoot(
    [
      //todo add this when admin panel will be implemented
      //
      // {
      //   path: 'admin',
      //   data: {
      //     authorities: [Authority.ADMIN],
      //   },
      //   canActivate: [UserRouteAccessService],
      //   loadChildren: () => import('./admin/admin-routing.module').then(m => m.AdminRoutingModule),
      // },
      {
        path: '',
        loadChildren: () => import('./account/account.module').then(m => m.AccountModule),
      },
      ...LAYOUT_ROUTES,
    ]
  )],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
