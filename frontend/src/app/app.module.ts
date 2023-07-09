import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule, FormControl } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

//funzionalità home
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { ClassificaComponent } from './menu/classifica/classifica.component';
import { CalendarioComponent } from './menu/calendario/calendario.component';
import { StatisticheComponent } from './menu/statistiche/statistiche.component';
import { SvincolatiComponent } from './menu/svincolati/svincolati.component';
import { FormazioniComponent } from './menu/formazioni/formazioni.component';
import { SettingsComponent } from './menu/settings/settings.component';
import { LoginComponent } from './login/login.component';


import { InserisciFormazioneComponent } from './menu/formazioni/inserisci-formazione/inserisci-formazione.component';

//funzionalità gestione campionato
import { ModificaPesiComponent } from './menu/settings/modifica-pesi/modifica-pesi.component';
import { PesiStatisticheComponent } from './components/pesi-statistiche/pesi-statistiche.component';
import { ModificaSquadreComponent } from './menu/settings/modifica-squadre/modifica-squadre.component';

//folder component
import { GiocatoreComponent } from './components/giocatore/giocatore.component';
import { SquadraComponent } from './components/squadra/squadra.component';
import { BarraComponent } from './components/barra/barra.component';
import { IconaComponent } from './menu/icona/icona.component';
import { FormazioneComponent } from './components/formazione/formazione.component';
import { TitolareComponent } from './components/titolare/titolare.component';
import { PanchinaroComponent } from './components/panchinaro/panchinaro.component';


//services
import { SquadreService } from './services/squadre.service';
import { StatisticheGiocatoreComponent } from './menu/statistiche/statistiche-giocatore/statistiche-giocatore.component'

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
    ModificaPesiComponent,
    PesiStatisticheComponent,
    ModificaSquadreComponent,
    StatisticheGiocatoreComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    ModalModule.forRoot(),
  ],
  providers: [SquadreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
