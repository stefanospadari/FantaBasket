import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';
import { EntryGiocatore, SquadreService } from 'src/app/services/squadre.service';
import { NgxSpinnerService } from 'ngx-spinner';

export interface Squadra{
  nome: string;
  partiteVinte: number;
  partitePerse: number;
  sommaPunteggi: number;
  puntiClassifica:number;
  giocatori: EntryGiocatore[];
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

  constructor(private route: ActivatedRoute, private squadreService: SquadreService, private spinner: NgxSpinnerService){}

  ngOnInit(){

    this.nome.valueChanges.subscribe(selectedValue => {

      //ovviamente qui interroghiamo il server e carichiamo i giocatori di quella squadra

      this.squadra=[];
      let g : Giocatore;

      this.spinner.show();
      this.squadreService.getSquadra(this.nome.value).subscribe(
        (data: Squadra) => {
          console.log(data.giocatori); // Stampa la risposta ricevuta dal server come un'istanza di Squadra
          for(let i=0; i<data.giocatori.length; i++) {
            console.log(data.giocatori[i].nome +" "+ data.giocatori[i].cognome + " "+ data.giocatori[i].ruolo);
            this.squadra.push(g={nome: data.giocatori[i].nome +" "+ data.giocatori[i].cognome, ruolo: data.giocatori[i].ruolo[0]})
            console.log(this.squadra[i]);
          }
          this.spinner.hide();
        }
      );
      
      /*
      let g : Giocatore;
      this.squadra.push(g={nome: "Awadu Abass", ruolo:"A"});
      this.squadra.push(g={nome: "Niccolò Melli", ruolo:"C"});
      this.squadra.push(g={nome: "Milos Teodosic", ruolo:"G"});
      this.squadra.push(g={nome: "Shavon Shields", ruolo:"A"});
      this.squadra.push(g={nome: "Adrian Banks", ruolo:"G"});
      this.squadra.push(g={nome: "Kyle Hines", ruolo:"C"});
      this.squadra.push(g={nome: "Derek Willis", ruolo:"A"});
      this.squadra.push(g={nome: "Jacorey Williams", ruolo:"C"});*/

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
