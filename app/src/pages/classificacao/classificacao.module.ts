import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ClassificacaoPage } from './classificacao';

@NgModule({
  declarations: [
    ClassificacaoPage,
  ],
  imports: [
    IonicPageModule.forChild(ClassificacaoPage),
  ],
  exports: [
    ClassificacaoPage
  ]
})
export class ClassificacaoPageModule {}
