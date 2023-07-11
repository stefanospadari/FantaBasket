import { Component } from '@angular/core';
import { Statistica } from '../statistiche.component';
import { ActivatedRoute } from '@angular/router';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

@Component({
  selector: 'app-statistiche-giocatore',
  templateUrl: './statistiche-giocatore.component.html',
  styleUrls: ['./statistiche-giocatore.component.css']
})
export class StatisticheGiocatoreComponent {

  statistiche: Statistica[]=[];

  nome:string="";
  ruolo:string="";

  constructor(private route: ActivatedRoute){}


  ngOnInit(){

    const giocatoreString = this.route.snapshot.paramMap.get('giocatore');
    let giocatore: Giocatore = JSON.parse(""+giocatoreString);
    console.log(giocatore);
    this.nome=giocatore.nome;
    this.ruolo=giocatore.ruolo;

    this.statistiche[0]={nome:'P', valore: 15.1}
    this.statistiche[1]={nome:'A', valore: 1.3}
    this.statistiche[2]={nome:'DR', valore: 5.8}
    this.statistiche[3]={nome:'OR', valore: 2.2}
    this.statistiche[4]={nome:'PP', valore: 1.9}
    this.statistiche[5]={nome:'PR', valore: 1.1}
    this.statistiche[6]={nome:'ST', valore: 0.4}
    this.statistiche[7]={nome:'3PT', valore: 0.0}
    this.statistiche[8]={nome:'F', valore: 2.7}
    this.statistiche[9]={nome:'TS', valore: 3.9}
    this.statistiche[10]={nome:'TLS', valore: 2.7}

    console.log(this.statistiche);
  }

}
