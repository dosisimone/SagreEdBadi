package sagreEdBadi.servlet;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BadiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
 
        PrintWriter writer = response.getWriter();
        writer.println("<html>Hello, I am a Java servlet!</html>");
        writer.flush();
    }
 
    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
	
}
