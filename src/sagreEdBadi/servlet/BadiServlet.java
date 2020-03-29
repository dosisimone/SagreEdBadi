package sagreEdBadi.servlet;

import java.util.List;
import java.math.BigDecimal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sagreEdBadi.beans.*;
import sagreEdBadi.persistence.*;

public class BadiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private Articolo[] articoli;
	private Ordine ordine;

	public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
        
        IArticoliReader articoliReader = new ArticoliTxtReader("D:\\Documenti\\Progetti\\SagreEdBadi\\articoli.txt");
        articoli = articoliReader.read();
     
        ordine = new Ordine();        
    }
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
 
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<ul>");
        for (int i = 0; i < articoli.length; ++i) {
        	writer.println("<li>");
        	writer.println(articoli[i].getNome() + ", " + articoli[i].getPrezzo());
        	writer.println("</li>");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
        writer.flush();
    }
 
    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
	
}
