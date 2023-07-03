package utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = initHibernateUtil();

	private static final String CREATE_UTENTI = "CREATE TABLE UTENTI (" + 
			"USERNAME VARCHAR(60) NOT NULL," + 
			"PASSWORD VARCHAR(60) NOT NULL," + 
			"PRIMARY KEY (USERNAME)" + 
			")";
	private static final String CREATE_LEGHE ="CREATE TABLE LEGHE (\r\n" + 
			"IDLEGA INT NOT NULL PRIMARY KEY,\r\n" + 
			"NOME VARCHAR(60) NOT NULL DEFAULT '',\r\n" + 
			"PESOPUNTI FLOAT NOT NULL  DEFAULT 1,\r\n" + 
			"PESORIMBALZIDIFENSIVI FLOAT NOT NULL DEFAULT 1,\r\n" + 
			"PESORIMBALZIOFFENSIVI FLOAT NOT NULL DEFAULT 1.25,\r\n" + 
			"PESOASSIST FLOAT NOT NULL DEFAULT 1.5,\r\n" + 
			"PESOPALLERECUPERATE FLOAT NOT NULL DEFAULT 1.5,\r\n" + 
			"PESOPALLEPERSE FLOAT NOT NULL DEFAULT -1.5,\r\n" + 
			"PESOSTOPPATE FLOAT NOT NULL DEFAULT 1.5,\r\n" + 
			"PESODOPPIADOPPIA FLOAT NOT NULL DEFAULT 5,\r\n" + 
			"PESOTRIPLADOPPIA FLOAT NOT NULL DEFAULT 10,\r\n" + 
			"PESOQUADRUPLADOPPIA FLOAT NOT NULL DEFAULT 50,\r\n" + 
			"PESOQUINTETTOBASE FLOAT NOT NULL DEFAULT 1,\r\n" + 
			"PESOTRIPLESEGNATE3 FLOAT NOT NULL DEFAULT 3,\r\n" + 
			"PESOTRIPLESEGNATE4 FLOAT NOT NULL DEFAULT 4,\r\n" + 
			"PESOTRIPLESEGNATE5PIU FLOAT NOT NULL DEFAULT 5,\r\n" + 
			"PESOTIROSBAGLIATO FLOAT NOT NULL DEFAULT -1,\r\n" + 
			"PESOTIROLIBEROSBAGLIATO FLOAT NOT NULL DEFAULT -1,\r\n" + 
			"PESOUSCITAPERFALLI FLOAT NOT NULL DEFAULT -5,\r\n" + 
			"MALUS FLOAT NOT NULL DEFAULT 0,\r\n" + 
			"AMMINISTRATOREDILEGA VARCHAR(60) REFERENCES UTENTI,\r\n" +
			"UNIQUE (NOME))";
	private static final String CREATE_SQUADRE="CREATE TABLE SQUADRE (\r\n" + 
			"IDSQUADRA INT NOT NULL PRIMARY KEY,\r\n" + 
			"NOME VARCHAR(60) NOT NULL,\r\n" + 
			"PUNTICLASSIFICA INT NOT NULL DEFAULT 0,\r\n" + 
			"PARTITEVINTE INT NOT NULL DEFAULT 0,\r\n" + 
			"PARTITEPERSE INT NOT NULL DEFAULT 0,\r\n" + 
			"SOMMAPUNTEGGI FLOAT NOT NULL DEFAULT 0,\r\n" + 
			"ALLENATORE VARCHAR(60) NOT NULL REFERENCES UTENTI,\r\n" + 
			"IDLEGA INT NOT NULL REFERENCES LEGHE,\r\n"+ 
			"UNIQUE (ALLENATORE,IDLEGA),\r\n" + 
			"UNIQUE (NOME,IDLEGA))";
	private static final String CREATE_GIOCATORI="CREATE TABLE GIOCATORI(\r\n" + 
			"IDGIOCATORE INT NOT NULL PRIMARY KEY,\r\n" + 
			"NOME VARCHAR(60) NOT NULL,\r\n" + 
			"COGNOME VARCHAR(60) NOT NULL,\r\n" + 
			"SQUADRAREALE VARCHAR(60),\r\n" + 
			"DATADINASCITA DATE NOT NULL,\r\n" + 
			"RUOLO VARCHAR(60)\r\n" + 
			")\r\n";
	private static final String CREATE_SQUADRE_GIOCATORI="CREATE TABLE SQUADRE_GIOCATORI(\r\n" + 
			"IDSQUADRA INT NOT NULL REFERENCES SQUADRE,\r\n" + 
			"IDGIOCATORE INT NOT NULL REFERENCES GIOCATORI,\r\n" + 
			"PRIMARY KEY(IDSQUADRA,IDGIOCATORE))";
	private static final String CREATE_PARTITE="CREATE TABLE PARTITE(\r\n" + 
			"IDPARTITA INT NOT NULL PRIMARY KEY,\r\n" + 
			"SQUADRACASA VARCHAR(60) NOT NULL,\r\n" + 
			"SQUADRAOSPITE VARCHAR(60) NOT NULL,\r\n" + 
			"DATAORAINIZIO TIMESTAMP NOT NULL,\r\n" + 
			"IDGIORNATA INT REFERENCES GIORNATA)";
	private static final String CREATE_GIORNATA="CREATE TABLE GIORNATA(\r\n" + 
			"IDGIORNATA INT NOT NULL PRIMARY KEY,\r\n" + 
			"NUMEROGIORNATA INT NOT NULL UNIQUE,\r\n" + 
			"CALCOLABILE INT NOT NULL DEFAULT 0\r\n" + 
			")";
	private static final String CREATE_SCONTRIDIRETTI2="CREATE TABLE SCONTRIDIRETTI(\r\n" + 
			"IDSCONTRODIRETTO INT NOT NULL PRIMARY KEY,\r\n" + 
			"PUNTEGGIOCASA FLOAT NOT NULL DEFAULT 0,\r\n" + 
			"PUNTEGGIOOSPITE FLOAT NOT NULL DEFAULT 0,\r\n" + 
			"MALUSCASA INT NOT NULL DEFAULT 0,\r\n" + 
			"MALUSOSPITE INT NOT NULL DEFAULT 0,\r\n" + 
			"IDGIORNATA INT REFERENCES GIORNATA\r\n"+
			")";
	private static final String CREATE_SCONTRIDIRETTI="CREATE TABLE SCONTRIDIRETTI(\r\n" + 
			"IDSCONTRODIRETTO INT NOT NULL PRIMARY KEY,\r\n" + 
			"PUNTEGGIOCASA FLOAT NOT NULL DEFAULT 0,\r\n" + 
			"PUNTEGGIOOSPITE FLOAT NOT NULL DEFAULT 0,\r\n" + 
			"MALUSCASA INT NOT NULL DEFAULT 0,\r\n" + 
			"MALUSOSPITE INT NOT NULL DEFAULT 0,\r\n" + 
			"IDGIORNATA INT REFERENCES GIORNATA,\r\n" + 
			"IDFORMAZIONECASA INT NOT NULL REFERENCES FORMAZIONI,\r\n" + 
			"IDFORMAZIONEOSPITE INT NOT NULL REFERENCES FORMAZIONI, \r\n" + 
	//		"UNIQUE (IDGIORNATA, IDFORMAZIONECASA ,IDFORMAZIONEOSPITE),\r\n" + 
			"CHECK(IDFORMAZIONECASA!=IDFORMAZIONEOSPITE)\r\n" + 
			")";
	private static final String CREATE_FORMAZIONI="CREATE TABLE FORMAZIONI(\r\n" + 
			"IDFORMAZIONE INT NOT NULL PRIMARY KEY,\r\n" + 
			"IDSQUADRA INT REFERENCES SQUADRE,\r\n" + 
			"IDCAPITANO INT REFERENCES GIOCATORI,\r\n" + 
			"IDSESTOUOMO INT REFERENCES GIOCATORI,\r\n" + 
			"MODULO VARCHAR(60),\r\n" + 
			"IDTITOLARE2 INT REFERENCES GIOCATORI,\r\n" + 
			"IDTITOLARE3 INT REFERENCES GIOCATORI,\r\n" + 
			"IDTITOLARE4 INT REFERENCES GIOCATORI,\r\n" + 
			"IDTITOLARE5 INT REFERENCES GIOCATORI,\r\n" + 
			"IDPANCHINARO2 INT REFERENCES GIOCATORI,\r\n" + 
			"IDPANCHINARO3 INT REFERENCES GIOCATORI,\r\n" + 
			"IDPANCHINARO4 INT REFERENCES GIOCATORI,\r\n" + 
			"IDPANCHINARO5 INT REFERENCES GIOCATORI\r\n" + 
			")";
	private static final String CREATE_STATISTICHE="CREATE TABLE STATISTICHE(\r\n" + 
			"IDSTATISTICA INT NOT NULL PRIMARY KEY,\r\n" + 
			"PUNTI INT NOT NULL,\r\n" + 
			"RIMBALZIDIFENSIVI INT NOT NULL,\r\n" + 
			"RIMBALZIOFFENSIVI INT NOT NULL,\r\n" + 
			"ASSIST INT NOT NULL,\r\n" + 
			"PALLERECUPERATE INT NOT NULL,\r\n" + 
			"STOPPATE INT NOT NULL,\r\n" + 
			"TIRISBAGLIATI INT NOT NULL,\r\n" + 
			"TIRILIBERISBAGLIATI INT NOT NULL,\r\n" +
			"PALLEPERSE INT NOT NULL,\r\n" + 
			"FALLI INT NOT NULL,\r\n" + 
			"QUINTETTOBASE INT NOT NULL,\r\n" + 
			"VITTORIASQUADRA INT NOT NULL,\r\n" + 
			"TRIPLE INT NOT NULL,\r\n" + 
			"IDPARTITA INT NOT NULL REFERENCES PARTITE,\r\n" + 
			"IDGIOCATORE INT NOT NULL REFERENCES GIOCATORI,\r\n" + 
			"UNIQUE (IDPARTITA,IDGIOCATORE))";
	
	private static SessionFactory initHibernateUtil() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

	public static void dropAndCreateTables() {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
					
			try {
				session.createSQLQuery("DROP TABLE UTENTI").executeUpdate();
				session.createSQLQuery("DROP TABLE LEGHE").executeUpdate();
				session.createSQLQuery("DROP TABLE SQUADRE").executeUpdate();
				session.createSQLQuery("DROP TABLE GIOCATORI").executeUpdate();
				session.createSQLQuery("DROP TABLE SQUADRE_GIOCATORI").executeUpdate();
				session.createSQLQuery("DROP TABLE FORMAZIONI").executeUpdate();
				session.createSQLQuery("DROP TABLE GIORNATA").executeUpdate();
				session.createSQLQuery("DROP TABLE PARTITE").executeUpdate();
				session.createSQLQuery("DROP TABLE SCONTRIDIRETTI").executeUpdate();
				session.createSQLQuery("DROP TABLE STATISTICHE").executeUpdate();
				
			} catch (HibernateException e) {
				System.out.println("dropTable(): failed to drop tables " + e.getMessage());
			}
			session.createSQLQuery(CREATE_UTENTI).executeUpdate();
			session.createSQLQuery(CREATE_LEGHE).executeUpdate();
			session.createSQLQuery(CREATE_SQUADRE).executeUpdate();
			session.createSQLQuery(CREATE_GIOCATORI).executeUpdate();
			session.createSQLQuery(CREATE_SQUADRE_GIOCATORI).executeUpdate();
			session.createSQLQuery(CREATE_FORMAZIONI).executeUpdate();
			session.createSQLQuery(CREATE_GIORNATA).executeUpdate();
			session.createSQLQuery(CREATE_PARTITE).executeUpdate();
			session.createSQLQuery(CREATE_SCONTRIDIRETTI).executeUpdate();
			session.createSQLQuery(CREATE_STATISTICHE).executeUpdate();
			
			tx.commit();
		} finally {
			session.close();
		}
	}
}
