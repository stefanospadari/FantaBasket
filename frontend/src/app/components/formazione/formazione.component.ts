import { Component, Input } from '@angular/core';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

@Component({
  selector: 'app-formazione',
  templateUrl: './formazione.component.html',
  styleUrls: ['./formazione.component.css']
})
export class FormazioneComponent {

  @Input() titolari: Giocatore[] = [];
  @Input() centri: Giocatore[] = [];
  @Input() ali: Giocatore[] = [];
  @Input() guardie: Giocatore[] = [];

  @Input() panchina: Giocatore[]=[];

}
