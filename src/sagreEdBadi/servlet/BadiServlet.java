package sagreEdBadi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sagreEdBadi.beans.*;
import sagreEdBadi.controllers.IOrdiniController;
import sagreEdBadi.controllers.OrdiniController;
import sagreEdBadi.factories.ArticoliFactory;
import sagreEdBadi.factories.IArticoliFactory;
import sagreEdBadi.factories.IOrdiniFactory;
import sagreEdBadi.factories.OrdiniFactory;
import sagreEdBadi.persistence.*;

public class BadiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private Articolo[] articoli;	
	private IOrdiniController controllerOrdini;

	public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
        
        IArticoliReader articoliReader = new ArticoliTxtReader("D:\\Documenti\\Progetti\\SagreEdBadi\\articoli.txt");
        articoli = articoliReader.read();
     
        controllerOrdini = new OrdiniController();    
        
        Tavolo tavolo1 = new Tavolo();
        tavolo1.setNumero(1);
        tavolo1.setNumeroCoperti(4);
        Tavolo tavolo2 = new Tavolo();
        tavolo2.setNumero(2);
        tavolo2.setNumeroCoperti(6);
        
        IArticoliFactory articoliFactory = new ArticoliFactory();
        
        Articolo articolo1 = articoliFactory.creaArticolo("Tagliatelle al ragu`", new BigDecimal("11.00"));
        Articolo articolo2 = articoliFactory.creaArticolo("Tortelloni burro e salvia", new BigDecimal("8.00"));
        Articolo articolo3 = articoliFactory.creaArticolo("Crescenta vuota", new BigDecimal("3.50"));
        Articolo articolo4 = articoliFactory.creaArticolo("Birra peroni", new BigDecimal("3.00"));       
        
        IOrdiniFactory ordiniFactory = new OrdiniFactory();
        Ordine ordine1 = ordiniFactory.creaOrdine("Dosi", tavolo1); 
        ordine1.addArticolo(articolo1, 2);
        ordine1.addArticolo(articolo4, 1);        
        
        Ordine ordine2 = ordiniFactory.creaOrdine("Mattei", tavolo1);  
        ordine2.addArticolo(articolo2, 1);
        ordine2.addArticolo(articolo3, 1);
        
        Ordine ordine3 = ordiniFactory.creaOrdine("Lunghi", tavolo2);  
        ordine3.addArticolo(articolo4, 3);
        
        Ordine ordine4 = ordiniFactory.creaOrdine("Brunelli", tavolo2);  
        ordine4.addArticolo(articolo1, 1);
        
        controllerOrdini.inserisciOrdine(ordine1);
        controllerOrdini.inserisciOrdine(ordine2);
        controllerOrdini.inserisciOrdine(ordine3);
        controllerOrdini.inserisciOrdine(ordine4);
    }
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	
    	HttpSession httpSession = request.getSession();    	
    	
    	String actionParameter = request.getParameter("op");
    	if (actionParameter == null) {
    		return;
    	}
    	
    	switch (actionParameter) 
    	{
	    	case "lista_ordini":
	    	{
	    		serviceListOrders(request, response);
	    	}
	    	break;
	    	case "nuovo_ordine": 
	    	{
	    		serviceNewOrder(request, response);
	    	}
	    	break;
	    	case "nuovo_articolo":
	    	{
	    		
	    	}
	    	break; 		    	
	    	default: 
	    	{
	            PrintWriter writer = response.getWriter();
	            writer.println("<html>Errore: operazione non valida!</html>");
	            writer.flush();
	    	}
	    	break;
    	} 	
    }

	public void destroy() {
        System.out.println("Servlet is being destroyed");
    }

	private void serviceListOrders(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<ul>");
			for (Ordine ordine : controllerOrdini.getOrdini()) 
			{
				writer.println("<li>");
				writer.println(ordine.toString());
				writer.println("</li>");
			}
			writer.println("</ul>");
			writer.println("</body>");
			writer.println("</html>");
	        writer.flush();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	private void serviceNewOrder(HttpServletRequest request, HttpServletResponse response) {
		
		int numeroTavolo = Integer.parseInt(request.getParameter("tavolo"));
		Tavolo tavolo = new Tavolo();		
		tavolo.setNumero(numeroTavolo);
		
		String nomeOrdine = request.getParameter("nome");
		//Ordine ordine = createNewOrdine();
		//ordine.setNome(nomeOrdine);
		//ordine.setTavolo(tavolo);
	}
	
}
