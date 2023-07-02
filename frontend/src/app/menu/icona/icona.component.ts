import { Component,Input, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-icona',
  templateUrl: './icona.component.html',
  styleUrls: ['./icona.component.css']
})
export class IconaComponent implements OnChanges{

  @Input() tipo="";

  ngOnChanges(changes: SimpleChanges) {
    console.log(changes)
  }
}
