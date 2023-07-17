import { Injectable, OnInit } from '@angular/core';
import { Giocatore } from '../components/giocatore/giocatore.component';

@Injectable({
  providedIn: 'root'
})
export class FormazioneService {

  constructor() {
    let g: Giocatore;
    this.centri.push(g={nome: "undefined", ruolo:"C"});
    this.titolari.push(g={nome: "undefined", ruolo:"C"});

    this.ali.push(g={nome: "undefined", ruolo:"A"});
    this.ali.push(g={nome: "undefined", ruolo:"A"});
    this.titolari.push(g={nome: "undefined", ruolo:"A"});
    this.titolari.push(g={nome: "undefined", ruolo:"A"});

    this.guardie.push(g={nome: "undefined", ruolo:"G"});
    this.guardie.push(g={nome: "undefined", ruolo:"G"});
    this.titolari.push(g={nome: "undefined", ruolo:"G"});
    this.titolari.push(g={nome: "undefined", ruolo:"G"});

    this.panchina.push(g={nome: "undefined", ruolo:"P"});
    this.panchina.push(g={nome: "undefined", ruolo:"P"});
    this.panchina.push(g={nome: "undefined", ruolo:"P"});
    this.panchina.push(g={nome: "undefined", ruolo:"P"});
    this.panchina.push(g={nome: "undefined", ruolo:"P"});

    console.log("Formazione service:" +this.titolari)
   }



   titolari: Giocatore[] = [];
   panchina: Giocatore[] = [];
   centri: Giocatore[] = [];
   ali: Giocatore[] = [];
   guardie: Giocatore[] = [];
   capitano: Giocatore = { nome: 'undefined', ruolo: '' };
   sestoUomo: Giocatore = { nome: 'undefined', ruolo: '' };

  setTitolari(titolari: Giocatore[]): void {
    this.titolari = titolari;
  }

  getTitolari(): Giocatore[] {
    return this.titolari;
  }

  setPanchina(panchina: Giocatore[]): void {
    this.panchina = panchina;
  }

  getPanchina(): Giocatore[] {
    return this.panchina;
  }

  setCentri(centri: Giocatore[]): void {
    this.centri = centri;
  }

  getCentri(): Giocatore[] {
    return this.centri;
  }

  setAli(ali: Giocatore[]): void {
    this.ali = ali;
  }

  getAli(): Giocatore[] {
    return this.ali;
  }

  setGuardie(guardie: Giocatore[]): void {
    this.guardie = guardie;
  }

  getGuardie(): Giocatore[] {
    return this.guardie;
  }

  setCapitano(capitano: Giocatore): void {
    this.capitano = capitano;
  }

  getCapitano(): Giocatore {
    return this.capitano;
  }

  setSestoUomo(sestoUomo: Giocatore): void {
    this.sestoUomo = sestoUomo;
  }

  getSestoUomo(): Giocatore {
    return this.sestoUomo;
  }

}
