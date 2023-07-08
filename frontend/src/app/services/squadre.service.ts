import { Injectable } from '@angular/core';
import { Squadra } from '../components/squadra/squadra.component';

@Injectable({
  providedIn: 'root'
})
export class SquadreService {

  squadre: Squadra[]= [];

  constructor() { 
    let s: Squadra;
    this.squadre.push(s={nome: "IngegneriadelSoftware", V:3, P:1, sommaPunteggi:654.3, PC:6});
    this.squadre.push(s={nome: "tutti30L", V:2, P:2, sommaPunteggi:562.1, PC:4});
    this.squadre.push(s={nome: "idisperati", V:2, P:2, sommaPunteggi:557.8, PC:4});
    this.squadre.push(s={nome: "miamièscarsa", V:1, P:3, sommaPunteggi:481.5, PC:2});
  }

  getSquadre(): Squadra[] {
    return this.squadre;
  }

  nextTeam(name:string){
    for(let i=0; i<this.squadre.length;i++){

      if(this.squadre[i].nome==name && i== this.squadre.length - 1)
        return this.squadre[0];

      else if(this.squadre[i].nome==name)
        return this.squadre[i+1];
    }
    return null;
  }

  previousTeam(name:string){

    for(let i=0; i<this.squadre.length;i++){
      if(this.squadre[i].nome==name && i==0)
        return this.squadre[this.squadre.length-1];

      else if(this.squadre[i].nome==name)
        return this.squadre[i-1];
    }
    return;
  }

}
