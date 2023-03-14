package websevices;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;

   
    public UpdateUser() {
        super();
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String Password = request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
		    Statement statement = connection.createStatement(); ){
			
			int result = statement.executeUpdate("update user1 set password='"+ password +"' where email='"+email+"'");
			PrintWriter out = response.getWriter();
			if(result>0) {
				out.println("<h1>User Updated Password</h1>");
			}
			else
			{
				out.println("<h1>Error Updating Password</h1>");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		try {
			if(connection != null) {
				connection.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}