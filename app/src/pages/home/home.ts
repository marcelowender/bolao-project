import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  palpitesRoot = 'PalpitesPage'
  usuarioRoot = 'UsuarioPage'
  classificacaoRoot = 'ClassificacaoPage'


  constructor(public navCtrl: NavController) {}

}
