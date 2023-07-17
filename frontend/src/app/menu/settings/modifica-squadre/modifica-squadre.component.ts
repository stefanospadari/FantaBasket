import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';
import { Squadra } from 'src/app/components/squadra/squadra.component';
import { EntryGiocatore, SquadreService } from 'src/app/services/squadre.service';
import { SvincolatiService } from 'src/app/services/svincolati.service';

@Component({
  selector: 'app-modifica-squadre',
  templateUrl: './modifica-squadre.component.html',
  styleUrls: ['./modifica-squadre.component.css']
})
export class ModificaSquadreComponent {

  giocatori: Giocatore[] = [];
  svincolati: Giocatore[]= []

  name = new FormControl('');
  squadra = new FormControl();

  squadre : Squadra[] = [];

  constructor(private svincolatiService: SvincolatiService, private squadraService: SquadreService, private spinner: NgxSpinnerService){}

  ngOnInit(){

    this.squadre= this.squadraService.getSquadre();
    let g : Giocatore;

    this.spinner.show();
    this.svincolatiService.getSvincolati().subscribe(
      (giocatori: EntryGiocatore[]) => {
        console.log(giocatori); // Stampa la risposta ricevuta dal server come un'istanza di Squadra
        for(let i=0; i<giocatori.length; i++) {
          console.log(giocatori[i].nome +" "+ giocatori[i].cognome + " "+ giocatori[i].ruolo);
          this.svincolati.push(g={nome: giocatori[i].nome +" "+ giocatori[i].cognome, ruolo: giocatori[i].ruolo[0]})
          console.log(this.svincolati[i]);
        }
        this.spinner.hide();
      }
    );

    this.squadra.valueChanges.subscribe(selectedValue => {

      //ovviamente qui interroghiamo il server e carichiamo i giocatori di quella squadra

      this.giocatori=[];
    
      let g : Giocatore;

      this.spinner.show();
      this.squadraService.getSquadra(this.squadra.value.nome).subscribe(
        (data: Squadra) => {
          console.log(data.giocatori); // Stampa la risposta ricevuta dal server come un'istanza di Squadra
          for(let i=0; i<data.giocatori.length; i++) {
            console.log(data.giocatori[i].nome +" "+ data.giocatori[i].cognome + " "+ data.giocatori[i].ruolo);
            this.giocatori.push(g={nome: data.giocatori[i].nome +" "+ data.giocatori[i].cognome, ruolo: data.giocatori[i].ruolo[0]})
            console.log(this.giocatori[i]);
          }
          this.spinner.hide();
        }
      );
      
    
    })

    this.squadra.setValue(this.squadre[0]);
    

  }

  show(name: string){
    if(this.name.value=="")
      return true;
    else
      return (name.split(" ")[0].toLowerCase().startsWith(""+this.name.value) || name.split(" ")[1].toLowerCase().startsWith(""+this.name.value));
  }

  removePlayer(toEliminate:Giocatore){
    console.log(toEliminate);
    for(let i=0; i<this.giocatori.length; i++){
      if (this.giocatori[i].nome== toEliminate.nome && this.giocatori[i].ruolo== toEliminate.ruolo){
        this.svincolati.push(this.giocatori[i]);
        this.giocatori.splice(i, 1);
      }
        
    }
  }

  addPlayer(toEliminate:Giocatore){

    this.giocatori.push(toEliminate);
    for(let i=0; i<this.giocatori.length; i++){
      if (this.svincolati[i].nome== toEliminate.nome && this.svincolati[i].ruolo== toEliminate.ruolo){
        this.svincolati.splice(i, 1);
      }
        
    }

  }
}
