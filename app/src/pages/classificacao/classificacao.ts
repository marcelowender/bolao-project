import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the ClassificacaoPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-classificacao',
  templateUrl: 'classificacao.html',
})
export class ClassificacaoPage {
classificacao:Array<any>
  
  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.loadClassificacao();
  }

  loadClassificacao(){
     this.classificacao = [{posicao:1,nome:"Fulaninho",pontos:88},
    {posicao:2,nome:"Beltrano",pontos:77},
    {posicao:3,nome:"Ciclano",pontos:66},
    {posicao:4,nome:"Outrano",pontos:55},
    {posicao:5,nome:"Paulo",pontos:44},
    {posicao:6,nome:"Saulo",pontos:42},
    {posicao:7,nome:"Marcelo",pontos:34},
    {posicao:8,nome:"Ana",pontos:33},
    {posicao:9,nome:"Tio",pontos:22},
    {posicao:10,nome:"Sobrinho",pontos:11},
    {posicao:11,nome:"Primo",pontos:10},
    {posicao:12,nome:"Prima",pontos:9},
    {posicao:13,nome:"Cunhada",pontos:8},

  
  
  
  
  
  
  ];

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ClassificacaoPage');
  }

}
