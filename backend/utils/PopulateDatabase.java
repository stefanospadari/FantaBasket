package utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Controller.CreazioneCampionatoController;
import Controller.ICreazioneCampionato;
import Controller.IPesiStatistiche;
import Controller.IRegistrazione;
import Controller.PesiStatisticheController;
import Controller.RegistrazioneController;
import model.Formazione;
import model.Giocatore;
import model.Giornata;
import model.GiornataLBA;
import model.Lega;
import model.Modulo;
import model.Partita;
import model.PesiStatistiche;
import model.Ruolo;
import model.ScontroDiretto;
import model.Squadra;
import model.Statistiche;
import model.Utente;

public class PopulateDatabase 
{
	
	/*
	 * Chiamare questo metodo prima appena si lancia l'applicazione o prima di fare qualche test
	 * per popolare il database con un po di dati arbitrari
	 */
	public static void populate()
	{
		Session session = null;
		Transaction tx = null;

		try {
			HibernateUtil.dropAndCreateTables();
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			
			/*
			 * Inserimento dei giocatori reali
			 */
			Giocatore g1 = new Giocatore(1, "Abass", "Abass", "Virtus Bologna", Date.valueOf(LocalDate.of(1993, 1, 27)), Ruolo.ALA);
			session.persist(g1);
			Giocatore g2 = new Giocatore(2, "Milos", "Teodosic", "Virtus Bologna", Date.valueOf(LocalDate.of(1987, 3, 19)), Ruolo.GUARDIA);
			session.persist(g2);
			Giocatore g3 = new Giocatore(3, "Daniel", "hackett", "Virtus Bologna", Date.valueOf(LocalDate.of(1987, 12, 19)), Ruolo.GUARDIA);
			session.persist(g3);
			Giocatore g4 = new Giocatore(4, "Niccolo", "Mannion", "Virtus Bologna", Date.valueOf(LocalDate.of(2001, 3, 14)), Ruolo.GUARDIA);
			session.persist(g4);
			Giocatore g5 = new Giocatore(5, "Giovanni", "Faldini", "Virtus Bologna", Date.valueOf(LocalDate.of(2005, 4, 18)), Ruolo.GUARDIA);
			session.persist(g5);
			Giocatore g6 = new Giocatore(6, "Marco", "Belinelli", "Virtus Bologna", Date.valueOf(LocalDate.of(1986, 3, 25)), Ruolo.GUARDIA);
			session.persist(g6);
			Giocatore g7 = new Giocatore(7, "Tornike", "Shengelia", "Virtus Bologna", Date.valueOf(LocalDate.of(1991, 10, 5)), Ruolo.CENTRO);
			session.persist(g7);
			Giocatore g8 = new Giocatore(8, "Leo", "Menalo", "Virtus Bologna", Date.valueOf(LocalDate.of(2002, 1, 6 )), Ruolo.ALA);
			session.persist(g8);
			Giocatore g9 = new Giocatore(9, "Kyle", "Weems", "Virtus Bologna", Date.valueOf(LocalDate.of(1989, 8, 23)), Ruolo.ALA);
			session.persist(g9);
			Giocatore g10 = new Giocatore(10, "Semi", "Ojeleye", "Virtus Bologna", Date.valueOf(LocalDate.of(1994, 12, 5)), Ruolo.ALA);
			session.persist(g10);
			
			Giocatore g11 = new Giocatore(11, "Nicola", "Akele", "Brescia", Date.valueOf(LocalDate.of(1995, 11, 7 )), Ruolo.ALA);
			session.persist(g11);
			
			Giocatore g12 = new Giocatore(12, "Jamal", "Jones", "Dinamo Sassari", Date.valueOf(LocalDate.of(1993, 2, 17)), Ruolo.ALA);
			session.persist(g12);
			Giocatore g13 = new Giocatore(13, "Kaspar", "Treier", "Dinamo Sassari", Date.valueOf(LocalDate.of(1999, 9, 19)), Ruolo.ALA);
			session.persist(g13);
			Giocatore g14 = new Giocatore(14, "Stefano", "Gentile", "Dinamo Sassari", Date.valueOf(LocalDate.of(1989, 9, 20)), Ruolo.ALA);
			session.persist(g14);
			
			Giocatore g15 = new Giocatore(15, "Timothe", "Luwawu-Cabarrot", "EA7 Milano", Date.valueOf(LocalDate.of(1989, 9, 20)), Ruolo.ALA);
			session.persist(g15);
			Giocatore g16 = new Giocatore(16, "Nazareth", "Mitrou-Long", "EA7 Milano", Date.valueOf(LocalDate.of(1993, 8, 3)), Ruolo.GUARDIA);
			session.persist(g16);
			Giocatore g17 = new Giocatore(17, "Stefano", "Tonut", "EA7 Milano", Date.valueOf(LocalDate.of(1993, 11, 7)), Ruolo.GUARDIA);
			session.persist(g17);
			Giocatore g18 = new Giocatore(18, "Shabazz", "Napier", "EA7 Milano", Date.valueOf(LocalDate.of(1991, 7, 14)), Ruolo.GUARDIA);
			session.persist(g18);
			Giocatore g19 = new Giocatore(19, "Tommaso", "Baldasso", "EA7 Milano", Date.valueOf(LocalDate.of(1998, 1, 29)), Ruolo.GUARDIA);
			session.persist(g19);
			Giocatore g20 = new Giocatore(20, "Kyle", "Hines", "EA7 Milano", Date.valueOf(LocalDate.of(1986, 9, 2)), Ruolo.CENTRO);
			session.persist(g20);
			Giocatore g21 = new Giocatore(21, "Paul Stephan", "Biligha", "EA7 Milano", Date.valueOf(LocalDate.of(1990, 5, 31)), Ruolo.CENTRO);
			session.persist(g21);
			Giocatore g22 = new Giocatore(22, "Giampaolo", "Ricci", "EA7 Milano", Date.valueOf(LocalDate.of(1991, 9, 27)), Ruolo.CENTRO);
			session.persist(g22);
			Giocatore g23 = new Giocatore(23, "Luigi", "Datome", "EA7 Milano", Date.valueOf(LocalDate.of(1987, 11, 27)), Ruolo.ALA);
			session.persist(g23);
			Giocatore g24 = new Giocatore(24, "Nicolò", "Melli", "EA7 Milano", Date.valueOf(LocalDate.of(1991, 5, 14)), Ruolo.CENTRO);
			session.persist(g24);
			Giocatore g25= new Giocatore(25, "Billy", "Baron", "EA7 Milano", Date.valueOf(LocalDate.of(1990, 6, 21)), Ruolo.GUARDIA);
		    session.persist(g25);
		    Giocatore g26 = new Giocatore(26, "Devon", "Hall", "EA7 Milano", Date.valueOf(LocalDate.of(1995, 1, 4)), Ruolo.GUARDIA);
		    session.persist(g26);
		    Giocatore g27 = new Giocatore(27, "Shavon", "Shields", "EA7 Milano", Date.valueOf(LocalDate.of(1994, 7, 13)), Ruolo.ALA);
		    session.persist(g27);
			
		    Giocatore g28 = new Giocatore(28, "Amedeo", "Tessitori", "Reyer Venezia", Date.valueOf(LocalDate.of(1994, 10, 7)), Ruolo.CENTRO);
			session.persist(g28);	
			Giocatore g29 = new Giocatore(29, "Marco", "Spissu", "Reyer Venezia", Date.valueOf(LocalDate.of(1995, 5, 18)), Ruolo.GUARDIA);
		    session.persist(g29);
		    Giocatore g30 = new Giocatore(30, "Jordan", "Parks", "Reyer Venezia", Date.valueOf(LocalDate.of(1994, 7, 14)), Ruolo.ALA);
		    session.persist(g30);
		    Giocatore g31 = new Giocatore(31, "Allerik", "Freeman", "Reyer Venezia", Date.valueOf(LocalDate.of(1994, 6, 5)), Ruolo.GUARDIA);
		    session.persist(g31);
		    Giocatore g32 = new Giocatore(32, "Michael", "Bramos", "Reyer Venezia", Date.valueOf(LocalDate.of(1987, 7, 9)), Ruolo.ALA);
		    session.persist(g32);
		    Giocatore g33 = new Giocatore(33, "Yankuba", "Sima", "Reyer Venezia", Date.valueOf(LocalDate.of(1996, 1, 7)), Ruolo.CENTRO);
		    session.persist(g33);
		    Giocatore g34 = new Giocatore(34, "Riccardo", "Moraschini", "Reyer Venezia", Date.valueOf(LocalDate.of(1991, 12, 12)), Ruolo.GUARDIA);
		    session.persist(g34);
		    Giocatore g35 = new Giocatore(35, "Andrea", "De Nicolao", "Reyer Venezia", Date.valueOf(LocalDate.of(1991, 8, 25)), Ruolo.GUARDIA);
		    session.persist(g35);
		    Giocatore g36 = new Giocatore(36, "Jayson", "Granger", "Reyer Venezia", Date.valueOf(LocalDate.of(1989, 7, 5)), Ruolo.GUARDIA);
		    session.persist(g36);
		    Giocatore g37 = new Giocatore(37, "Matteo", "Chillo", "Reyer Venezia", Date.valueOf(LocalDate.of(1993, 11, 22)), Ruolo.ALA);
		    session.persist(g37);
		    Giocatore g38 = new Giocatore(38, "Jeff", "Brooks", "Reyer Venezia", Date.valueOf(LocalDate.of(1989, 3, 29)), Ruolo.ALA);
		    session.persist(g38);
		    Giocatore g39 = new Giocatore(39, "Derek", "Willis", "Reyer Venezia", Date.valueOf(LocalDate.of(1995, 6, 7)), Ruolo.ALA);
		    session.persist(g39);
		    Giocatore g40 = new Giocatore(40, "Mitchell", "Watt", "Reyer Venezia", Date.valueOf(LocalDate.of(1989, 3, 8)), Ruolo.CENTRO);
		    session.persist(g40);
			
		    Giocatore g41 = new Giocatore(41, "Jacorey", "Williams", "Napoli", Date.valueOf(LocalDate.of(1994, 6, 12)), Ruolo.CENTRO);
			session.persist(g41);		
			Giocatore g42 = new Giocatore(42, "Andrea", "Zerini", "Napoli", Date.valueOf(LocalDate.of(1988, 5, 11)), Ruolo.ALA);
		    session.persist(g42);	
		    Giocatore g43 = new Giocatore(43, "Jordan", "Howard", "Napoli", Date.valueOf(LocalDate.of(1996, 6, 5)), Ruolo.GUARDIA);
		    session.persist(g43);	
		    Giocatore g44 = new Giocatore(44, "Joe", "Young", "Napoli", Date.valueOf(LocalDate.of(1992, 11, 25)), Ruolo.GUARDIA);
		    session.persist(g44);	
		    Giocatore g45 = new Giocatore(45, "David", "Michineau", "Napoli", Date.valueOf(LocalDate.of(1994, 6, 29)), Ruolo.GUARDIA);
		    session.persist(g45);	
		    Giocatore g46 = new Giocatore(46, "Nicolò", "Dellosto", "Napoli", Date.valueOf(LocalDate.of(2000, 9, 15)), Ruolo.ALA);
		    session.persist(g46);	
		    Giocatore g47 = new Giocatore(47, "Devin", "Davis", "Napoli", Date.valueOf(LocalDate.of(1995, 3, 7)), Ruolo.ALA);
		    session.persist(g47);	
		    Giocatore g48 = new Giocatore(48, "Lorenzo", "Uglietti", "Napoli", Date.valueOf(LocalDate.of(1994, 6, 14)), Ruolo.GUARDIA);    
		    session.persist(g48);	
		    Giocatore g49 = new Giocatore(49, "Elijah", "Stewart", "Napoli", Date.valueOf(LocalDate.of(1995, 6, 2)), Ruolo.ALA);
		    session.persist(g49);	
		    Giocatore g50 = new Giocatore(50, "Simone", "Zanotti", "Napoli", Date.valueOf(LocalDate.of(1992, 2, 7)), Ruolo.ALA);
		    session.persist(g50);
		    
		    Giocatore g51 = new Giocatore(51, "Jalen", "Hudson", "Trieste", Date.valueOf(LocalDate.of(1996, 5, 18)), Ruolo.ALA);
		    session.persist(g51);
		    Giocatore g52 = new Giocatore(52, "Stefano", "Bossi", "Trieste", Date.valueOf(LocalDate.of(1994, 11, 24)), Ruolo.GUARDIA);
		    session.persist(g52);
		    Giocatore g53 = new Giocatore(53, "Corey", "Davis", "Trieste", Date.valueOf(LocalDate.of(1997, 5, 28)), Ruolo.GUARDIA);
		    session.persist(g53);
		    Giocatore g54 = new Giocatore(54, "Skylar", "Spencer", "Trieste", Date.valueOf(LocalDate.of(1994, 8, 4)), Ruolo.CENTRO);
		    session.persist(g54);
		    Giocatore g55 = new Giocatore(55, "Lodovico", "Deangeli", "Trieste", Date.valueOf(LocalDate.of(2000, 2, 17)), Ruolo.ALA);
		    session.persist(g55);
		    Giocatore g56 = new Giocatore(56, "Michele", "Ruzzier", "Trieste", Date.valueOf(LocalDate.of(1993, 3, 5)), Ruolo.GUARDIA);
		    session.persist(g56);
		    Giocatore g57 = new Giocatore(57, "Roberts", "Stumbris", "Trieste", Date.valueOf(LocalDate.of(1993, 4, 23)), Ruolo.ALA);
		    session.persist(g57);
		    Giocatore g58 = new Giocatore(58, "Luca", "Campogrande", "Trieste", Date.valueOf(LocalDate.of(1996, 5, 8)), Ruolo.ALA);
		    session.persist(g58);
		    
		    Giocatore g59 = new Giocatore(59, "Junior", "Etou", "Brindisi", Date.valueOf(LocalDate.of(1994, 5, 14)), Ruolo.ALA);
		    session.persist(g59);
		    Giocatore g60 = new Giocatore(60, "Jason", "Burnell", "Brindisi", Date.valueOf(LocalDate.of(1997, 8, 28)), Ruolo.ALA);
		    session.persist(g60);
		    Giocatore g61 = new Giocatore(61, "Marcquise", "Reed", "Brindisi", Date.valueOf(LocalDate.of(1995, 12, 24)), Ruolo.GUARDIA);
		    session.persist(g61);
		    Giocatore g62 = new Giocatore(62, "Dikembe", "Dixson", "Brindisi", Date.valueOf(LocalDate.of(1996, 6, 25)), Ruolo.ALA);
		    session.persist(g62);
		    Giocatore g63 = new Giocatore(63, "Niccolò", "Malaventura", "Brindisi", Date.valueOf(LocalDate.of(2005, 11, 5)), Ruolo.GUARDIA);
		    session.persist(g63);
		    Giocatore g64 = new Giocatore(64, "Ky", "Bowman", "Brindisi", Date.valueOf(LocalDate.of(1997, 8, 9)), Ruolo.GUARDIA);
		    session.persist(g64);
		    Giocatore g65 = new Giocatore(65, "D'Angelo", "Harrison", "Brindisi", Date.valueOf(LocalDate.of(1993, 6, 28)), Ruolo.GUARDIA);
		    session.persist(g65);
		    Giocatore g66 = new Giocatore(66, "Marco", "Vitucci", "Brindisi", Date.valueOf(LocalDate.of(2004, 4, 23)), Ruolo.GUARDIA);
		    session.persist(g66);
		    Giocatore g67 = new Giocatore(67, "Doron", "Lamb", "Brindisi", Date.valueOf(LocalDate.of(1991, 8, 14)), Ruolo.GUARDIA);
		    session.persist(g67);
		    Giocatore g68 = new Giocatore(68, "Bruno", "Mascolo", "Brindisi", Date.valueOf(LocalDate.of(1996, 9, 18)), Ruolo.GUARDIA);
		    session.persist(g68);
		    Giocatore g69 = new Giocatore(69, "Dino", "Bocevski", "Brindisi", Date.valueOf(LocalDate.of(2003, 11, 7)), Ruolo.GUARDIA);
		    session.persist(g69);
		    Giocatore g70 = new Giocatore(70, "Andrea", "Mezzanotte", "Brindisi", Date.valueOf(LocalDate.of(1998, 10, 18)), Ruolo.ALA);
		    session.persist(g70);
		    Giocatore g71 = new Giocatore(71, "Joonas", "Riismaa", "Brindisi", Date.valueOf(LocalDate.of(2000, 5, 16)), Ruolo.GUARDIA);
		    session.persist(g71);
		    Giocatore g72 = new Giocatore(72, "Jordan", "Bayehe", "Brindisi", Date.valueOf(LocalDate.of(1999, 10, 5)), Ruolo.CENTRO);
		    session.persist(g72);
		    Giocatore g73 = new Giocatore(73, "Nick", "Perkins", "Brindisi", Date.valueOf(LocalDate.of(1996, 8, 9)), Ruolo.CENTRO);
		    session.persist(g73);
		    Giocatore g74 = new Giocatore(74, "Dikembe", "Dixson", "Brindisi", Date.valueOf(LocalDate.of(1996, 6, 25)), Ruolo.ALA);
		    session.persist(g74);    
		    
			
			tx.commit();
			session.close();
			
			//Chiudo la sessione cosi intanto mi salva tutti i giocatori
			//poi ne apro una nuova

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				    
		    
			/*
			 * Inserimento di utenti con RegistrazioneController
			 */
			IRegistrazione registrazioneController = new RegistrazioneController();
			registrazioneController.registraUtente("LucaCimino", "ciaoo1234");
			registrazioneController.registraUtente("StefanoSpadari", "sstefano");
			registrazioneController.registraUtente("FedeMinga", "qwertyuiop");
			registrazioneController.registraUtente("User1", "siummmmmmm12");
			/*
			 * Due utenti che non saranno mai inseriti
			 */
			registrazioneController.registraUtente("User2", "aaa");   //password < 8
			registrazioneController.registraUtente("LucaCimino", "newwwwww");   //username già esistente
			
			
			
			
			/*
			 * Creazione di una nuova lega con CreazioneCampionatoController
			 */
			ICreazioneCampionato creazioneCampionatoController = new CreazioneCampionatoController();
			Utente u = creazioneCampionatoController.verificaUtente("LucaCimino");
			Lega lega = creazioneCampionatoController.creaCampionato(u, "serieA");
			
			Utente u1 = creazioneCampionatoController.verificaUtente("StefanoSpadari");
			Utente u2 = creazioneCampionatoController.verificaUtente("FedeMinga");
			Utente u3 = creazioneCampionatoController.verificaUtente("User1");
			
			tx.commit();
			session.close();
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			creazioneCampionatoController.inserisciSquadra(u, "CimiTeam", lega);
			creazioneCampionatoController.inserisciSquadra(u1, "SteTeam", lega);
			creazioneCampionatoController.inserisciSquadra(u2, "FedeTeam", lega);
			creazioneCampionatoController.inserisciSquadra(u3, "UserTeam", lega);
			
			tx.commit();
			session.close();
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Recupero la lega dal DB				
			Query query= session.createQuery("from "+Lega.class.getSimpleName());			
			List<Lega> leghe = query.list();
			for(Lega l : leghe)
			{
				if(l.getId() == lega.getId())
				{
					lega = l;
					break;
				}
			}
			
			List<Giocatore> cU = new ArrayList<Giocatore>();
			cU.add(g74); cU.add(g62); cU.add(g49); cU.add(g30); cU.add(g12);
			cU.add(g18); cU.add(g36); cU.add(g71); cU.add(g45); cU.add(g69); 
			cU.add(g33); cU.add(g22); cU.add(g7);
			for(Squadra s : lega.getSquadre())
    		{
    			if(s.getNome().equals("UserTeam"))
    			{
    				creazioneCampionatoController.inserisciGiocatori(s, cU);
    				break;
    			}
    		}
			
			List<Giocatore> cT = new ArrayList<Giocatore>();
			cT.add(g8); cT.add(g9); cT.add(g14); cT.add(g38); cT.add(g46);
			cT.add(g61); cT.add(g67); cT.add(g48); cT.add(g3); cT.add(g4); 
			cT.add(g72); cT.add(g54); cT.add(g40);
			for(Squadra s : lega.getSquadre())
    		{
    			if(s.getNome().equals("CimiTeam"))
    			{
    				creazioneCampionatoController.inserisciGiocatori(s, cT);
    				break;
    			}
    		}
			
			List<Giocatore> cS = new ArrayList<Giocatore>();
			cS.add(g42); cS.add(g47); cS.add(g37); cS.add(g27); cS.add(g13);
			cS.add(g16); cS.add(g31); cS.add(g43); cS.add(g52); cS.add(g65); 
			cS.add(g73); cS.add(g24); cS.add(g20);
			for(Squadra s : lega.getSquadre())
    		{
    			if(s.getNome().equals("SteTeam"))
    			{
    				creazioneCampionatoController.inserisciGiocatori(s, cS);
    				break;
    			}
    		}
			
			
			List<Giocatore> cF = new ArrayList<Giocatore>();
			cF.add(g10); cF.add(g23); cF.add(g32); cF.add(g50); cF.add(g59);
			cF.add(g17); cF.add(g19); cF.add(g35); cF.add(g44); cF.add(g56); 
			cF.add(g41); cF.add(g28); cF.add(g21);
			for(Squadra s : lega.getSquadre())
    		{
    			if(s.getNome().equals("FedeTeam"))
    			{
    				creazioneCampionatoController.inserisciGiocatori(s, cF);
    				break;
    			}
    		}
			
			
			PesiStatistiche ps = new PesiStatistiche();
			ps.setPesoPunti(30);
			creazioneCampionatoController.inserisciPesiStatistiche(lega, ps);
			
			//creazioneCampionatoController.generazioneCalendario(lega);
			
			
			
			
			
			
			
			tx.commit();
			session.close();

		} catch (Exception e1) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			e1.printStackTrace();
		}
		
		
	
		
		
	} // populate

}
