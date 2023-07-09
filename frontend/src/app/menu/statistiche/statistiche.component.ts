import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

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

  squadre : string[] = [];

  statistiche: Statistiche[]= [];

  constructor(private router: Router) {}

  ngOnInit(){

    this.squadre= ["IngegneriadelSoftware", "tutti30L", "idisperati", "miamièscarsa"];

    let g : Giocatore;

    /*this.all.push(g={nome: "Awadu Abass", ruolo:"A"});
    this.all.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.all.push(g={nome: "Milos Teodosic", ruolo:"G"});
    this.all.push(g={nome: "Shavon Shields", ruolo:"A"});
    this.all.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.all.push(g={nome: "Kyle Hines", ruolo:"C"});*/

    this.squadra.valueChanges.subscribe(selectedValue => {

      //ovviamente qui interroghiamo il server e carichiamo i giocatori di quella squadra

      this.giocatori=[];
    
      let g : Giocatore;
      this.giocatori.push(g={nome: "Awadu Abass", ruolo:"A"});
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
