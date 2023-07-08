package Controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Utente;
import utils.HibernateUtil;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class RegistrazioneController implements IRegistrazione
{
	private static final Random RANDOM = new SecureRandom();
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	  
	  	  
	/*
	 * ESITO:
	 *  1  = registrazione correttamente eseguita
	 *  -1 = username già esistente
	 *  -2 = username troppo lungo
	 *  -3 = password < 8 oppure > 64
	 */
	@Override
	public int registraUtente(String username, String password) 
	{
		/*
		 * Valido input
		 *  - username: massimo 64 caratteri alfanumerici
		 *  - password: minimo 8 caratteri alfanumerici, massimo 64
		 */
		
		if(username.length() > 64)
			return -2;
		if(password.length() < 8 || password.length() > 64)
			return -3;
		
		
		Session session = null;
		Transaction tx = null;
		int esito = 1;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+Utente.class.getSimpleName());			
			List<Utente> utenti = query.list();
			
			for(Utente u : utenti)
			{
				if(u.getUsername().equals(username))
				{
					esito = -1;
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
		
		if(esito == -1)
			return esito;
		
		/*
		 *  Registro finalmente l'utente
		 */
		
		// Generazione della salted hashed password
		byte[] salt = getNextSalt();   // a random 16 bytes salt
		byte[] hash = hash(password.toCharArray(), salt);
		
		char[] c = new char[hash.length + salt.length];
        for(int i = 0; i < salt.length; i++)
               c[i] = (char) salt[i];
        for(int i = salt.length; i < c.length; i++)
            c[i] = (char) hash[i-salt.length];
        
        String hashSaltedPassword = new String(c);
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Utente utente = new Utente(username);
			utente.setPassword(hashSaltedPassword);
			session.persist(utente);
			
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
		
		return 1;		
	}
	
	
	/**
	 * @return a 16 bytes random salt to be used to hash a password
	 */
	 private static byte[] getNextSalt() 
	 {
	    byte[] salt = new byte[16];
	    RANDOM.nextBytes(salt);
	    return salt;
	  }
	 
	 
	 /**
	   * Returns a salted and hashed password 
	   * 
	   * @param password     the password to be hashed
	   * @param salt         a 16 bytes salt
	  */
	  private static byte[] hash(char[] password, byte[] salt) 
	  {
	    PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
	
	    try {
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	      	return skf.generateSecret(spec).getEncoded();
	    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
	    	throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
	    } finally {
	    	spec.clearPassword();
	    }
	  }
	
	

}
