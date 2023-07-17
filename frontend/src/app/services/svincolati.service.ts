import { Injectable } from '@angular/core';
import { Squadra } from '../components/squadra/squadra.component';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Giocatore } from '../components/giocatore/giocatore.component';

export interface EntryGiocatore{
  nome: string;
  cognome: string;
  ruolo:string;
}

@Injectable({
  providedIn: 'root'
})
export class SvincolatiService {

  private url = 'http://localhost:8081/FantaBasket/campionato?request=svincolati' //URL endpoint vistaCampionato

  constructor(private http: HttpClient) { }

  getSvincolati(): Observable<EntryGiocatore[]> {
    return this.http.get<EntryGiocatore[]>(this.url);
  }

}
