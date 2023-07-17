import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';
import { Squadra } from 'src/app/components/squadra/squadra.component';
import { SquadreService } from 'src/app/services/squadre.service';

export interface Statistiche {
  giocatore: Giocatore;
  punti:number;
  assist:number;
  rimbalzi:number;
}

export interface Statistica {
  nome: string;
  valore:number;
}

@Component({
  selector: 'app-statistiche',
  templateUrl: './statistiche.component.html',
  styleUrls: ['./statistiche.component.css']
})
export class StatisticheComponent {

  giocatori: Giocatore[] = [];

  name = new FormControl('');
  squadra: FormControl= new FormControl();

  squadre : Squadra[] = [];

  statistiche: Statistiche[]= [];

  constructor(private router: Router, private squadreService: SquadreService, private spinner: NgxSpinnerService){}

  ngOnInit(){

    this.spinner.show();
    /*this.squadreService.getClassifica().subscribe(
      (squadre: Squadra[]) => {
        
        console.log("response: "+squadre)
        this.squadre = squadre;
        for(let i=0; i<this.squadre.length; i++)
          console.log(squadre[i]);

        this.spinner.hide();
      }
    );*/

    this.squadre= this.squadreService.getSquadre();
    console.log("squadre: "+ this.squadre);
    for(let i=0;i<this.squadre.length; i++)
      console.log(this.squadre[i]);

    

    /*this.all.push(g={nome: "Awadu Abass", ruolo:"A"});
    this.all.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.all.push(g={nome: "Milos Teodosic", ruolo:"G"});
    this.all.push(g={nome: "Shavon Shields", ruolo:"A"});
    this.all.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.all.push(g={nome: "Kyle Hines", ruolo:"C"});*/

    this.squadra.valueChanges.subscribe(selectedValue => {

      //ovviamente qui interroghiamo il server e carichiamo i giocatori di quella squadra

      this.statistiche=[];
    
      let g : Giocatore;
      
      this.spinner.show();
      let s: Squadra= this.squadra.value;
      this.squadreService.getSquadra(s.nome).subscribe(
        (data: Squadra) => {
          //console.log(data.giocatori); // Stampa la risposta ricevuta dal server come un'istanza di Squadra
          for(let i=0; i<data.giocatori.length; i++) {
            console.log(data.giocatori[i].nome +" "+ data.giocatori[i].cognome + " "+ data.giocatori[i].ruolo);
            g={nome: data.giocatori[i].nome +" "+ data.giocatori[i].cognome, ruolo: data.giocatori[i].ruolo[0]};
            this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4})
            console.log(this.giocatori[i]);
          }
          console
          this.spinner.hide();
        }
      );
      
      /*this.giocatori.push(g={nome: "Awadu Abass", ruolo:"A"});
      this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4});
      this.giocatori.push(g={nome: "Niccolò Melli", ruolo:"C"});
      this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4});

      this.giocatori.push(g={nome: "Milos Teodosic", ruolo:"G"});
      this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4});

      this.giocatori.push(g={nome: "Shavon Shields", ruolo:"A"});
      this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4});

      this.giocatori.push(g={nome: "Adrian Banks", ruolo:"G"});
      this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4});

      this.giocatori.push(g={nome: "Kyle Hines", ruolo:"C"});
      this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4});

      this.giocatori.push(g={nome: "Derek Willis", ruolo:"A"});
      this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4});

      this.giocatori.push(g={nome: "Jacorey Williams", ruolo:"C"});
      this.statistiche.push({giocatore:g, punti:12.3, assist:2.1, rimbalzi:15.4});

      /*this.all=[];
      console.log(this.all);*/
    
    })

    this.squadra.setValue(this.squadre[0]);

  }

  show(name: string){
    if(this.name.value=="")
      return true;
    else
      return (name.split(" ")[0].toLowerCase().startsWith(""+this.name.value) || name.split(" ")[1].toLowerCase().startsWith(""+this.name.value));
  }

  visualizzaStatistiche(giocatore: Giocatore): void {
    const giocatoreString = JSON.stringify(giocatore);
    this.router.navigate(['/home/statistiche', giocatoreString]);
  }

}
