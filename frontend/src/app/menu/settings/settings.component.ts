import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent {

  calcolabile: number =0;
  calcolabili: number[]= [];
  selected = new FormControl();

  ngOnInit(){
    this.calcolabile=5;
    for(let i=0; i<5; i++)
      this.calcolabili.push(i);

    this.selected.setValue(this.calcolabili[this.calcolabili.length -1]);
  }

}
