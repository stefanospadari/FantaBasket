package Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Calendario;
import model.Formazione;
import model.Giocatore;
import model.Giornata;
import model.GiornataLBA;
import model.IGiornataReale;
import model.Lega;
import model.PesiStatistiche;
import model.ScontroDiretto;
import model.Squadra;
import model.Utente;
import utils.HibernateUtil;

public class CreazioneCampionatoController implements ICreazioneCampionato{

	@Override
	public Lega creaCampionato(Utente amministratore, String nomeLega) 
	{	
		Session session = null;
		Transaction tx = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+Lega.class.getSimpleName());			
			List<Lega> leghe = query.list();
			
			boolean nonTrovato = true;
			for(int i = 0; i < leghe.size() && nonTrovato; i++)
			{
				if(leghe.get(i).getNome().equals(nomeLega))
				{
					nonTrovato = false;
				}
			}
			
			tx.commit();     //chiude la transazione
			session.close(); //chiudi la sessione, meglio fare una sessione alla volta
			
			// se esiste gia una lega di nome "nomeLega" ritorno null
			if(!nonTrovato)
				return null;
			
			//altrimenti creo la lega e la restituisco			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Lega lega = new Lega(nomeLega);
			lega.setAmministratoreLega(amministratore);
			lega.setId(leghe.size());
			
			session.persist(lega);  //persist della lega
		
			tx.commit();
			session.close();
			
			return lega; //restituisco la lega creata
				
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
				
		return null;
	}

	
	
	
	@Override
	public Utente verificaUtente(String username) 
	{		
		Session session = null;
		Transaction tx = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+Utente.class.getSimpleName());			
			List<Utente> utenti = query.list();
			Utente utente = null;
			
			for(int i = 0; i < utenti.size() && utente == null; i++)
			{
				if(utenti.get(i).getUsername().equals(username))
				{
					utente = utenti.get(i);
				}
			}
			
			tx.commit();     //chiude la transazione
			session.close(); //chiudi la sessione, meglio fare una sessione alla volta
			
			// L'utente "username" NON esiste
			if(utente == null)
				return null;
			
			// else l'utente "username" ESISTE
			// Se  fa gia parte di una lega -> return null
			// altrimenti restituisco l'utente
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			query= session.createQuery("from "+Lega.class.getSimpleName());			
			List<Lega> leghe = query.list();
			
			for(int i = 0; i < leghe.size(); i++)
			{
				for(Squadra s : leghe.get(i).getSquadre())
				{
					if(s.getAllenatore().equals(utente))
						// Ho trovato la squadra allenata da "username"
						return null;
				}
			}
			
			tx.commit();     //chiude la transazione
			session.close(); //chiudi la sessione, meglio fare una sessione alla volta
			
			// L'utente esiste e non fa parte di nessun lega
			return utente;
				
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
				
		return null;
	}
	
	
	

	@Override
	public boolean inserisciSquadra(Utente utente, String nomeSquadra, Lega lega) 
	{
		// Il nome della squadra deve essere univoco all'interno della lega
		if(lega.getSquadre() != null)
		{
			for(Squadra s : lega.getSquadre())
			{
				if(s.getNome().equals(nomeSquadra))
					return false;
			}
		}
		
		
		Session session = null;
		Transaction tx = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Query query= session.createQuery("from "+Squadra.class.getSimpleName());			
			
			Squadra newSquadra = new Squadra(utente, nomeSquadra);
			newSquadra.setId(query.list().size());
			newSquadra.setLega(lega);
			//lega.addSquadra(newSquadra);
			
			session.persist(newSquadra);  //persist della lega
			
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

		return true;
	}

	
	
	
	
	@Override
	public void inserisciGiocatori(Squadra squadra, List<Giocatore> giocatori) 
	{
		// I giocatori non devono fare già parte di nessun squadra della lega -> in caso contrario return
		for(Squadra s : squadra.getLega().getSquadre())
		{
			for(Giocatore g : giocatori)
			{
				if(s.getGiocatori().contains(g))
					return;
			}
		}
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			squadra.setGiocatori(new HashSet<>(giocatori));
			
			session.update(squadra);  //update della squadra
			
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
		
		
	}
	
	
	
	
	@Override
	public void inserisciPesiStatistiche(Lega lega, PesiStatistiche pesi) 
	{
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			pesi.setId(lega.getId());	
			session.update(pesi);
			
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
		
	}
	
	
	
	@Override
	public void generazioneCalendario(Lega lega) 
	{
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			// GENERAZIONE DEL CALENDARIO
			Calendario calendario = new Calendario();
			
			// Ottengo la lista di tutte le giornate reali
			Query query = session.createQuery("from "+GiornataLBA.class.getSimpleName());			
			List<GiornataLBA> giornateReali = query.list();
			int totGiornate = giornateReali.size();  // numero totali di giornate reali
			
			int nextGiornata = totGiornate;
			for(GiornataLBA g : giornateReali)
			{
				if(g.getDataOraInizio().isAfter(LocalDateTime.now()) && nextGiornata > g.getNumeroGiornata())
					nextGiornata = g.getNumeroGiornata();
			}
			
			// Il campionato virtuale inizia alla giornata "nextGiornata" del campionato reale
			// e dura $(( totGiornate - nextGiornata )) giornate
			
			// Nel firstRound tutte le squadre si affrontano esattamente una volta tra di loro
			List<Giornata> firstRound = new ArrayList<Giornata>();
			ScontroDiretto sd;
			Set<ScontroDiretto> scontriDiretti;
			
			int n = lega.getSquadre().size();  // n = numero di squadre
			Squadra[] squadre = (Squadra[]) lega.getSquadre().toArray();
			
			int casa, ospite;
			String StringaSquadre = "";
			for (int i=1; i<=n; i++)
				StringaSquadre+=(" " + String.valueOf(i)).substring((" " + String.valueOf(i)).length()-2);
			
			for (int i = 1; i <= n-1+(n%2); i++) 
			{
				//Giornata i
				scontriDiretti = new HashSet<ScontroDiretto>();
				
				casa = Integer.parseInt(StringaSquadre.substring((n - 1)* 2));
				ospite = Integer.parseInt(StringaSquadre.substring((n - 2) * 2, (n - 1) * 2));
				sd = new ScontroDiretto();
				sd.setFormazioneCasa(new Formazione(squadre[casa]));
				sd.setFormazioneOspite(new Formazione(squadre[ospite]));
				scontriDiretti.add(sd);
				
				for (int j=0; j<(int)((n-1)/2); j++) 
				{
					casa = Integer.parseInt(StringaSquadre.substring(j * 2, (j + 1)* 2));
					ospite = Integer.parseInt(StringaSquadre.substring(n - j - 3 + (n%2)));
					sd = new ScontroDiretto();
					sd.setFormazioneCasa(new Formazione(squadre[casa]));
					sd.setFormazioneOspite(new Formazione(squadre[ospite]));
					scontriDiretti.add(sd);
				}
				
				firstRound.add(new Giornata(i, scontriDiretti));

				//Ruota la stringa delle squadre
				StringaSquadre = StringaSquadre.substring((n - 2 + (n%2)) * 2, (n - 1 + (n%2)) * 2) + StringaSquadre;
				StringaSquadre = StringaSquadre.substring(0, (n - 1 + (n%2)) * 2) + StringaSquadre.substring(n * 2, (n + 1 - (n%2)) * 2);
			}
			
			
			List<Giornata> calendarioCompleto = new ArrayList<Giornata>();
			int currentGiornata = nextGiornata;
			
			while(currentGiornata <= totGiornate)
			{
				for(Giornata g : firstRound)
				{
					if(currentGiornata > totGiornate)
						break;
					
					g.setNumeroGiornata(currentGiornata);
					calendarioCompleto.add(g);
					currentGiornata++;
				}
			}
			
			calendario.setCalendario(calendarioCompleto);

			lega.setCalendario(calendario);
			session.update(lega);  //persist della lega
			
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
		
	}

}
