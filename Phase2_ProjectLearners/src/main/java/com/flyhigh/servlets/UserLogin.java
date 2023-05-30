package com.flyhigh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource( name = "jdbc/flyhigh")
	private DataSource datasource ;
    private UserDataUtil userDataUtil;
    
    private PreparedStatement preparedstmt;
    
    public UserLogin() {
        super();
        
    }
    public void init(ServletConfig config) throws ServletException {
		try {
			
			userDataUtil = new UserDataUtil(datasource);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean r =userDataUtil.values(username,password);
		System.out.println("r="+r);
		if(r) {
			
		request.setAttribute("users_list", userDataUtil.getUsers());
		RequestDispatcher rd = request.getRequestDispatcher("Booking.jsp");
		rd.forward(request, response);
		
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
			rd.include(request, response);
			out.println("<p> User not found</p>");

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
