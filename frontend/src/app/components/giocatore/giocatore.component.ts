import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

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

  @Input() enableStat: boolean=false;
  @Input() enableMarker: boolean=false;
  @Input() enableAdd: boolean=false;

  @Input() punti: number=0;
  @Input() assist: number=0;
  @Input() rimbalzi: number=0;
  

  @Output() removeEvent= new EventEmitter<Giocatore>()
  @Output() addEvent= new EventEmitter<Giocatore>()

  img="";

  ngOnChanges(changes: SimpleChanges) {
    this.img=this.nome.replace(" ", "_");
  }

  remove() {
    let g : Giocatore;
    this.removeEvent.emit(g={nome: this.nome, ruolo:this.ruolo});

  }

  add(){
    let g : Giocatore;
    this.addEvent.emit(g={nome: this.nome, ruolo:this.ruolo});
  }
}
