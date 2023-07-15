import { Component, Input } from '@angular/core';
import { AppModule } from '../app.module';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  @Input() ruolo: string="";

  classifica="Classifica";
  calendario="Calendario";
  svincolati="Svincolati";
  statistiche="Statistiche";
  formazioni="Formazioni";
  settings="Settings";
}
