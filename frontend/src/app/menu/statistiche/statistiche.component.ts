import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

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
      this.giocatori.push(g={nome: "Niccolò Melli", ruolo:"C"});
      this.giocatori.push(g={nome: "Milos Teodosic", ruolo:"G"});
      this.giocatori.push(g={nome: "Shavon Shields", ruolo:"A"});
      this.giocatori.push(g={nome: "Adrian Banks", ruolo:"G"});
      this.giocatori.push(g={nome: "Kyle Hines", ruolo:"C"});

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

}
