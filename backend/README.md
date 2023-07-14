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


GET --> localhost:8080/FantaBasket/campionato?request=svincolati
[{"id":1,"nome":"Abass","cognome":"Abass","squadraReale":"Virtus Bologna","dataDiNascita":"gen 27, 1993","ruolo":"ALA"},{"id":2,"nome":"Milos","cognome":"Teodosic","squadraReale":"Virtus Bologna","dataDiNascita":"mar 19, 1987","ruolo":"GUARDIA"},{"id":5,"nome":"Giovanni","cognome":"Faldini","squadraReale":"Virtus Bologna","dataDiNascita":"apr 18, 2005","ruolo":"GUARDIA"},{"id":6,"nome":"Marco","cognome":"Belinelli","squadraReale":"Virtus Bologna","dataDiNascita":"mar 25, 1986","ruolo":"GUARDIA"},{"id":11,"nome":"Nicola","cognome":"Akele","squadraReale":"Brescia","dataDiNascita":"nov 7, 1995","ruolo":"ALA"},{"id":15,"nome":"Timothe","cognome":"Luwawu-Cabarrot","squadraReale":"EA7 Milano","dataDiNascita":"set 20, 1989","ruolo":"ALA"},{"id":25,"nome":"Billy","cognome":"Baron","squadraReale":"EA7 Milano","dataDiNascita":"giu 21, 1990","ruolo":"GUARDIA"},{"id":29,"nome":"Marco","cognome":"Spissu","squadraReale":"Reyer Venezia","dataDiNascita":"mag 18, 1995","ruolo":"GUARDIA"},{"id":34,"nome":"Riccardo","cognome":"Moraschini","squadraReale":"Reyer Venezia","dataDiNascita":"dic 12, 1991","ruolo":"GUARDIA"},{"id":39,"nome":"Derek","cognome":"Willis","squadraReale":"Reyer Venezia","dataDiNascita":"giu 7, 1995","ruolo":"ALA"},{"id":51,"nome":"Jalen","cognome":"Hudson","squadraReale":"Trieste","dataDiNascita":"mag 18, 1996","ruolo":"ALA"},{"id":53,"nome":"Corey","cognome":"Davis","squadraReale":"Trieste","dataDiNascita":"mag 28, 1997","ruolo":"GUARDIA"},{"id":55,"nome":"Lodovico","cognome":"Deangeli","squadraReale":"Trieste","dataDiNascita":"feb 17, 2000","ruolo":"ALA"},{"id":57,"nome":"Roberts","cognome":"Stumbris","squadraReale":"Trieste","dataDiNascita":"apr 23, 1993","ruolo":"ALA"},{"id":58,"nome":"Luca","cognome":"Campogrande","squadraReale":"Trieste","dataDiNascita":"mag 8, 1996","ruolo":"ALA"},{"id":60,"nome":"Jason","cognome":"Burnell","squadraReale":"Brindisi","dataDiNascita":"ago 28, 1997","ruolo":"ALA"},{"id":63,"nome":"Niccol�","cognome":"Malaventura","squadraReale":"Brindisi","dataDiNascita":"nov 5, 2005","ruolo":"GUARDIA"},{"id":64,"nome":"Ky","cognome":"Bowman","squadraReale":"Brindisi","dataDiNascita":"ago 9, 1997","ruolo":"GUARDIA"},{"id":66,"nome":"Marco","cognome":"Vitucci","squadraReale":"Brindisi","dataDiNascita":"apr 23, 2004","ruolo":"GUARDIA"},{"id":68,"nome":"Bruno","cognome":"Mascolo","squadraReale":"Brindisi","dataDiNascita":"set 18, 1996","ruolo":"GUARDIA"},{"id":70,"nome":"Andrea","cognome":"Mezzanotte","squadraReale":"Brindisi","dataDiNascita":"ott 18, 1998","ruolo":"ALA"}]


### Formazione --> /formazione



### Crea campionato -->  /creaCampionato
Già fatto






