import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { AngularFireModule } from 'angularfire2';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { AngularFireDatabaseModule } from 'angularfire2/database';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { SigninPage } from '../pages/signin/signin';
import { SigninWithEmailPage } from '../pages/signinwithemail/signinwithemail';
import { SignupPage } from '../pages/signup/signup';
import { ResetpasswordPage } from '../pages/resetpassword/resetpassword';
import { EditPalpitesPage } from '../pages/edit-palpites/edit-palpites';

import { AuthService } from '../providers/auth/auth-service';
import { PalpiteService } from '../providers/palpite-service/palpite-service';

import { GooglePlus } from '@ionic-native/google-plus';
import { Facebook } from '@ionic-native/facebook';
import { TwitterConnect } from '@ionic-native/twitter-connect';
import { ImagePicker } from '@ionic-native/image-picker';

const firebaseConfig = {
  apiKey: "AIzaSyBnikWA5sNfpuoXHbJKSfu3kQeC2LbkA24",
  authDomain: "bolao-project.firebaseapp.com",
  databaseURL: "https://bolao-project.firebaseio.com",
  projectId: "bolao-project",
  storageBucket: "bolao-project.appspot.com",
  messagingSenderId: "817119111984"
};

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    SigninPage,
    SigninWithEmailPage,
    SignupPage,
    ResetpasswordPage,
    EditPalpitesPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    AngularFireModule.initializeApp(firebaseConfig),
    AngularFireAuthModule,
    AngularFireDatabaseModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    SigninPage,
    SigninWithEmailPage,
    SignupPage,
    ResetpasswordPage,
    EditPalpitesPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AuthService,
    PalpiteService,
    GooglePlus,
    Facebook,
    TwitterConnect,
    ImagePicker
  ]
})
export class AppModule {}
