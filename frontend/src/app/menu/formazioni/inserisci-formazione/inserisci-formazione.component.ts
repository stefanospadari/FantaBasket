import { Component, TemplateRef } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { SquadreService } from 'src/app/services/squadre.service';
import { FormazioneService } from 'src/app/services/formazione.service';
import { Squadra } from 'src/app/components/squadra/squadra.component';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-inserisci-formazione',
  templateUrl: './inserisci-formazione.component.html',
  styleUrls: ['./inserisci-formazione.component.css']
})
export class InserisciFormazioneComponent {

  modalRef: BsModalRef;

  constructor(private modalService: BsModalService, private squadraService: SquadreService, 
    private formazioneService: FormazioneService, private spinner: NgxSpinnerService) {
    this.modalRef = new BsModalRef();
  }

  isDisabled:boolean= true;

  moduli :string[]=["2-2-1", "1-2-2", "2-1-2", "1-3-1", "3-1-1"]

  selected = new FormControl('');
  capitano = new FormControl<Giocatore>({nome:"undefined",ruolo:"N"});
  sestoUomo = new FormControl<Giocatore>({nome:"undefined",ruolo:"N"});

  titolari: Giocatore[] = [];
  panchina: Giocatore[]=[];


  centri: Giocatore[] = [];
  ali: Giocatore[] = [];
  guardie: Giocatore[] = [];

  giocatori: Giocatore[]=[];

  toInsert: Giocatore = {nome:"", ruolo:"N"};


  ngOnInit(){

    this.selected.valueChanges.subscribe(selectedValue => {

      console.log(selectedValue);

      let nGuardie : number = parseInt(""+selectedValue?.split("-")[0]);
      let nAli : number = parseInt(""+selectedValue?.split("-")[1]);
      let nCentri : number = parseInt(""+selectedValue?.split("-")[2]);

      console.log("centri:"+nCentri);
      console.log("ali:"+nAli);
      console.log("guardie:"+nGuardie);

      let g: Giocatore;

      this.guardie= [];
      this.ali= [];
      this.centri=[];
      this.panchina=[];
      this.titolari=[];

      for(var i=0; i<nGuardie;i++){
        this.guardie.push(g={nome: "undefined", ruolo:"G"})
      }

      for(var i=0; i<nAli;i++){
        this.ali.push(g={nome: "undefined", ruolo:"A"})
      }

      for(var i=0; i<nCentri;i++){
        this.centri.push(g={nome: "undefined", ruolo:"C"})
      }

      for(var i=0; i<5; i++)
        this.panchina.push(g={nome: "undefined", ruolo:"P"})


      this.giocatori=[];
      
      this.spinner.show();
      this.squadraService.getSquadra("SteTeam").subscribe(
        (data: Squadra) => {
          console.log(data.giocatori); // Stampa la risposta ricevuta dal server come un'istanza di Squadra
          for(let i=0; i<data.giocatori.length; i++) {
            console.log(data.giocatori[i].nome +" "+ data.giocatori[i].cognome + " "+ data.giocatori[i].ruolo);
            this.giocatori.push(g={nome: data.giocatori[i].nome +" "+ data.giocatori[i].cognome, ruolo: data.giocatori[i].ruolo[0]})
            console.log(this.giocatori[i]);
          }
          this.spinner.hide();
        }
        );

    })

    this.selected.setValue(this.moduli[0])
    console.log(this.selected.value);

  } 

  selectGiocatore(g: Giocatore){
    if(this.toInsert.ruolo!='P'){ //titolare

      switch (g.ruolo) {
        case 'G':

          //per eliminare il giocatore che si vuole sostituire
          for(let i=0; i<this.guardie.length; i++)
            if(this.guardie[i].nome== this.toInsert.nome && this.guardie[i].ruolo== this.toInsert.ruolo){
              this.guardie[i]= g;
              break;
            }

          break;

        case 'A':
          //per eliminare il giocatore che si vuole sostituire
          for(let i=0; i<this.ali.length; i++)
            if(this.ali[i].nome== this.toInsert.nome && this.ali[i].ruolo== this.toInsert.ruolo){
              this.ali[i]= g;
              break;
            }

          break;
        case 'C':

          for(let i=0; i<this.centri.length; i++)
            if(this.centri[i].nome== this.toInsert.nome && this.centri[i].ruolo== this.toInsert.ruolo){
              this.centri[i]= g;
              break;
            }

          break;
      }

      //per togliere il giocatore appena inserito dalla lista dei disponibili
      for(let i=0; i<this.giocatori.length; i++){
        if(this.giocatori[i].nome== g.nome && this.giocatori[i].ruolo== g.ruolo){
          this.giocatori.splice(i,1);
        }
      }

      //per togliere il giocatore che si vuole sostituire
      for(let i=0; i<this.titolari.length; i++)
        if(this.titolari[i].nome== this.toInsert.nome && this.titolari[i].ruolo== this.toInsert.ruolo){
          this.titolari.splice(i,1);
          break;
        }

      this.titolari.push(g);

    }
    else{ //panchina
      for(let i=0; i<this.panchina.length; i++)
        if(this.panchina[i].nome== this.toInsert.nome && this.panchina[i].ruolo== this.toInsert.ruolo){
          this.panchina[i]= g;
          break;
        }
        
      //per togliere il giocatore appena inserito dalla lista dei disponibili
      for(let i=0; i<this.giocatori.length; i++){
        if(this.giocatori[i].nome== g.nome && this.giocatori[i].ruolo== g.ruolo){
          this.giocatori.splice(i,1);
        }
      }
    }

    if(this.toInsert.nome!="undefined")
      this.giocatori.push(this.toInsert);

    //nascondiamo il pop-up
    this.modalRef.hide();

    console.log(""+this.titolari.length + this.panchina.length + this.capitano.value?.nome + this.sestoUomo.value?.nome)
    if(this.titolari.length==5 && this.panchina.length==5 &&
      this.capitano.value?.nome!= "undefined" && this.sestoUomo.value?.nome != "undefined"){

        this.isDisabled=false;
        console.log("formazione completa");
    }
      
  }

  inserisciGiocatore(g: Giocatore, template: TemplateRef<any>){
    this.modalRef = this.modalService.show(template);
    this.toInsert=g;
  }

  inviaFormazione() {
    this.formazioneService.setTitolari(this.titolari);
    this.formazioneService.setPanchina(this.panchina);
    this.formazioneService.setCentri(this.centri);
    this.formazioneService.setAli(this.ali);
    this.formazioneService.setGuardie(this.guardie);
    if (this.capitano.value !== null) {
      this.formazioneService.setSestoUomo(this.capitano.value);
    }
    if (this.sestoUomo.value !== null) {
      this.formazioneService.setSestoUomo(this.sestoUomo.value);
    }
  }
}
