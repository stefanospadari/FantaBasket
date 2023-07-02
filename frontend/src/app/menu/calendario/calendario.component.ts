import { Component } from '@angular/core';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.css']
})
export class CalendarioComponent {

  giornata="";

  ngOnInit(){
    this.giornata="Giornata 1"
  }

  nextGiornata(){
    let g=  (this.giornata.charAt(this.giornata.length) as unknown) as number;
    g++;
    this.giornata="Giornata "+g;
  }

  previousGiornata(){
    let g=  (this.giornata.charAt(this.giornata.length) as unknown) as number;
    if(g>1){
      g--;
      this.giornata="Giornata "+g;
    }
  }

}
