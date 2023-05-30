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

@WebServlet("/User_TicketBooking")
public class User_TicketBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource( name = "jdbc/flyhigh")
	private DataSource datasource ;
    private UserDataUtil userDataUtil;
    
    private PreparedStatement preparedstmt;
    
    public User_TicketBooking() {
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
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.setAttribute("flight_list", userDataUtil.getAvailabeFlights(source, destination));
		RequestDispatcher rd = request.getRequestDispatcher("AvailableFlights.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
