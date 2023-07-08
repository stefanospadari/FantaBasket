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

import com.google.gson.Gson;

import Controller.InserimentoFormazioneController;
import model.Formazione;
import model.Giocatore;
import model.Lega;
import model.Modulo;
import model.Squadra;
import model.Utente;

/*
 * Servlet da mappare in:  /formazione
 */
public class ServletInserimentoFormazione extends HttpServlet
{
	Gson g;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		g = new Gson();
	}
	
	
	/*
	 * Con una GET a http://FantaBasket/formazione  viene restituita la formazione inserita
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		HttpSession session = request.getSession();
    	Lega lega = (Lega) session.getAttribute("lega");
    	Utente utente = (Utente) session.getAttribute("utente");
    	Squadra squadra = null;
    	//Recupero la squadra dell'utente
    	for(Squadra s : lega.getSquadre())
    	{
    		if(s.getAllenatore().equals(utente))
    		{
    			squadra = s;
    			break;
    		}
    	}
    	
    	InserimentoFormazioneController controller = new InserimentoFormazioneController();
    	PrintWriter out = response.getWriter();
    	
    	out.println(g.toJson(controller.getFormazione(lega, squadra)));
	}
	
	
	/*
	 * Con una POST a http://FantaBasket/formazione  si può inserire una nuova formazione
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		HttpSession session = request.getSession();
    	Lega lega = (Lega) session.getAttribute("lega");
    	Utente utente = (Utente) session.getAttribute("utente");
    	Squadra squadra = null;
    	//Recupero la squadra dell'utente
    	for(Squadra s : lega.getSquadre())
    	{
    		if(s.getAllenatore().equals(utente))
    		{
    			squadra = s;
    			break;
    		}
    	}
    	
    	InserimentoFormazioneController controller = new InserimentoFormazioneController();
    	PrintWriter out = response.getWriter();
    	
    	
		/*
		 * Dal frontend ho bisogno di:
		 *  - lista dei titolari
		 *  - lista dei panchinari
		 *  - capitano
		 *  - sesto uomo
		 *  - modulo
		 */
		
		/*
		 * void inserisciFormazione(List<Giocatore> titolari, List<Giocatore> panchinari, Giocatore sestoUomo,
			Giocatore capitano, Modulo modulo, Squadra squadra, Lega lega) 
		 */
		
	}
	

}
