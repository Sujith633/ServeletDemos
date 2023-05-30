package com.flyhigh.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/flyhigh")
	private DataSource datasource;
  
	private AdminDataUtil adminDataUtil;
       

	public void init(ServletConfig config) throws ServletException {
		// To Create connection
		try {
			
			adminDataUtil = new AdminDataUtil(datasource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
    public UpdateAdmin() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String  password= request.getParameter("password");
		
		adminDataUtil.UpdateAdmin(username, password);	
		
		request.setAttribute("admins_list", adminDataUtil.getAdmins());
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_admins.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
