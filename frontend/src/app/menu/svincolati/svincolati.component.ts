import { Component } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Giocatore } from 'src/app/components/giocatore/giocatore.component';

@Component({
  selector: 'app-svincolati',
  templateUrl: './svincolati.component.html',
  styleUrls: ['./svincolati.component.css']
})
export class SvincolatiComponent {

  svincolati: Giocatore[] = [];

  name = new FormControl('')

  ngOnInit(){
    let g : Giocatore;
    this.svincolati.push(g={nome: "Awadu Abass", ruolo:"A"});
    this.svincolati.push(g={nome: "Niccolò Melli", ruolo:"C"});
    this.svincolati.push(g={nome: "Milos Teodosic", ruolo:"G"});
    this.svincolati.push(g={nome: "Shavon Shields", ruolo:"A"});
    this.svincolati.push(g={nome: "Adrian Banks", ruolo:"G"});
    this.svincolati.push(g={nome: "Kyle Hines", ruolo:"C"});

  }

  show(name: string){
    if(this.name.value=="")
      return true;
    else
      return (name.split(" ")[0].toLowerCase().startsWith(""+this.name.value) || name.split(" ")[1].toLowerCase().startsWith(""+this.name.value));
  }
  
}
