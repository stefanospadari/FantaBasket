import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalendarioComponent } from './menu/calendario/calendario.component';
import { ClassificaComponent } from './menu/classifica/classifica.component';
import { HomeComponent } from './home/home.component';
import { StatisticheComponent } from './menu/statistiche/statistiche.component';
import { SvincolatiComponent } from './menu/svincolati/svincolati.component';
import { FormazioniComponent } from './menu/formazioni/formazioni.component';
import { SettingsComponent } from './menu/settings/settings.component';
import { SquadraComponent } from './menu/classifica/squadra/squadra.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'home/classifica', component: ClassificaComponent },
  { path: 'home/calendario', component: CalendarioComponent },
  { path: 'home/statistiche', component: StatisticheComponent },
  { path: 'home/svincolati', component: SvincolatiComponent },
  { path: 'home/formazioni', component: FormazioniComponent },
  { path: 'home/settings', component: SettingsComponent },
  { path: 'home/classifica/squadra', component: SquadraComponent },
  { path: 'home/classifica/squadra/:nome', component: SquadraComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
