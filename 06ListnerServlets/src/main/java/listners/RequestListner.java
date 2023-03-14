package listners;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebListener
public class RequestListner implements ServletRequestListener {
	private static final long serialVersionUID = 1L;
       
  
    public RequestListner() {
  
    }
    public void destroy(ServletRequestEvent s) {
    	System.out.println("Request Destroyed.....");
    }
    public void intialize(ServletRequestEvent s) {
    	System.out.println("Request created.........");
    }



}
