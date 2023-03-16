package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginuser")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
    private PreparedStatement preparedstmt;
       
	 public void init(ServletConfig config) {
			try {
				ServletContext context = config.getServletContext();
				String dburl = context.getInitParameter("dburl");
				String dbuser = context.getInitParameter("dbuser");
				String dbpassword = context.getInitParameter("dbpassword");
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
				preparedstmt=connection.prepareStatement("select * from user1 where email = ? and password = ?");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		}
    public LoginServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Present");
		if(!isValidInput(email,false) || !isValidInput(password,false)) {
			out.println("<h1>Please Enter valid input...</p>");
			return;
		}
			
		
		try{
			preparedstmt.setString(1,email);
			preparedstmt.setString(2,password);
			ResultSet resultset = null;
			
			boolean result=preparedstmt.execute();
			if(result)
				resultset = preparedstmt.getResultSet();
			if(resultset.next()) {
				//new navigate to home
				System.out.println("User successfully logged in,Navigating to home page");
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				RequestDispatcher rd = request.getRequestDispatcher("home");
				rd.forward(request,response);
			}
			else {
				out.println("<p> User not found </p>");
				RequestDispatcher rd = request.getRequestDispatcher("loginuser");
				rd.include(request,response);
			}
		}
		catch(SQLException e) {
			out.println("Product not created error Occurred :"+e.getMessage());
		}
		}
	private boolean isValidInput(String email, boolean b) {
		if(email == null || email.isEmpty()) {
			return false;
		}
		return true;
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
