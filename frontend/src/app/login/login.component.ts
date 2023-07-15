import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { RuoloService } from '../services/ruolo.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  ruolo:string="";

  constructor(private router: Router, private loginService: LoginService, private ruoloService: RuoloService) {}

  username= new FormControl();
  password= new FormControl();
  loginSubscription: Subscription | undefined;

  login(){
    this.loginSubscription = this.loginService.effettuaLogin(this.username.value, this.password.value)
    .subscribe(
      (response) => {
        console.log(response);
        if (response == 'AmministratoreLega' || response == 'Utente') {
          this.ruolo = response;
          this.ruoloService.setRuolo(this.ruolo);
          this.router.navigate(['/home']);
        }
      }
    );

  }

}
