package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ausiliarie.EntryClassifica;
import ausiliarie.InfoGiocatore;
import ausiliarie.StatisticheMedie;
import model.Calendario;
import model.Giocatore;
import model.GiornataLBA;
import model.IGiornataReale;
import model.Lega;
import model.Squadra;
import model.Statistiche;
import utils.HibernateUtil;

public class VistaCampionatoController implements IVistaCampionato
{

	@Override
	public Calendario getCalendario(Lega lega) 
	{
		Session session = null;
		Transaction tx = null;
		Calendario calendario = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+Lega.class.getSimpleName());			
			List<Lega> leghe = query.list();
			
			for(Lega l : leghe)
			{
				if(l.getNome().equals(lega.getNome()))
				{
					calendario = l.getCalendario();
					break;
				}
			}
			
			tx.commit();     //chiude la transazione
			session.close(); //chiudi la sessione, meglio fare una sessione alla volta
				
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
				
		return calendario;
	}
	
	
	

	@Override
	public List<EntryClassifica> getClassifica(Lega lega) 
	{
		Session session = null;
		Transaction tx = null;
		List<EntryClassifica> classifica = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+Lega.class.getSimpleName());			
			List<Lega> leghe = query.list();
			
			for(Lega l : leghe)
			{
				if(l.getNome().equals(lega.getNome()))
				{		
					classifica = new ArrayList<EntryClassifica>();
					for(Squadra s : l.getSquadre())
						classifica.add(new EntryClassifica(s.getNome(), s.getPuntiClassifica(), s.getPartiteVinte(), s.getPartitePerse(), s.getSommaPunteggi()));
					
					//Ordino la classifica in base ai puntiClassifica
					Collections.sort(classifica);
					break;
				}
			}
			
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
				
		return classifica;
	}

	
	
	
	@Override
	public Squadra getSquadra(Lega lega, String nomeSquadra) 
	{
		Session session = null;
		Transaction tx = null;
		Squadra squadra = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+Lega.class.getSimpleName());			
			List<Lega> leghe = query.list();
			
			for(Lega l : leghe)
			{
				if(l.getNome().equals(lega.getNome()))
				{		
					for(Squadra s : l.getSquadre())
					{
						if(s.getNome().equals(nomeSquadra))
						{
							squadra = s;
							break;
						}
					}
					break;
				}
			}
			
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
				
		return squadra;
	}
	
	
	

	@Override
	public StatisticheMedie getStatisticheMedieGiocatore(Giocatore giocatore) 
	{
		Session session = null;
		Transaction tx = null;
		StatisticheMedie statisticheMedie = new StatisticheMedie(0.0F,0.0F,0.0F,0.0F,0.0F,0.0F,0.0F,0.0F,0.0F,0.0F,0.0F,0.0F);
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Estraggo le statistiche di tutti i giocatori di tutte le partite
			Query query= session.createQuery("from "+Statistiche.class.getSimpleName());			
			List<Statistiche> statistiche = query.list();
			
			int partite = 0;
			for(Statistiche stat : statistiche)
			{
				if(stat.getGiocatore().equals(giocatore))
				{		
					//ho trovato una statistica di quel giocatore
					partite++;
					statisticheMedie.setAssist(statisticheMedie.getAssist() + stat.getAssist());
					statisticheMedie.setFalli(statisticheMedie.getFalli() + stat.getFalli());
					statisticheMedie.setPallePerse(statisticheMedie.getPallePerse() + stat.getPallePerse());
					statisticheMedie.setPalleRecuperate(statisticheMedie.getPalleRecuperate() + stat.getPalleRecuperate());
					statisticheMedie.setPunti(statisticheMedie.getPunti() + stat.getPunti());
					statisticheMedie.setQuintettoBase(statisticheMedie.getQuintettoBase() + stat.getQuintettoBase());
					statisticheMedie.setRimbalziDifensivi(statisticheMedie.getRimbalziDifensivi() + stat.getRimbalziDifensivi());
					statisticheMedie.setRimbalziOffensivi(statisticheMedie.getRimbalziOffensivi() + stat.getRimbalziOffensivi());
					statisticheMedie.setStoppate(statisticheMedie.getStoppate() + stat.getStoppate());
					statisticheMedie.setTiriSbagliati(statisticheMedie.getTiriSbagliati() + stat.getTiriSbagliati());
					statisticheMedie.setTriple(statisticheMedie.getTriple() + stat.getTriple());
					statisticheMedie.setVittoriaSquadra(statisticheMedie.getVittoriaSquadra() + stat.getVittoriaSquadra());
				}
			}
			
			//Faccio la media
			statisticheMedie.setAssist(statisticheMedie.getAssist()/partite);
			statisticheMedie.setFalli(statisticheMedie.getFalli()/partite);
			statisticheMedie.setPallePerse(statisticheMedie.getPallePerse()/partite);
			statisticheMedie.setPalleRecuperate(statisticheMedie.getPalleRecuperate()/partite);
			statisticheMedie.setPunti(statisticheMedie.getPunti()/partite);
			statisticheMedie.setRimbalziDifensivi(statisticheMedie.getRimbalziDifensivi()/partite);
			statisticheMedie.setRimbalziOffensivi(statisticheMedie.getRimbalziOffensivi()/partite);
			statisticheMedie.setStoppate(statisticheMedie.getStoppate()/partite);
			statisticheMedie.setTiriSbagliati(statisticheMedie.getTiriSbagliati()/partite);
			statisticheMedie.setTriple(statisticheMedie.getTriple()/partite);
			statisticheMedie.setVittoriaSquadra((statisticheMedie.getVittoriaSquadra()*100)/partite);
			statisticheMedie.setQuintettoBase((statisticheMedie.getQuintettoBase()*100)/partite);
			
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
				
		return statisticheMedie;
	}
	
	

	@Override
	public List<Giocatore> getSvincolati(Lega lega) 
	{
		Session session = null;
		Transaction tx = null;
		List<Giocatore> svincolati = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+Lega.class.getSimpleName());			
			List<Lega> leghe = query.list();
			
			for(Lega l : leghe)
			{
				if(l.getNome().equals(lega.getNome()))
				{		
					svincolati = l.getSvincolati();
					break;
				}
			}
			
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
				
		return svincolati;
	}

	
	
	@Override
	public InfoGiocatore getInfoGiocatore(Giocatore giocatore, int giornata) 
	{
		Session session = null;
		Transaction tx = null;
		IGiornataReale giornataReale = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+GiornataLBA.class.getSimpleName());			
			List<GiornataLBA> giornate = query.list();
			
			for(GiornataLBA g : giornate)
			{
				if(g.getNumeroGiornata() == giornata)
				{		
					giornataReale = g;
					break;
				}
			}
			
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
				
		return new InfoGiocatore(giocatore, giornataReale.getSquadraAvversaria(giocatore), "Disponibile");
	}

}


