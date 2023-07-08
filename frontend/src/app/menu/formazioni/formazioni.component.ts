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

  capitano: Giocatore={nome: "", ruolo:""};
  sestoUomo: Giocatore={nome: "", ruolo:""};

  ngOnInit(){
    let g: Giocatore;
    this.centri.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.titolari.push(g={nome: "Niccolò Melli", ruolo:"C"});

    this.ali.push(g={nome: "Shavon Shields", ruolo:"A"});
    this.ali.push(g={nome: "Tornike Shengelia", ruolo:"A"});
    this.titolari.push(g={nome: "Shavon Shields", ruolo:"A"});
    this.titolari.push(g={nome: "Tornike Shengelia", ruolo:"A"});

    this.guardie.push(g={nome: "Milos Teodosic", ruolo:"G"});
    this.guardie.push(g={nome: "Diego Flaccadori", ruolo:"G"});
    this.titolari.push(g={nome: "Milos Teodosic", ruolo:"G"});
    this.titolari.push(g={nome: "Diego Flaccadori", ruolo:"G"});

    this.panchina.push(g={nome: "Awadu Abass", ruolo:"A"});
    this.panchina.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.panchina.push(g={nome: "Colbey Ross", ruolo:"G"});
    this.panchina.push(g={nome: "Derek Willis", ruolo:"A"});
    this.panchina.push(g={nome: "Jacorey Williams", ruolo:"C"});

    this.capitano= (g={nome: "Milos Teodosic", ruolo:"G"});
    this.sestoUomo= (g={nome: "Awadu Abass", ruolo:"A"});

  } 
  
}
