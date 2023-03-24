package com.flyhigh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource( name = "jdbc/flyhigh")
	private DataSource datasource ;
    private AdminDataUtil adminDataUtil;
    
    private PreparedStatement preparedstmt;
    
    public AdminLogin() {
        super();
     
    }
    public void init(ServletConfig config) throws ServletException {
		try {
			
			adminDataUtil = new AdminDataUtil(datasource);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		boolean r =adminDataUtil.values(username,password);
		System.out.println("r="+r);
		if(r) {
			request.setAttribute("admins_list", adminDataUtil.getAdmins());

		RequestDispatcher rd = request.getRequestDispatcher("Updatepassword.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			out.println("<p> User not found</p>");				

		}
		
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		System.out.println("Present");
//		if(!isValidInput(username,false) || !isValidInput(password,false)) {
//			out.println("<h1>Please Enter valid input...</p>");
//			
//		}
//			
//		
//		try{
//			preparedstmt.setString(1,username);
//			preparedstmt.setString(2,password);
//			ResultSet resultset = null;
//			
//			boolean result=preparedstmt.execute();
//			if(result)
//				resultset = preparedstmt.getResultSet();
//			if(resultset.next()) {
//				System.out.println("User successfully logged in,Navigating to home page");
//				RequestDispatcher rd = request.getRequestDispatcher("");
//				String welcomemessage = "Welcome to the FlyAway Admin portal - " + username + "!!";
//				request.setAttribute("message", welcomemessage);
//				rd.include(request,response);
//			}
//			else {
//				out.println("<p> User not found </p>");
//				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//				rd.include(request,response);
//			}
//		}
//		catch(SQLException e) {
//			out.println("Product not created error Occurred :"+e.getMessage());
//		}
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}
	private boolean isValidInput(String username, boolean b) {
		if(username == null || username.isEmpty()) {
			return false;
		}
		return true;
	
	}

}
