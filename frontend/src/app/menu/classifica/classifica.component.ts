import { Component } from '@angular/core';
import { Squadra } from '../../components/squadra/squadra.component';

@Component({
  selector: 'app-classifica',
  templateUrl: './classifica.component.html',
  styleUrls: ['./classifica.component.css']
})
export class ClassificaComponent {

  squadre: Squadra[]= [];

  ngOnInit(){
    let s: Squadra;
    this.squadre.push(s={nome: "IngegneriadelSoftware", V:3, P:1, sommaPunteggi:654.3, PC:6});
    this.squadre.push(s={nome: "tutti30L", V:2, P:2, sommaPunteggi:562.1, PC:4});
    this.squadre.push(s={nome: "idisperati", V:2, P:2, sommaPunteggi:557.8, PC:4});
    this.squadre.push(s={nome: "miamièscarsa", V:1, P:3, sommaPunteggi:481.5, PC:2});
  }
}
