import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

@Component({
  selector: 'app-inserisci-formazione',
  templateUrl: './inserisci-formazione.component.html',
  styleUrls: ['./inserisci-formazione.component.css']
})
export class InserisciFormazioneComponent {

  moduli :string[]=["2-2-1", "1-2-2", "2-1-2", "1-3-1", "3-1-1"]

  selected = new FormControl('');
  capitano = new FormControl('');
  sestoUomo = new FormControl('');

  titolari: Giocatore[] = [];
  centri: Giocatore[] = [];
  ali: Giocatore[] = [];
  guardie: Giocatore[] = [];

  panchina: Giocatore[]=[];

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

      for(var i=0; i<nGuardie;i++){
        this.guardie.push(g={nome: "undefined", ruolo:"N"})
      }

      for(var i=0; i<nAli;i++){
        this.ali.push(g={nome: "undefined", ruolo:"N"})
      }

      for(var i=0; i<nCentri;i++){
        this.centri.push(g={nome: "undefined", ruolo:"N"})
      }

      for(var i=0; i<5; i++)
        this.panchina.push(g={nome: "undefined", ruolo:"N"})  

    })

    this.selected.setValue(this.moduli[0])
    console.log(this.selected.value);

  } 

  /*modalRef: BsModalRef;

  constructor(private modalService: BsModalService) {}

  apriPopUp(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }*/

}
