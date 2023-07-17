import { Component } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';
import { EntryGiocatore } from 'src/app/services/squadre.service';
import { SvincolatiService } from 'src/app/services/svincolati.service';

@Component({
  selector: 'app-svincolati',
  templateUrl: './svincolati.component.html',
  styleUrls: ['./svincolati.component.css']
})
export class SvincolatiComponent {

  svincolati: Giocatore[] = [];

  name = new FormControl('')

  constructor(private svincolatiService: SvincolatiService, private spinner: NgxSpinnerService){}

  ngOnInit(){
    let g : Giocatore;
    /*this.svincolati.push(g={nome: "Awadu Abass", ruolo:"A"});
    this.svincolati.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.svincolati.push(g={nome: "Milos Teodosic", ruolo:"G"});
    this.svincolati.push(g={nome: "Shavon Shields", ruolo:"A"});
    this.svincolati.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.svincolati.push(g={nome: "Kyle Hines", ruolo:"C"});*/

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

  }

  show(name: string){
    if(this.name.value=="")
      return true;
    else
      return (name.split(" ")[0].toLowerCase().startsWith(""+this.name.value) || name.split(" ")[1].toLowerCase().startsWith(""+this.name.value));
  }
  
}
