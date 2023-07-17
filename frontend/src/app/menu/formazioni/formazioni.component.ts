import { Component } from '@angular/core';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';
import { FormazioneService } from 'src/app/services/formazione.service';

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

  constructor(private formazioneService: FormazioneService){}

  ngOnInit() {
    this.titolari = this.formazioneService.getTitolari();
    this.panchina = this.formazioneService.getPanchina();
    this.centri = this.formazioneService.getCentri();
    this.ali = this.formazioneService.getAli();
    this.guardie = this.formazioneService.getGuardie();
    this.capitano = this.formazioneService.getCapitano();
    this.sestoUomo = this.formazioneService.getSestoUomo();

    console.log(this.titolari);
  }

}
