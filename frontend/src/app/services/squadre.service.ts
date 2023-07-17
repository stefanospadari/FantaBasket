import { Injectable } from '@angular/core';
import { Squadra } from '../components/squadra/squadra.component';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

export interface EntryGiocatore{
  nome: string;
  cognome: string;
  ruolo:string;
}

@Injectable({
  providedIn: 'root'
})
export class SquadreService {

  //farei qui e richieste per ricevere le squadre classifica e una squadra singolare

  squadre: Squadra[]= [];

  private url = 'http://localhost:8081/FantaBasket/campionato' //URL endpoint vistaCampionato

  constructor(private http: HttpClient) { 

    /*console.log(this.http.get(this.url+"?request=classifica").subscribe(
      (response) => {
        console.log("response:"+ response); // Visualizza i dati ritornati dalla richiesta
      }));

    let s: Squadra;
    this.squadre.push(s={nome: "IngegneriadelSoftware", V:3, P:1, sommaPunteggi:654.3, PC:6});
    this.squadre.push(s={nome: "tutti30L", V:2, P:2, sommaPunteggi:562.1, PC:4});
    this.squadre.push(s={nome: "idisperati", V:2, P:2, sommaPunteggi:557.8, PC:4});
    this.squadre.push(s={nome: "miamièscarsa", V:1, P:3, sommaPunteggi:481.5, PC:2});*/

    //interrogare il server per ottenere le squadre
  }

  ngOnInit(){
    
  }

  getClassifica(): Observable<Squadra[]> {
    return this.http.get<Squadra[]>(this.url + '?request=classifica').pipe(
      tap((squadre: Squadra[]) => {
        this.squadre = squadre; // Setta le squadre nel service
      })
    );
  }

  getSquadra(nome: string): Observable<Squadra> {
    return this.http.get<Squadra>(this.url + '?request=squadra&nomeSquadra=' + nome);
  }

  

  getSquadre(): Squadra[] {
    return this.squadre;
  }

  nextTeam(name:string){
    console.log("AIUT: "+ this.squadre[2])
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
