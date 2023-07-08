package Controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Calendario;
import model.Lega;
import model.Utente;
import utils.HibernateUtil;

public class LoginController implements ILogin
{
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	  
	  
	@Override
	public String verificaCredenziali(String username, String password) 
	{
		/*
		 * Return:
		 *  - "Utente"                se si tratta di un utente normale
		 *  - "AmministratoreLega"    se si tratta di un amministratore di Lega
		 *  - "AdminSistema"          se si tratta di un admin di sistema
		 *  - "Utente non esistente"  se lo username non esiste
		 *  - "Password sbagliata"    se la password è sbagliata
		 */
		
		Session session = null;
		Transaction tx = null;
		String esito = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
				
			Query query= session.createQuery("from "+Utente.class.getSimpleName());			
			List<Utente> utenti = query.list();
			
			query= session.createQuery("from "+Lega.class.getSimpleName());			
			List<Lega> leghe = query.list();
			
			for(Utente u : utenti)
			{
				if(u.getUsername().equals(username))
				{
					//boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash)
					byte[] salt = new byte[16];
					for(int i = 0; i < 16; i++)
						salt[i] = (byte) u.getPassword().charAt(i);
					
					byte[] expectedHash = new byte[u.getPassword().length()];
					for(int i = 16; i < u.getPassword().length(); i++)
						expectedHash[i] = (byte) u.getPassword().charAt(i);
					
					boolean verify = isExpectedPassword(password.toCharArray(), salt, expectedHash);
					
					if(!verify)
						esito = "Password sbagliata";
					else
					{
						// La password è corretta
						// devo capire il suo rolename
						
						if(u.getUsername().equals("admin"))
							esito = "AdminSistema";
						else
						{
							esito = "Utente";
							for(Lega l : leghe)
							{
								if(l.getAmministratoreLega().equals(u))
								{
									esito = "AmministratoreLega";
									break;
								}
							}
						}
					}
					
				} // for utenti
				
				if(esito != null)
					break;
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
		
		if(esito == null)
			esito = "Utente non esistente";
		
		return esito;	
	}
	
	
	/**
	   * Returns true if the given password and salt match the hashed value, false otherwise
	   *
	   * @param password     the password to check
	   * @param salt         the salt used to hash the password
	   * @param expectedHash the expected hashed value of the password
	*/
	private static boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash) 
	{
	    byte[] pwdHash = hash(password, salt);
	    
	    if (pwdHash.length != expectedHash.length) 
	    	return false;
	    
	    for (int i = 0; i < pwdHash.length; i++) 
	    {
	      if (pwdHash[i] != expectedHash[i]) 
	    	  return false;
	    }
	    
	    return true;
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
