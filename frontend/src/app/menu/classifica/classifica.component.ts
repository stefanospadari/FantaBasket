import { Component } from '@angular/core';
import { Squadra } from '../../components/squadra/squadra.component';
import { Router } from '@angular/router';
import { SquadreService } from 'src/app/services/squadre.service';

@Component({
  selector: 'app-classifica',
  templateUrl: './classifica.component.html',
  styleUrls: ['./classifica.component.css']
})
export class ClassificaComponent {

  squadre: Squadra[]= [];

  constructor(private router: Router, private squadreService: SquadreService) {}

  navigateToChild() {
    const encodedSquadre = encodeURIComponent(JSON.stringify(this.squadre));
    this.router.navigate(['/su', encodedSquadre]);
  }

  ngOnInit(){
    let s: Squadra;
    this.squadre= this.squadreService.getSquadre();
  }
}
