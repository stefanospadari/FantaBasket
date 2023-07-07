import { Component, Input, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-panchinaro',
  templateUrl: './panchinaro.component.html',
  styleUrls: ['./panchinaro.component.css']
})
export class PanchinaroComponent {

  @Input() nome="";
  @Input() ruolo="";

  img="";

  ngOnChanges(changes: SimpleChanges) {
    this.img=this.nome.replace(" ", "_");
  }
}