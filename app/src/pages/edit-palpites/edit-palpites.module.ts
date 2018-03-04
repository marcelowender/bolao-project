import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { EditPalpitesPage } from './edit-palpites';

@NgModule({
  declarations: [
    EditPalpitesPage,
  ],
  imports: [
    IonicPageModule.forChild(EditPalpitesPage),
  ],
  exports: [
    EditPalpitesPage
  ]
})
export class EditPalpitesPageModule {}
