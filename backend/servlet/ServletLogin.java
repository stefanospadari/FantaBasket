package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.gson.Gson;

import Controller.ILogin;
import Controller.LoginController;
import Controller.VistaCampionatoController;
import model.Giocatore;
import model.Lega;
import model.Squadra;
import model.Utente;
import utils.HibernateUtil;

public class ServletLogin extends HttpServlet
{
	Gson g;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		g = new Gson();
	}

	
	
	/*
	 * Con una POST a http://FantaBasket/login si esegue il login
	 * 
	 * Nella richiesta devono esserci due parametri
	 * - username
	 * - password
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
    	
    	HttpSession session = request.getSession();
    	
    	ILogin controller = new LoginController();
    	PrintWriter out = response.getWriter();
    	
    	String esito = controller.verificaCredenziali(username, password);
    	
    	
    	if(esito.equals("Utente") || esito.equals("AmministratoreLega"))
    	{
    		Session hibernateSession = null;
    		Transaction tx = null;
  	
    		try {
    			hibernateSession = HibernateUtil.getSessionFactory().openSession();
    			tx = hibernateSession.beginTransaction();
    				
    			Query query= hibernateSession.createQuery("from "+Utente.class.getSimpleName());			
    			List<Utente> utenti = query.list();
    			
    			for(Utente u : utenti)
    			{
    				if(u.getUsername().equals(username))
    				{
    					session.setAttribute("utente", u);
    					break;
    				}
    			}
    			
    			tx.commit();     
    			hibernateSession.close(); 
    				
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
    		
    		
    		try {
    			hibernateSession = HibernateUtil.getSessionFactory().openSession();
    			tx = hibernateSession.beginTransaction();
    				
    			Query query= hibernateSession.createQuery("from "+Lega.class.getSimpleName());			
    			List<Lega> leghe = query.list();
    			
    			for(Lega l : leghe)
    			{
    				for(Squadra s : l.getSquadre())
    				{
    					if(s.getAllenatore().equals(session.getAttribute("utente")));
    					{
    						session.setAttribute("lega", l);
    						break;
    					}
    				}
    				
    				if(session.getAttribute("lega") != null)
    					break;		
    			}
    			
    			tx.commit();     
    			hibernateSession.close(); 
    				
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
    		
    		if(session.getAttribute("lega") == null)
    			// Redirect to ViewCreazioneCampionato
    		else
    			// Redirect to HomeVistaCampionato
				
    		
    	}
    	else if(esito.equals("AdminSistema"))
    	{
    		// Redirect to ViewLog
    	}
    	else
    	{
    		out.println(esito);
    	}    		
		
	}

}





