import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule, FormControl } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { IconaComponent } from './menu/icona/icona.component';
import { ClassificaComponent } from './menu/classifica/classifica.component';
import { CalendarioComponent } from './menu/calendario/calendario.component';
import { StatisticheComponent } from './menu/statistiche/statistiche.component';
import { SvincolatiComponent } from './menu/svincolati/svincolati.component';
import { FormazioniComponent } from './menu/formazioni/formazioni.component';
import { SettingsComponent } from './menu/settings/settings.component';
import { GiocatoreComponent } from './components/giocatore/giocatore.component';
import { SquadraComponent } from './components/squadra/squadra.component';
import { BarraComponent } from './components/barra/barra.component';
import { LoginComponent } from './login/login.component';
import { FormazioneComponent } from './components/formazione/formazione.component';
import { TitolareComponent } from './components/titolare/titolare.component';
import { PanchinaroComponent } from './components/panchinaro/panchinaro.component';
import { InserisciFormazioneComponent } from './menu/formazioni/inserisci-formazione/inserisci-formazione.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    IconaComponent,
    ClassificaComponent,
    CalendarioComponent,
    StatisticheComponent,
    SvincolatiComponent,
    FormazioniComponent,
    SettingsComponent,
    GiocatoreComponent,
    SquadraComponent,
    BarraComponent,
    LoginComponent,
    FormazioneComponent,
    TitolareComponent,
    PanchinaroComponent,
    InserisciFormazioneComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
