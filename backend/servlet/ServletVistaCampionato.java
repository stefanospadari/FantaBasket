package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Controller.VistaCampionatoController;
import model.Giocatore;
import model.Lega;
import model.Squadra;


/*
 * Servlet da mappare in:  /campionato
 */
public class ServletVistaCampionato extends HttpServlet
{
	Gson g;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		g = new Gson();
	}
	
	
	/*
	 * Questa servlet si interroga solo con richieste GET
	 * 
	 * Deve esserci sempre un parametro "request" che può avere i valori
	 *   - calendario
	 *   - classifica
	 *   - squadra            (in questo caso deve esserci un altro parametro "nomeSquadra")
	 *   - statisticheMedie   (in questo caso deve esserci un altro parametro "giocatore")
	 *   - svincolati
	 *   - infoGiocatore      (in questo caso devono esserci altri due parametri "giocatore" e "giornata")
	 *   
	 *   
	 *   Esempio:  http://FantaBasket/campionato?request=squadra&nomeSquadra=Giuve
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
    	String richiesta = request.getParameter("request");
    	
    	HttpSession session = request.getSession();
    	//Nella sessione dell'utente c'è sempre un riferimento alla sua lega, se fa parte di una
    	Lega lega = (Lega) session.getAttribute("lega");
    	
    	VistaCampionatoController vistaCampionatoController = new VistaCampionatoController();
    	PrintWriter out = response.getWriter();
    	Giocatore giocatore = null;
    	 
    	//Questa servlet ha senso solo se un utente fa parte di una lega
    	if(lega != null)
    	{
    		if(richiesta.equals("calendario"))
        	{
    			//Restuisco un oggetto Calendario in formato JSON
    			out.println(g.toJson(vistaCampionatoController.getCalendario(lega)));
        	}
    		else if(richiesta.equals("classifica"))
    		{
    			//Restuisco un oggetto List<EntryClassifica> in formato JSON
    			out.println(g.toJson(vistaCampionatoController.getClassifica(lega)));
    		}
    		else if(richiesta.equals("squadra"))
    		{
    			String nomeSquadra = request.getParameter("nomeSquadra");
    			//Restuisco un oggetto Squadra in formato JSON
    			out.println(g.toJson(vistaCampionatoController.getSquadra(lega, nomeSquadra)));
    		}
    		else if(richiesta.equals("statisticheMedie"))
    		{
    			int idGiocatore = Integer.parseInt(request.getParameter("giocatore"));
    			giocatore = null;
    			for(Squadra s : lega.getSquadre())
    			{
    				for(Giocatore g : s.getGiocatori())
    				{
    					if(g.getId() == idGiocatore)
    					{
    						giocatore = g;
    						break;
    					}
    				}
    				
    				if(giocatore != null)
    					break;
    			}
    			if(giocatore == null)
    			{
    				for(Giocatore g : lega.getSvincolati())
    				{
    					if(g.getId() == idGiocatore)
    					{
    						giocatore = g;
    						break;
    					}
    				}
    			}
    			
    			//Restuisco un oggetto StatisticheMedie in formato JSON
    			out.println(g.toJson(vistaCampionatoController.getStatisticheMedieGiocatore(giocatore)));
    			
    		}
    		else if(richiesta.equals("svincolati"))
    		{
    			//Restuisco un oggetto List<Giocatore> in formato JSON
    			out.println(g.toJson(vistaCampionatoController.getSvincolati(lega)));
    			
    		}
    		else if(richiesta.equals("infoGiocatore"))
    		{
    			int idGiocatore = Integer.parseInt(request.getParameter("giocatore"));
    			int giornata = Integer.parseInt(request.getParameter("giornata"));
    			
    			giocatore = null;
    			for(Squadra s : lega.getSquadre())
    			{
    				for(Giocatore g : s.getGiocatori())
    				{
    					if(g.getId() == idGiocatore)
    					{
    						giocatore = g;
    						break;
    					}
    				}
    				
    				if(giocatore != null)
    					break;
    			}
    			if(giocatore == null)
    			{
    				for(Giocatore g : lega.getSvincolati())
    				{
    					if(g.getId() == idGiocatore)
    					{
    						giocatore = g;
    						break;
    					}
    				}
    			}
    			
    			//Restuisco un oggetto InfoGiocatore in formato JSON
    			out.println(g.toJson(vistaCampionatoController.getInfoGiocatore(giocatore, giornata)));
    			
    		}
    		
    		
    		
        }
    }


}
