import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

export interface Squadra{
  nome: string;
  V: number;
  P: number;
  sommaPunteggi: number;
  PC:number;
}

@Component({
  selector: 'app-squadra',
  templateUrl: './squadra.component.html',
  styleUrls: ['./squadra.component.css']
})
export class SquadraComponent {

  @Input() nome="";
  @Input() V="";
  @Input() P="";
  @Input() sommaPunteggi="";
  @Input() PC="";

  @Output() next = new EventEmitter();
  @Output() previous = new EventEmitter();

  squadra: Giocatore[] = [];

  constructor(private route: ActivatedRoute){}

  ngOnInit(){
    this.nome= ''+this.route.snapshot.paramMap.get('nome');
    let g : Giocatore;
    this.squadra.push(g={nome: "Awadu Abass", ruolo:"A"});
    this.squadra.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.squadra.push(g={nome: "Milos Teodosic", ruolo:"G"});
    this.squadra.push(g={nome: "Shavon Shields", ruolo:"A"});
    this.squadra.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.squadra.push(g={nome: "Kyle Hines", ruolo:"C"});
    this.squadra.push(g={nome: "Derek Willis", ruolo:"A"});
    this.squadra.push(g={nome: "Jacorey Williams", ruolo:"C"});

  }

  onPrevious(event : Event){
    this.previous.emit();
  }

  onNext(event : Event){
    this.next.emit();
  }
}
