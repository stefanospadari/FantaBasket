import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-titolare',
  templateUrl: './titolare.component.html',
  styleUrls: ['./titolare.component.css']
})
export class TitolareComponent{

  @Input() nome="";
  @Input() ruolo="";
  @Input() isCapitano: boolean=false;

  img="";

  ngOnChanges(changes: SimpleChanges) {
    this.img=this.nome.replace(" ", "_");
  }
}
