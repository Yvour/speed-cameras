    package central;
    import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public class Servlet extends HttpServlet {
    	private static final long serialVersionUID = -4751096228274971485L;
    	@Override
    	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) 
    			throws ServletException, IOException {
    		System.out.println("do get");
    		response.getWriter().println("Hello World!");
    	}
    	
    	
    	
    	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
    		System.out.println("post is gotten");
    		
    		
			
		}

		@Override
    	public void init() throws ServletException {
    		System.out.println("Servlet " + this.getServletName() + " has started");
    	}
    	@Override
    	public void destroy() {
    		System.out.println("Servlet " + this.getServletName() + " has stopped");
    	}
    }