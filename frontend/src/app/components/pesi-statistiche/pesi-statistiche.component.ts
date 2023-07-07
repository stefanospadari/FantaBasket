import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-pesi-statistiche',
  templateUrl: './pesi-statistiche.component.html',
  styleUrls: ['./pesi-statistiche.component.css']
})
export class PesiStatisticheComponent {

  punti= new FormControl();
  assist= new FormControl();
  rimbOff= new FormControl();
  rimbDif= new FormControl();
  recuperate= new FormControl();
  perse= new FormControl();
  stoppata= new FormControl();
  doppiaDoppia= new FormControl();
  triplaDoppia= new FormControl();
  quintetto= new FormControl();
  sbagliato= new FormControl();
  liberoSbagliato= new FormControl();

  ngOnInit(){
    this.punti.setValue(1.0);
    this.assist.setValue(2.0);
    this.rimbOff.setValue(1.25);
    this.rimbDif.setValue(1.0);
    this.recuperate.setValue(1.5);
    this.perse.setValue(-1.5);
    this.stoppata.setValue(1.5);
    this.doppiaDoppia.setValue(5.0);
    this.triplaDoppia.setValue(10.0);
    this.quintetto.setValue(1.0);
    this.sbagliato.setValue(-1.0);
    this.liberoSbagliato.setValue(-1.0);
  }

}
