# Interrogazioni al backend

### Login  --> /login

POST -->  localhost:8080/FantaBasket/login?username=LucaCimino&password=ciaoo1234
return "AmministratoreLega"

POST --> localhost:8080/FantaBasket/login?username=StefanoSpadari&password=sstefano
return "Utente"

Altri possibili valori di ritorno possono essere:
"Utente senza lega"        
"Utente non esistente"  
"Password sbagliata"
"AdminSistema" 

### Vista campionato --> /campionato

GET --> localhost:8080/FantaBasket/campionato?request=classifica
"[{"nome":"FedeTeam","puntiClassifica":0,"partiteVinte":0,"partitePerse":0,"sommaPunteggi":0.0},{"nome":"UserTeam","puntiClassifica":0,"partiteVinte":0,"partitePerse":0,"sommaPunteggi":0.0},{"nome":"SteTeam","puntiClassifica":0,"partiteVinte":0,"partitePerse":0,"sommaPunteggi":0.0},{"nome":"CimiTeam","puntiClassifica":0,"partiteVinte":0,"partitePerse":0,"sommaPunteggi":0.0}]"


GET --> localhost:8080/FantaBasket/campionato?request=calendario
NON FUNZIONA ANCORA


GET --> localhost:8080/FantaBasket/campionato?request=squadra&nomeSquadra=SteTeam
return
{"id":1,"nome":"SteTeam","puntiClassifica":0,"partiteVinte":0,"partitePerse":0,"sommaPunteggi":0.0,"giocatori":[{"id":52,"nome":"Stefano","cognome":"Bossi","squadraReale":"Trieste","dataDiNascita":"nov 24, 1994","ruolo":"GUARDIA"},{"id":37,"nome":"Matteo","cognome":"Chillo","squadraReale":"Reyer Venezia","dataDiNascita":"nov 22, 1993","ruolo":"ALA"},{"id":42,"nome":"Andrea","cognome":"Zerini","squadraReale":"Napoli","dataDiNascita":"mag 11, 1988","ruolo":"ALA"},{"id":73,"nome":"Nick","cognome":"Perkins","squadraReale":"Brindisi","dataDiNascita":"ago 9, 1996","ruolo":"CENTRO"},{"id":47,"nome":"Devin","cognome":"Davis","squadraReale":"Napoli","dataDiNascita":"mar 7, 1995","ruolo":"ALA"},{"id":16,"nome":"Nazareth","cognome":"Mitrou-Long","squadraReale":"EA7 Milano","dataDiNascita":"ago 3, 1993","ruolo":"GUARDIA"},{"id":65,"nome":"D\u0027Angelo","cognome":"Harrison","squadraReale":"Brindisi","dataDiNascita":"giu 28, 1993","ruolo":"GUARDIA"},{"id":31,"nome":"Allerik","cognome":"Freeman","squadraReale":"Reyer Venezia","dataDiNascita":"giu 5, 1994","ruolo":"GUARDIA"},{"id":24,"nome":"Nicol�","cognome":"Melli","squadraReale":"EA7 Milano","dataDiNascita":"mag 14, 1991","ruolo":"CENTRO"},{"id":43,"nome":"Jordan","cognome":"Howard","squadraReale":"Napoli","dataDiNascita":"giu 5, 1996","ruolo":"GUARDIA"},{"id":20,"nome":"Kyle","cognome":"Hines","squadraReale":"EA7 Milano","dataDiNascita":"set 2, 1986","ruolo":"CENTRO"},{"id":13,"nome":"Kaspar","cognome":"Treier","squadraReale":"Dinamo Sassari","dataDiNascita":"set 19, 1999","ruolo":"ALA"},{"id":27,"nome":"Shavon","cognome":"Shields","squadraReale":"EA7 Milano","dataDiNascita":"lug 13, 1994","ruolo":"ALA"}]}


### Formazione --> /formazione



### Crea campionato -->  /creaCampionato
Già fatto






