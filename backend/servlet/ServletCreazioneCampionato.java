package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utente;

/*
 * Servlet da mappare in:  /creaCampionato
 */
public class ServletCreazioneCampionato extends HttpServlet
{

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	/*
	 * ServletCreazioneCampionato -> richiesta POST
	 *  1. Il parametro "operazione" discrimina cosa si vuole fare
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
    	String operazione = request.getParameter("operazione");
    	
    	//CreazioneCampionatoController creazioneCampionatoController = new CreazioneCampionatoController();
    	
    	HttpSession session = request.getSession();
    	
    	if(operazione.equals("creazione"))
    	{
    		/*
    		 * Ottengono l'utente dalla sessione, e il nome della lega come parametro in input
    		 * Creo una lega con quel nome se non esiste già
    		 * if esito is true -> preparo una lista di utenti in sessione per quella che verranno inseriti
    		 */
    		Utente amministratore = (Utente) session.getAttribute("utente");
    		String nomeLega = request.getParameter("nomeLega");
    		int esito = creazioneCampionatoController.creaCampionato(amministratore, nomeLega);
    		if (esito > 0)
    		{
    			List<Utente> utenti = new ArrayList<Utente>();
    			session.setAttribute("utenti", utenti);
    			session.setAttribute("stato", "legaCreata");
    		}
    		
    		// RETURN ESITO
    	}
    	else if(operazione.equals("verificaUtente") && session.getAttribute("stato").equals("legaCreata"))
    	{
    		/*
    		 * Verifico se esiste un utente passato come argomento "utente"
    		 * Se esiste me lo salvo in sessione e restituisco l'esito
    		 */
    		String username = request.getParameter("utente");
    		
    		// verificaUtente DEVE RESTITUIRE UN UTENTE E NON UN INT !!!!!!!!!!!!!!!!!!!!!!!!!
    		Utente utente = creazioneCampionatoController.verificaUtente(username);
    		if(utente != null)
    		{
    			List<Utente> utenti = (List<Utente>) session.getAttribute("utenti");
    			utenti.add(utente);
    			// return esisto true
    		}
    		else
    			//return esito false
    		
    	}
    	else if(operazione.equals("confermaUtenti"))
    	{
    		List<Utente> utenti = (List<Utente>) session.getAttribute("utenti");
    		if( (utenti.size() >= 2) && (utenti.size()%2 == 0) )
    		{
    			session.setAttribute(", utenti);
    		}
    	}
    	else if(operazione.equals("inserisciNomeSquadra"))
    	{
    		
    	}
    	else if(operazione.equals("inserisciGiocatori"))
    	{
    		
    	}
    	else if(operazione.equals("inserisciPesiStatistiche"))
    	{
    		
    	}
    	else if(operazione.equals("iniziaLega"))
    	{
    		
    	}
    	
    	
    	
	} 
	
}
