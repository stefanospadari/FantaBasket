package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utente;
import beans.UtentiDB;

//RICORDARSI DI MAPPARE LA SERVLET AD UN URL IN WEB.XML
public class AutenticationServlet extends HttpServlet
{
  
    public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		
		UtentiDB db = new UtentiDB();
		
		Utente u = new Utente();
		u.setUsername("admin");
		u.setPassword("admin");
		db.addUtente(u);
		
		u = new Utente();
		u.setUsername("Mark");
		u.setPassword("12345");
		db.addUtente(u);
		
		u = new Utente();
		u.setUsername("John");
		u.setPassword("natale2019");
		db.addUtente(u);
		
		u = new Utente();
		u.setUsername("Frank");
		u.setPassword("pippo");
		db.addUtente(u);
		
		u = new Utente();
		u.setUsername("Gianni");
		u.setPassword("pluto51");
		db.addUtente(u);
		
		u = new Utente();
		u.setUsername("Zio");
		u.setPassword("aabbCC");
		db.addUtente(u);
		
		u = new Utente();
		u.setUsername("Josh");
		u.setPassword("parigi2");
		db.addUtente(u);
		
		u = new Utente();
		u.setUsername("Alberto");
		u.setPassword("1997");
		db.addUtente(u);
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("utentiDB", db);        //db con scope applicazione		
	}
    

    //DO POST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	if(username == null || password == null || username.equals("") || password.equals(""))
    	{
    		RequestDispatcher rd = getServletContext().getRequestDispatcher("/start.jsp?invalid=wrong");			
    		rd.forward(request, response);
    	}
    	
    	System.out.println("Richiesta login da: username=["+username+"] password=["+password+"]");
    	
    	ServletContext ctx = getServletContext();   
    	UtentiDB db = (UtentiDB) ctx.getAttribute("utentiDB");
    	if(db.confirm(username, password))
    	{ 
    		//utente registrato
    		HttpSession session = request.getSession();
    		session.setAttribute("autenticato", "Y");
    		db.getUtente(username).setSession(session);
    		
    		if(username.equals("admin") && password.equals("admin"))  //DA ELIMINARE SE NON C'E' UN UTENTE ADMIN CON PERMESSI SPECIALI
    		{
    			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");			
    			rd.forward(request, response);
    		}
    		else
    		{
    			RequestDispatcher rd = getServletContext().getRequestDispatcher("/insert.jsp");			
    			rd.forward(request, response);
    		}
    		
    	}
    	else  //username e/o password non validi
    	{
    		RequestDispatcher rd = getServletContext().getRequestDispatcher("/start.jsp?invalid=wrong");			
    		rd.forward(request, response);
    	}
    		
		
	}
    
    


}