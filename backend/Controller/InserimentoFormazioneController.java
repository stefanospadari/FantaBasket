package Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Calendario;
import model.Formazione;
import model.Giocatore;
import model.Giornata;
import model.IGiornataReale;
import model.Lega;
import model.Modulo;
import model.ScontroDiretto;
import model.Squadra;
import utils.HibernateUtil;

public class InserimentoFormazioneController implements IInserimentoFormazione
{

	@Override
	public void inserisciFormazione(List<Giocatore> titolari, List<Giocatore> panchinari, Giocatore sestoUomo,
			Giocatore capitano, Modulo modulo, Squadra squadra, Lega lega) 
	{
		Session session = null;
		Transaction tx = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			//Devo scoprire a quale giornata siamo -> ciclo sulle giornate del mio calendario	
			Giornata current = null;
			IGiornataReale giornataReale = null;
			for(Giornata g : lega.getCalendario().getCalendario())
			{
				giornataReale = g.getGiornataReale();
				if((giornataReale.getDataOraInizio().isAfter(LocalDateTime.now()) && 
					giornataReale.getDataOraInizio().isBefore(current.getGiornataReale().getDataOraInizio()))
						|| current == null )
				{
					current = g;
				}
			}
			
			//Posso inserire la formazione solo se manca più di un ora all'inizio del campionato
			if(current.getGiornataReale().getDataOraInizio().isAfter(LocalDateTime.now().plusHours(1)))
			{
				ScontroDiretto scontroDiretto = null;
				String sponda = null;
				for(ScontroDiretto sd : current.getScontriDiretti())
				{
					if(sd.getFormazioneCasa().getSquadra().equals(squadra))
					{
						scontroDiretto = sd;
						sponda = "casa";
						break;
					}
					else if(sd.getFormazioneOspite().getSquadra().equals(squadra))
					{
						scontroDiretto = sd;
						sponda = "ospite";
						break;
					}
					
				}
				
				if(scontroDiretto != null)
				{
					if(sponda.equals("casa"))
					{
						scontroDiretto.setFormazioneCasa(new Formazione(titolari, panchinari, capitano,
								sestoUomo, modulo, squadra));
					}
					else if(sponda.equals("ospite"))
					{
						scontroDiretto.setFormazioneOspite(new Formazione(titolari, panchinari, capitano,
								sestoUomo, modulo, squadra));
					}
				}
				
				session.persist(scontroDiretto);  
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

	}
	
	
	
	

	@Override
	public Formazione getFormazione(Lega lega, Squadra squadra)
	{
		Session session = null;
		Transaction tx = null;
		Formazione formazione = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			//Devo scoprire a quale giornata siamo -> ciclo sulle giornate del mio calendario	
			Giornata current = null;
			IGiornataReale giornataReale = null;
			for(Giornata g : lega.getCalendario().getCalendario())
			{
				giornataReale = g.getGiornataReale();
				if((giornataReale.getDataOraInizio().isAfter(LocalDateTime.now()) && 
					giornataReale.getDataOraInizio().isBefore(current.getGiornataReale().getDataOraInizio()))
						|| current == null )
				{
					current = g;
				}
			}
			
			//Ciclo sugli scontri diretti della prossima giornata
			for(ScontroDiretto sd : current.getScontriDiretti())
			{
				if(sd.getFormazioneCasa().getSquadra().equals(squadra))
				{
					formazione = sd.getFormazioneCasa();
					break;
				}
				else if(sd.getFormazioneOspite().getSquadra().equals(squadra))
				{
					formazione = sd.getFormazioneOspite();
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
		
		return formazione;
	}
	
	
	

}
