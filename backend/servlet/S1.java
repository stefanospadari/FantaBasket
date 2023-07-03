package servlet;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class S1 extends HttpServlet
{
   
    public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		
		Map<HttpSession, List<Long>> logSessioni = new HashMap<HttpSession, List<Long>>();
		ServletContext ctx = getServletContext();
		ctx.setAttribute("logSessioni", logSessioni);

	}
    

    //DO POST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
    	ServletContext ctx = getServletContext();
		Map<HttpSession, List<Long>> logSessioni = (Map<HttpSession, List<Long>>) ctx.getAttribute("logSessioni");
		HttpSession mySession = request.getSession();
		if(logSessioni.get(mySession) == null)
		{
			List<Long> temp = new ArrayList<Long>();
			temp.add(System.currentTimeMillis());
			logSessioni.put(mySession, temp);
		}
		else
		{
			List<Long> temp = logSessioni.get(mySession);
			temp.add(System.currentTimeMillis());
			logSessioni.put(mySession, temp);
		}
    	
    	
		String nomeFile = request.getParameter("nomefile").trim();
		
		System.out.println("S1: Ricevuto ["+nomeFile+"]");
		
		String caratteri = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		Random r = new Random();
		String charToDelete = "" + caratteri.charAt(r.nextInt(caratteri.length()));
		System.out.println("S1: Elimino carattere ["+charToDelete+"] dal file");
		
		String newText = "";
		FileReader reader = new FileReader("C://Users//lucac//Desktop//"+nomeFile);
		int c;
		String ch;
		while((c = reader.read()) > 0) 
		{
			ch = ((char) c) + "";
			if(!ch.equals(charToDelete))
				newText = newText + ch;
		}
		System.out.println("Output di S1 ["+newText+"]");
		reader.close();
		
		
		//forward alla jsp J2
		request.setAttribute("newText", newText);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/J2.jsp");
		dispatcher.forward(request, response);
		
	}


    



}



