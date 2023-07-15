import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RuoloService {
  private ruolo: string="";

  setRuolo(value: string) {
    this.ruolo = value;
  }

  getRuolo(): string {
    return this.ruolo;
  }
}