package sagreEdBadi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sagreEdBadi.beans.*;
import sagreEdBadi.controllers.ArticoliController;
import sagreEdBadi.controllers.IArticoliController;
import sagreEdBadi.controllers.IOrdiniController;
import sagreEdBadi.controllers.OrdiniController;
import sagreEdBadi.factories.ArticoliFactory;
import sagreEdBadi.factories.IArticoliFactory;
import sagreEdBadi.factories.IOrdiniFactory;
import sagreEdBadi.factories.OrdiniFactory;
import sagreEdBadi.persistence.*;

public class BadiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	private IOrdiniController controllerOrdini;
	private IArticoliController controllerArticoli;

	public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
     
        IOrdiniFactory ordiniFactory = new OrdiniFactory();
        controllerOrdini = new OrdiniController();    
        IArticoliFactory articoliFactory = new ArticoliFactory();
        controllerArticoli = new ArticoliController();
        
        IArticoliReader articoliReader = new ArticoliTxtReader(articoliFactory, "D:\\Documenti\\Progetti\\SagreEdBadi\\articoli.txt");
        for (Articolo articolo : articoliReader.read()) 
        {
        	controllerArticoli.aggiungiArticolo(articolo);
        }      
    }
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	
    	String actionParameter = request.getParameter("op");
    	if (actionParameter == null) {
    		return;
    	}
    	
    	switch (actionParameter) 
    	{
	    	case "lista_articoli": 
	    	{
	    		serviceListArticoli(request, response);
	    	}
	    	break;
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

	private void serviceListArticoli(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			PrintWriter writer = response.getWriter();
			for (Articolo articolo : controllerArticoli.getArticoli()) 
			{
				writer.print(articolo.getCodice() + "; ");
				writer.print(articolo.getNome() + "; ");
				writer.print(articolo.getPrezzo() + ";");
				writer.println();
			}
	        writer.flush();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
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
		
//		int numeroTavolo = Integer.parseInt(request.getParameter("tavolo"));
//		Tavolo tavolo = new Tavolo();		
//		tavolo.setNumero(numeroTavolo);
//		
//		String nomeOrdine = request.getParameter("nome");
//		Ordine ordine = createNewOrdine();
//		ordine.setNome(nomeOrdine);
//		ordine.setTavolo(tavolo);
	}
	
}
