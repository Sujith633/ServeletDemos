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



@WebServlet("/adduser")
public class Adduserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Adduserservlet() {
        super();
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String emailId = req.getParameter("email");
		String Password = req.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
		    Statement statement = connection.createStatement(); ){
			int result = statement.executeUpdate("insert into user1 values('"+ firstName +"', '"+ lastName +"', '"+ emailId +"', '"+ Password +"')");
			PrintWriter p = response.getWriter();
			if(result > 0) {
				p.println("<h1>User Created in DB</h1>");
			}
			else {
				p.println("<h1>Error creatiing User</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
