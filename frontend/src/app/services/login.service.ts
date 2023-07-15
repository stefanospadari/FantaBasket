import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = 'http://localhost:8081/FantaBasket/login' // URL del tuo endpoint del server

  constructor(private http: HttpClient) { }

  effettuaLogin(username: string, password: string): Observable<any> {
    

    //const headers = new HttpHeaders().set('Cookie', 'session-id=xxxxxxxxx');
  
    return this.http.get(this.url + '?username=' + username + '&password=' + password);
  }

}
