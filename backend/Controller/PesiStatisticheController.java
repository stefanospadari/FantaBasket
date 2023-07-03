package Controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Lega;
import model.PesiStatistiche;
import utils.HibernateUtil;

public class PesiStatisticheController implements IPesiStatistiche{

	@Override
	public void modificaPesiStatistiche(PesiStatistiche pesiStatistiche, Lega lega) {
		Session session = null;//
		Transaction tx = null;//
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();//
			tx = session.beginTransaction();//
			
			Query query= session.createQuery("from "+PesiStatistiche.class.getSimpleName());
			List<PesiStatistiche> ps = query.list();
			System.out.println(ps.size());
			boolean nonTrovato=true;
			int i=0;
			while(nonTrovato&&i<ps.size()) {
				if(ps.get(i).getLega().equals(lega)) {
					nonTrovato=false;
					pesiStatistiche.setId(ps.get(i).getId());
					/*
					ps.get(i).setPesoPunti(pesiStatistiche.getPesoPunti());
					ps.get(i).setPesoAssist(pesiStatistiche.getPesoAssist());
					ps.get(i).setPesoDoppiaDoppia(pesiStatistiche.getPesoPalleRecuperate());
					ps.get(i).setMalus(pesiStatistiche.getMalus());
					ps.get(i).setPesoPallePerse(pesiStatistiche.getPesoPallePerse());
					ps.get(i).setPesoPalleRecuperate(pesiStatistiche.getPesoPalleRecuperate());
					ps.get(i).setPesoQuadruplaDoppia(pesiStatistiche.getPesoQuadruplaDoppia());
					ps.get(i).setPesoQuintettoBase(pesiStatistiche.getPesoQuintettoBase());
					ps.get(i).setPesoRimbalziDifensivi(pesiStatistiche.getPesoRimbalziDifensivi());
					ps.get(i).setPesoRimbalziOffensivi(pesiStatistiche.getPesoRimbalziOffensivi());
					ps.get(i).setPesoStoppate(pesiStatistiche.getPesoStoppate());
					ps.get(i).setPesoTiroLiberoSbagliato(pesiStatistiche.getPesoTiroLiberoSbagliato());
					ps.get(i).setPesoTiroSbagliato(pesiStatistiche.getPesoTiroSbagliato());
					ps.get(i).setPesoTriplaDoppia(pesiStatistiche.getPesoTriplaDoppia());
					ps.get(i).setPesoTripleSegnate3(pesiStatistiche.getPesoTripleSegnate3());
					ps.get(i).setPesoTripleSegnate4(pesiStatistiche.getPesoTripleSegnate4());
					ps.get(i).setPesoTripleSegnate5piu(pesiStatistiche.getPesoTripleSegnate5piu());
					ps.get(i).setPesoUscitaPerFalli(pesiStatistiche.getPesoUscitaPerFalli());
					session.persist(ps.get(i));*/
				}
				i++;
			}
			//session.saveOrUpdate(pesiStatistiche);
			tx.commit();//chiude la transazione
			session.close();//chiudi la sessione, meglio fare una sessione alla volta
			
			session = HibernateUtil.getSessionFactory().openSession();//
			tx = session.beginTransaction();//
			
			session.saveOrUpdate(pesiStatistiche);
			
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
