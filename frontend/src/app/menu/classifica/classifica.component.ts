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

  ngOnInit() {
    this.squadreService.getClassifica().subscribe(
      (squadre: Squadra[]) => {
        console.log("response: "+squadre)
        this.squadre = squadre;
        for(let i=0; i<this.squadre.length; i++)
          console.log(squadre[i]);
      }
    );
  }
}
