import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-squadra',
  templateUrl: './squadra.component.html',
  styleUrls: ['./squadra.component.css']
})
export class SquadraComponent {

  @Input() nome="";

  ngOnInit(){
    this.nome="IngegneriadelSoftware";
  }
}
