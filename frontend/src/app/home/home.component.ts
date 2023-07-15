import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RuoloService } from '../services/ruolo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  ruolo: string="";

  constructor(private ruoloService: RuoloService) {}

  ngOnInit() {
    this.ruolo = this.ruoloService.getRuolo();
    console.log("ruolo: '" + this.ruolo + "'");
  }

}
