import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

export interface Giocatore {
  nome: string;
  ruolo: string;
}

@Component({
  selector: 'app-giocatore',
  templateUrl: './giocatore.component.html',
  styleUrls: ['./giocatore.component.css']
})
export class GiocatoreComponent{

  @Input() nome="";
  @Input() ruolo="";

  img="";

  ngOnChanges(changes: SimpleChanges) {
    this.img=this.nome.replace(" ", "_");
  }
}
