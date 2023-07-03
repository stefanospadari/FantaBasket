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

  nextGiornata(event: Event){
    let g=  (this.giornata.charAt(this.giornata.length -1) as unknown as number);
    console.log(g);
    g++;
    this.giornata="Giornata "+g;
    console.log(this.giornata);
  }

  previousGiornata(event : Event){
    let g=  (this.giornata.charAt(this.giornata.length -1) as unknown) as number;
    if(g>1){
      g--;
      this.giornata="Giornata "+g;
    }
  }

}
