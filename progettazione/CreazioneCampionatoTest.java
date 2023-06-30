package flights.controller.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import flights.controller.MyController;
import flights.model.Airport;
import flights.model.FlightSchedule;
import flights.presistence.tests.DataManagerMock;

public class CreazioneCampionatoTest {
	
	@Test
	public void testCreazioneCampionato() {
		ICreazioneCampionato c=new CreazioneCampionatoController();
		IVistaCampionato v=new VistaCampionatoController();
		
		List<Giocatore> giocatori1=new ArrayList<>();
		Giocatore g1=new Giocatore("Abass", "Abass", "Virtus Bologna", LocalDate.of(1993, 1, 27), Ruolo.ALA);
		giocatori1.add(g1);
		Giocatore g2=new Giocatore("Nicola", "Akele", "Brescia", LocalDate.of(1995, 11, 7 ), Ruolo.ALA);
		giocatori1.add(g2);
		Giocatore g3=new Giocatore("Jamal", "Jones", "Dinamo Sassari", LocalDate.of(1993, 2, 17), Ruolo.ALA);
		giocatori1.add(g3);
		Giocatore g4=new Giocatore("Kaspar", "Treier", "Dinamo Sassari", LocalDate.of(1999, 9, 19), Ruolo.ALA);
		giocatori1.add(g4);
		Giocatore g5=new Giocatore("Stefano", "Gentile", "Dinamo Sassari", LocalDate.of(1989, 9, 20), Ruolo.ALA);
		giocatori1.add(g5);
		Giocatore g6=new Giocatore("Timothe", "Luwawu-Cabarrot", "EA7 Milano", LocalDate.of(1995, 5, 9), Ruolo.GUARDIA);
		giocatori1.add(g6);
		Giocatore g7=new Giocatore("Nazareth", "Mitrou-Long", "EA7 Milano", LocalDate.of(1993, 8, 3), Ruolo.GUARDIA);
		giocatori1.add(g7);
		Giocatore g8=new Giocatore("Stefano", "Tonut", "EA7 Milano", LocalDate.of(1993, 11, 7), Ruolo.GUARDIA);
		giocatori1.add(g8);
		Giocatore g9=new Giocatore("Shabazz", "Napier", "EA7 Milano", LocalDate.of(1991, 7, 14), Ruolo.GUARDIA);
		giocatori1.add(g9);
		Giocatore g10=new Giocatore("Tommaso", "Baldasso", "EA7 Milano", LocalDate.of(1998, 1, 29), Ruolo.GUARDIA);
		giocatori1.add(g10);
		Giocatore g11=new Giocatore("Kyle", "Hines", "EA7 Milano", LocalDate.of(1986, 9, 2), Ruolo.CENTRO);
		giocatori1.add(g11);
		Giocatore g12=new Giocatore("Paul Stephan", "Biligha", "EA7 Milano", LocalDate.of(1990, 5, 31), Ruolo.CENTRO);
		giocatori1.add(g12);
		Giocatore a13=new Giocatore("Giampaolo", "Ricci", "EA7 Milano", LocalDate.of(1991, 9, 27), Ruolo.CENTRO);
		giocatori1.add(a13);
		
		List<Giocatore> giocatori2=new ArrayList<>();
		Giocatore a1=new Giocatore("Luigi", "Datome", "EA7 Milano", LocalDate.of(1987, 11, 27), Ruolo.ALA);
		giocatori2.add(a1);
		Giocatore a2=new Giocatore("Leo", "Menalo", "Virtus Bologna", LocalDate.of(2002, 1, 6 ), Ruolo.ALA);
		giocatori2.add(a2);
		Giocatore a3=new Giocatore("Kyle", "Weems", "Virtus Bologna", LocalDate.of(1989, 8, 23), Ruolo.ALA);
		giocatori2.add(a3);
		Giocatore a4=new Giocatore("Semi", "Ojeleye", "Virtus Bologna", LocalDate.of(1994, 12, 5), Ruolo.ALA);
		giocatori2.add(a4);
		Giocatore a5=new Giocatore("Stefano", "Gentile", "Dinamo Sassari", LocalDate.of(1989, 9, 20), Ruolo.ALA);
		giocatori2.add(a5);
		Giocatore a6=new Giocatore("Milos", "Teodosic", "Virtus Bologna", LocalDate.of(1987, 3, 19), Ruolo.GUARDIA);
		giocatori2.add(a6);
		Giocatore a7=new Giocatore("Daniel", "hackett", "Virtus Bologna", LocalDate.of(1987, 12, 19), Ruolo.GUARDIA);
		giocatori2.add(a7);
		Giocatore a8=new Giocatore("niccolo", "Mannion", "Virtus Bologna", LocalDate.of(2001, 3, 14), Ruolo.GUARDIA);
		giocatori2.add(a8);
		Giocatore a9=new Giocatore("Giovanni", "Faldini", "Virtus Bologna", LocalDate.of(2005, 4, 18), Ruolo.GUARDIA);
		giocatori2.add(a9);
		Giocatore a10=new Giocatore("Marco", "Belinelli", "Virtus Bologna", LocalDate.of(1986, 3, 25), Ruolo.GUARDIA);
		giocatori2.add(a10);
		Giocatore a11=new Giocatore("Tornike", "Shengelia", "Virtus Bologna", LocalDate.of(1991, 10, 5), Ruolo.CENTRO);
		giocatori2.add(a11);
		Giocatore a12=new Giocatore("Amedeo", "Tessitori", "Reyer Venezia", LocalDate.of(1994, 10, 7), Ruolo.CENTRO);
		giocatori2.add(a12);
		Giocatore a13=new Giocatore("Jacorey", "Williams", "Napoli", LocalDate.of(1994, 6, 12), Ruolo.CENTRO);
		giocatori2.add(a13);
		//ci creiamo l'utente amministratore del campionato
		Utente amministratore=new Utente("amministratore");
		Utente utente=new Utente("utente 1");
		String nomeLega="fantaBasket";
		c.creaCampionato(amministratore, nomeLega);
		
		Lega lega;//questo oggetto è stato preso dalla sessione e rappresenta la lega creata dal metodo creaCampionato()
		assertEquals(amministratore, lega.getAmministratore());
		assertEquals(nomeLega, lega.getNomelega());
		
		c.inserisciSquadra(amministratore, "squadraAmministratore");
		c.inserisciSquadra(utente, "squadraUtente");
		
		assertEquals(amministratore, v.getSquadra(lega, "squadraAmministratore").getAllenatore());
		assertEquals("squadraAmministratore",v.getSquadra(lega, "squadraAmministratore").getNome());
		assertEquals(utente, v.getSquadra(lega, "squadraUtente").getAllenatore());
		assertEquals("squadraUtente",v.getSquadra(lega, "squadraUtente").getNome());
		
		c.inserisciGiocatori(v.getSquadra(lega, "squadraAmministratore"), giocatori1);
		c.inserisciGiocatori(v.getSquadra(lega, "squadraUtente"), giocatori2);
		
		assertEquals(giocatori1, v.getSquadra(lega, "squadraAmministratore").getGiocatori());
		assertEquals(giocatori2, v.getSquadra(lega, "squadraUtente").getGiocatori());
		
		PesiStatistiche pesi=new PesiStatistiche();//costruttore senza perametri che mette tutti i valori a quelli di default
		c.inserisciPesiStatistiche(lega, pesi);
		
		assertEquals(pesi, lega.getPesiStatistiche());
		
		//controlliamo la modifica dei pesi delle statistiche
		IPesiStatistiche p=new PesiStatisticheController();
		pesi.setPesoPunti(5);
		p.modificaPesiStatistiche(pesi,lega);
		assertEquals(pesi, lega.getPesiStatistiche());
		
		//controlliamo la modifica di una squadra mediante il controller modificaSquadraController
		IModificaSquadra m=new modificaSquadraController();
		
		Giocatore b1=new Giocatore("Andrea", "Cinciarini", "Reggio Emilia", LocalDate.of(1986, 11, 27));
		Giocatore c1=new Giocatore("Marcus", "Lee", "Reggio Emilia", LocalDate.of(1994, 9, 14));
		
		List squadraPrimaDelleModifiche=new ArrayList<>(v.getSquadra(lega, "squadraAmministratore").getGiocatori());
		m.aggiungiGiocatore(b1,v.getSquadra(lega, "squadraAmministratore"), lega.getSvincolati());
		assertEquals(squadraPrimaDelleModifiche, v.getSquadra(lega, "squadraAmministratore").getGiocatori());//devono essere uguali perchè la squadra è già al completo, 
		//quindi non si possono aggiungere dei giocatori
		
		m.eliminaGiocatore(g8, v.getSquadra(lega, "squadraAmministratore"), lega.getSvincolati());
		giocatori1.remove(g8);
		
		//abbiamo rimosso una guardia, quindi possiamo inserire solo una guardia
		
		//proviamo ad inserire un centro
		squadraPrimaDelleModifiche=new ArrayList<>(v.getSquadra(lega, "squadraAmministratore"));
		m.aggiungiGiocatore(c1,v.getSquadra(lega, "squadraAmministratore"), lega.getSvincolati());
		assertEquals(squadraPrimaDelleModifiche, v.getSquadra(lega, "squadraAmministratore").getGiocatori());
		
		//inseriamo il giocatore giusto
		giocatori1.add(b1);
		m.aggiungiGiocatore(b1,v.getSquadra(lega, "squadraAmministratore"), lega.getSvincolati());
		assertEquals(giocatori1, v.getSquadra(lega, "squadraAmministratore").getGiocatori());
	}

	@Test
	public void TestRegistrazioneLogin() {
	    ILogin login = new LoginController();
	    IRegistrazione registrazione = new RegistrazioneController();
	    registrazione.registraUtente("myUsername", "myPassword");
	    assertEquals("utente", login.verificaCredenziali("myUsername", "myPassword");
	}

}
