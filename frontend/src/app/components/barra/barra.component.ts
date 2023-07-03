import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-barra',
  templateUrl: './barra.component.html',
  styleUrls: ['./barra.component.css']
})
export class BarraComponent {

  @Output() next = new EventEmitter();
  @Output() previous = new EventEmitter();

  onNext(){
    console.log("next");
    this.next.emit();
  }

  onPrevious(){
    console.log("previous");
    this.previous.emit();
  }

  @Input() content="";
}
