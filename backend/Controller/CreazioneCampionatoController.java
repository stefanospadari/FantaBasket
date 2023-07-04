package Controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Giocatore;
import model.Lega;
import model.PesiStatistiche;
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
	public Utente verificaUtente(String username) {
		// Se l'utente di nome username non esiste oppure fa gia parte di una lega		
		return null;
		// altrimento restituisco l'utente
	}

	@Override
	public boolean inserisciSquadra(Utente utente, String nomeSquadra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inserisciGiocatori(Squadra squadra, List<Giocatore> giocatori) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void inserisciPesiStatistiche(Lega lega, PesiStatistiche pesi) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void generazioneCalendario(Lega lega) {
		// TODO Auto-generated method stub
		
	}

}
