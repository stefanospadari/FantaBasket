import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';
import { SquadreService } from 'src/app/services/squadre.service';

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

  @Input() V="";
  @Input() P="";
  @Input() sommaPunteggi="";
  @Input() PC="";

  nome: FormControl= new FormControl();

  squadra: Giocatore[] = [];

  constructor(private route: ActivatedRoute, private squadreService: SquadreService){}

  ngOnInit(){

    this.nome.valueChanges.subscribe(selectedValue => {

      //ovviamente qui interroghiamo il server e carichiamo i giocatori di quella squadra

      this.squadra=[];
    
      let g : Giocatore;
      this.squadra.push(g={nome: "Awadu Abass", ruolo:"A"});
      this.squadra.push(g={nome: "Niccolò Melli", ruolo:"C"});
      this.squadra.push(g={nome: "Milos Teodosic", ruolo:"G"});
      this.squadra.push(g={nome: "Shavon Shields", ruolo:"A"});
      this.squadra.push(g={nome: "Adrian Banks", ruolo:"G"});
      this.squadra.push(g={nome: "Kyle Hines", ruolo:"C"});
      this.squadra.push(g={nome: "Derek Willis", ruolo:"A"});
      this.squadra.push(g={nome: "Jacorey Williams", ruolo:"C"});

      /*this.all=[];
      console.log(this.all);*/
    
    })

    this.nome.setValue(this.route.snapshot.paramMap.get('nome'));

  }

  onPrevious(event : Event){
    console.log("Next team of "+this.nome.value);
    if(this.squadreService.previousTeam(this.nome.value))
      this.nome.setValue(this.squadreService.previousTeam(this.nome.value)?.nome);
  }

  onNext(event : Event){
    console.log("Next team of "+this.nome.value);
    if(this.squadreService.nextTeam(this.nome.value))
      this.nome.setValue(this.squadreService.nextTeam(this.nome.value)?.nome);
  }
}
