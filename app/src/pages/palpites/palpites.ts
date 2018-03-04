import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { EditPalpitesPage } from '../edit-palpites/edit-palpites';
import { PalpiteService } from '../../providers/palpite-service/palpite-service';
import { FirebaseListObservable } from 'angularfire2/database';

@IonicPage()
@Component({
  selector: 'page-palpites',
  templateUrl: 'palpites.html',
})
export class PalpitesPage {
  items: FirebaseListObservable<any[]>;
  jogos: Array<any>;

  constructor(private navCtrl: NavController, private navParams: NavParams, private palpiteService: PalpiteService) {
    this.items = this.palpiteService.getAll();
    this.loadJogos();
  }

  loadJogos(){
    this.jogos = [{ data: new Date(),timeA:'Flamengo',timeB:'Atlético-MG',local:'Maracanã'},
    { data: new Date(),timeA:'Corinthians',timeB:'Chapecoense',local:'Arena Corinthians'},
    { data: new Date(),timeA:'Fluminense',timeB:'Santos',local:'Maracanã'},
    { data: new Date(),timeA:'Bahia',timeB:'Atlético-PR',local:'Arena Fonte Nova'},
    { data: new Date(),timeA:'Avaí',timeB:'Vitória',local:'Ressacada'},
    { data: new Date(),timeA:'Cruzeiro',timeB:'São Paulo',local:'Mineirão'},
    { data: new Date(),timeA:'Ponte Preta',timeB:'Sport Recife',local:'Moisés Lucarelli'},
    { data: new Date(),timeA:'Palmeiras',timeB:'Vasco',local:'Allianz Parque'},
    { data: new Date(),timeA:'Grêmio',timeB:'Botafogo',local:'Arena do Grêmio'},
    { data: new Date(),timeA:'Coritiba',timeB:'Atlético-GO',local:'Couto Pereira'},
    
    
    { data: new Date(),timeA:'Santos',timeB:'Coritiba',local:'Vila Belmiro'},
    { data: new Date(),timeA:'Chapecoense',timeB:'Palmeiras',local:'Arena Condá'},
    { data: new Date(),timeA:'Atlético-GO',timeB:'Flamengo',local:'Serra Dourada'},
    { data: new Date(),timeA:'Vasco',timeB:'Bahia',local:'São Januário'},
    { data: new Date(),timeA:'Vitória',timeB:'Corinthians',local:'Barradão'},
    { data: new Date(),timeA:'Atlético-PR',timeB:'Grêmio',local:'Arena da Baixada'},
    { data: new Date(),timeA:'Botafogo',timeB:'Ponte Preta',local:'Nilton Santos'},
    { data: new Date(),timeA:'Atlético-MG',timeB:'Fluminense',local:'Independência'},
    { data: new Date(),timeA:'Sport Recife',timeB:'Cruzeiro',local:'Ilha do Retiro'},
    { data: new Date(),timeA:'São Paulo',timeB:'Avaí',local:'Morumbi'},
    
    
    { data: new Date(),timeA:'São Paulo',timeB:'Palmeiras',local:'Morumbi'},
    { data: new Date(),timeA:'Vasco',timeB:'Fluminense',local:'São Januário'},
    { data: new Date(),timeA:'Vitória',timeB:'Coritiba',local:'Barradão'},
    { data: new Date(),timeA:'Atlético-MG',timeB:'Ponte Preta',local:'Independência'},
    { data: new Date(),timeA:'Atlético-PR',timeB:'Flamengo',local:'Arena da Baixada'},
    { data: new Date(),timeA:'Atlético-GO',timeB:'Corinthians',local:'Serra Dourada'},
    { data: new Date(),timeA:'Santos',timeB:'Cruzeiro',local:'Vila Belmiro'},
    { data: new Date(),timeA:'Botafogo',timeB:'Bahia',local:'Nilton Santos'},
    { data: new Date(),timeA:'Sport Recife',timeB:'Grêmio',local:'Ilha do Retiro'},
    { data: new Date(),timeA:'Chapecoense',timeB:'Avaí',local:'Arena Condá'},
    
    
    { data: new Date(),timeA:'Coritiba',timeB:'Atlético-PR',local:'Couto Pereira'},
    { data: new Date(),timeA:'Fluminense',timeB:'Vitória',local:'Maracanã'},
    { data: new Date(),timeA:'Corinthians',timeB:'Santos',local:'Arena Corinthians'},
    { data: new Date(),timeA:'Avaí',timeB:'Sport Recife',local:'Ressacada'},
    { data: new Date(),timeA:'Flamengo',timeB:'Botafogo',local:'Maracanã'},
    { data: new Date(),timeA:'Grêmio',timeB:'Vasco',local:'Arena do Grêmio'},
    { data: new Date(),timeA:'Palmeiras',timeB:'Atlético-MG',local:'Allianz Parque'},
    { data: new Date(),timeA:'Ponte Preta',timeB:'São Paulo',local:'Moisés Lucarelli'},
    { data: new Date(),timeA:'Cruzeiro',timeB:'Chapecoense',local:'Mineirão'},
    { data: new Date(),timeA:'Bahia',timeB:'Atlético-GO',local:'Arena Fonte Nova'},
    
    
    { data: new Date(),timeA:'Fluminense',timeB:'Atlético-PR',local:'Maracanã'},
    { data: new Date(),timeA:'Atlético-MG',timeB:'Avaí',local:'Independência'},
    { data: new Date(),timeA:'Coritiba',timeB:'Palmeiras',local:'Couto Pereira'},
    { data: new Date(),timeA:'Santos',timeB:'Botafogo',local:'Vila Belmiro'},
    { data: new Date(),timeA:'Chapecoense',timeB:'Grêmio',local:'Arena Condá'},
    { data: new Date(),timeA:'Sport Recife',timeB:'Flamengo',local:'Ilha do Retiro'},
    { data: new Date(),timeA:'Vasco',timeB:'Corinthians',local:'São Januário'},
    { data: new Date(),timeA:'Atlético-GO',timeB:'Ponte Preta',local:'Serra Dourada'},
    { data: new Date(),timeA:'São Paulo',timeB:'Vitória',local:'Morumbi'},
    { data: new Date(),timeA:'Bahia',timeB:'Cruzeiro',local:'Arena Fonte Nova'},
    
    ]

  }
  doInfinite(infiniteScroll) {
    console.log('Begin async operation');

    setTimeout(() => {
      for (let i = 0; i < 10; i++) {
        this.jogos.push( this.jogos.length );
      }

      console.log('Async operation has ended');
      infiniteScroll.complete();
    }, 500);
  }

  newPalpite() {
    this.navCtrl.push(EditPalpitesPage);
  }

  editItem(item: any) {
    this.navCtrl.push(EditPalpitesPage, { palpite: item });
  }

  removeItem(item: any) {
    this.palpiteService.remove(item);
  }

}
