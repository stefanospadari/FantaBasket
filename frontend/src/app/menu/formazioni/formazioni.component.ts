import { Component } from '@angular/core';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

@Component({
  selector: 'app-formazioni',
  templateUrl: './formazioni.component.html',
  styleUrls: ['./formazioni.component.css']
})
export class FormazioniComponent {

  titolari: Giocatore[] = [];
  panchina: Giocatore[]=[];

  centri: Giocatore[] = [];
  ali: Giocatore[] = [];
  guardie: Giocatore[] = [];

  ngOnInit(){
    let g: Giocatore;
    this.centri.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.centri.push(g={nome: "Niccolò Melli", ruolo:"C"});

    this.ali.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.ali.push(g={nome: "Niccolò Melli", ruolo:"C"});

    this.guardie.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.guardie.push(g={nome: "Niccolò Melli", ruolo:"C"});
    

    this.titolari.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.titolari.push(g={nome: "Niccolò Melli", ruolo:"C"});   
    this.titolari.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.titolari.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.titolari.push(g={nome: "Niccolò Melli", ruolo:"C"});    

    this.panchina.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.panchina.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.panchina.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.panchina.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.panchina.push(g={nome: "Adrian Banks", ruolo:"G"});

  } 
  
}
