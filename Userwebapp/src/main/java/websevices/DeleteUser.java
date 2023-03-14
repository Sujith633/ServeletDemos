package websevices;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteuser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteUser() {
        super();
    }
    public void init() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("email");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
			    Statement statement = connection.createStatement(); ){
				int result = statement.executeUpdate("Delete from user1 where email ='"+ emailId + "'");
				PrintWriter p = response.getWriter();
				if(result > 0) {
					p.println("<h1>Record Deleted</h1>");
				}
				else {
					p.println("<h1>No recorded user found to be deleted</h1>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
