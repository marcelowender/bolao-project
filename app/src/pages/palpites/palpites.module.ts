import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { PalpitesPage } from './palpites';

@NgModule({
  declarations: [
    PalpitesPage,
  ],
  imports: [
    IonicPageModule.forChild(PalpitesPage),
  ],
  exports: [
    PalpitesPage
  ]
})
export class PalpitesPageModule {}
