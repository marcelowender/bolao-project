import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { PalpiteService } from '../../providers/palpite-service/palpite-service';
import { ImagePicker } from '@ionic-native/image-picker';

@IonicPage()
@Component({
  selector: 'page-edit-palpites',
  templateUrl: 'edit-palpites.html',
})
export class EditPalpitesPage {

  palpiteName: string;
  palpiteKey: string;
  imgPath: string;
  fileToUpload: any;

  constructor(private navCtrl: NavController,
    private navParams: NavParams,
    private palpiteService: PalpiteService,
    private imagePicker: ImagePicker) {

    this.palpiteKey = null;
    this.palpiteName = '';

    if (this.navParams.data.palpite) {
      this.palpiteName = this.navParams.data.palpite.name;
      this.palpiteKey = this.navParams.data.palpite.$key;
    }
  }

  save() {
    this.palpiteService.uploadAndSave({
      name: this.palpiteName,
      key: this.palpiteKey
    //  fileToUpload: this.fileToUpload
    });
    this.navCtrl.pop();
  }



}
