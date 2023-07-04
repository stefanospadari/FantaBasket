package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Controller.CreazioneCampionatoController;
import model.Giocatore;
import model.Lega;
import model.PesiStatistiche;
import model.Squadra;
import model.Utente;

/*
 * Servlet da mappare in:  /creaCampionato
 */
public class ServletCreazioneCampionato extends HttpServlet
{
	Gson g;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		g = new Gson();
	}
	
	/*
	 * ServletCreazioneCampionato -> richiesta POST
	 *  1. Il parametro "operazione" discrimina cosa si vuole fare
	 *  2. In sessione come parametro di nome "utente" si trova il riferimento all'utente
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
    	String operazione = request.getParameter("operazione");
    	
    	HttpSession session = request.getSession();
    	Utente amministratore = (Utente) session.getAttribute("utente");
    	
    	CreazioneCampionatoController creazioneCampionatoController = new CreazioneCampionatoController();
    	PrintWriter out = response.getWriter(); 
    	 	
    	if(operazione.equals("creazione") && request.getParameter("lega") == null && session.getAttribute("stato") == null)
    	{
    		/*
    		 * Ottengono il nome della lega come parametro in input
    		 * Creo una lega con quel nome se non esiste già
    		 * if lega is not null -> preparo una lista di utenti in sessione per quella che verranno inseriti
    		 */
    		String nomeLega = request.getParameter("nomeLega");
    		Lega lega = creazioneCampionatoController.creaCampionato(amministratore, nomeLega);
    		
    		if (lega != null)
    		{
    			session.setAttribute("lega", lega);
    			List<Utente> utenti = new ArrayList<Utente>();
    			session.setAttribute("utenti", utenti);
    			session.setAttribute("stato", "legaCreata");
    			
    			out.println(g.toJson("creata")); 
    		}
    		else
    			out.println(g.toJson("nome esistente"));
   
    	}
    	else if(operazione.equals("verificaUtente") && session.getAttribute("stato").equals("legaCreata"))
    	{
    		/*
    		 * Verifico se esiste un utente passato come argomento "utente"
    		 * Se esiste me lo salvo in sessione e restituisco l'esito
    		 */
    		String username = request.getParameter("utente");
    		
    		Utente utente = creazioneCampionatoController.verificaUtente(username);
    		if(utente != null)
    		{
    			List<Utente> utenti = (List<Utente>) session.getAttribute("utenti");
    			utenti.add(utente);
    			out.println(g.toJson("verificato"));
    		}
    		else
    			out.println(g.toJson("non valido"));
    		
    	}
    	else if(operazione.equals("inserisciNomeSquadra"))
    	{
    		String u = request.getParameter("utente");
    		String nomeSquadra = request.getParameter("nomeSquadra");
    		boolean esito = false;
    		
    		for(Utente user : (List<Utente>) session.getAttribute("utenti"))
    		{
    			if (user.getUsername().equals(u))
    			{
    				esito = creazioneCampionatoController.inserisciSquadra(user, nomeSquadra);
    				break;
    			}
    		}
 
    		out.println(g.toJson(esito));
    		
    	}
    	else if(operazione.equals("inserisciGiocatori"))
    	{
    		String squadra = request.getParameter("squadra");
    		// il parametro giocatori è una stringa del tipo"[{\"nome\":\"Pippo\",\"cognome\":\"Pluto\",...},{\"nome\":\"Paolo\",\"cognome\":\"Rossi\",...}]";
    		List<Giocatore> giocatori = g.fromJson(request.getParameter("giocatori"), new TypeToken<List<Giocatore>>() {}.getType());
    	
    		Lega lega = (Lega) session.getAttribute("lega");
    		for(Squadra s : lega.getSquadre())
    		{
    			if(s.getNome().equals(squadra))
    			{
    				creazioneCampionatoController.inserisciGiocatori(s, giocatori);
    				break;
    			}
    		}
    		
    	}
    	else if(operazione.equals("inserisciPesiStatistiche"))
    	{
    		PesiStatistiche pesi = g.fromJson(request.getParameter("pesiStatistiche"), PesiStatistiche.class);
    		creazioneCampionatoController.inserisciPesiStatistiche((Lega) session.getAttribute("lega"), pesi);
    	}
    	else if(operazione.equals("iniziaLega"))
    	{
    		creazioneCampionatoController.generazioneCalendario((Lega) session.getAttribute("lega"));
    	}
    	
    	
    	
	} 
	
}
