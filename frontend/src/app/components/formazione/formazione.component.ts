import { Component, Input } from '@angular/core';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

@Component({
  selector: 'app-formazione',
  templateUrl: './formazione.component.html',
  styleUrls: ['./formazione.component.css']
})
export class FormazioneComponent {

  @Input() titolari: Giocatore[] = [];
  @Input() panchina: Giocatore[]=[];

  @Input() centri: Giocatore[] = [];
  @Input() ali: Giocatore[] = [];
  @Input() guardie: Giocatore[] = [];

  @Input() capitano: Giocatore={nome: "", ruolo:""};
  @Input() sestoUomo: Giocatore={nome: "", ruolo:""};

  isCapitano(g: Giocatore){
    return (g.nome == this.capitano.nome && this.capitano.ruolo== g.ruolo);
  }

  isSestoUomo(g: Giocatore){
    return (g.nome == this.sestoUomo.nome && this.sestoUomo.ruolo== g.ruolo);
  }

}
