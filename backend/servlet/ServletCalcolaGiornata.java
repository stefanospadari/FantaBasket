package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//RICORDARSI DI MAPPARE LA SERVLET AD UN URL IN WEB.XML
public class ServletCalcolaGiornata extends HttpServlet
{

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	/*
	 * ServletCalcolaGiornata -> richiesta GET con un unico parametro interno che rappresenta il numero della giornata da calcolare
	 *  1. Controllare che l'utente nella sessione sia amministratore
	 *  2. Il campionato di cui calcolare la giornata si trova sempre nella sessione
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
    	int numeroGiornata = Integer.parseInt(request.getParameter("numeroGiornata"));
    	/*
    	 * Effettuare i controlli sul numero della giornata
    	 *  1. 0 < numeroGiornata < giornateTotali
    	 *  2. La giornata deve essere calcolabile
    	 */
    	
    	HttpSession session = request.getSession();
		Lega lega = (Lega) session.getAttribute("lega");
    	
    	// Procurarsi un istanza di CalcolaGiornataController
    	calcolaGiornataController.calcolaGiornata(numeroGiornata, lega);
    	
	} 
	
}
