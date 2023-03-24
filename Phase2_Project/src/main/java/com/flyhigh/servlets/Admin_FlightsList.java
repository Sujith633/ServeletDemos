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

@WebServlet("/Admin_FlightsList")
public class Admin_FlightsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/flyhigh")
	
	private DataSource datasource;
  
	private AdminDataUtil adminDataUtil;
	public Admin_FlightsList() {
		super();

	}
	 public void init(ServletConfig config) throws ServletException {
			try {
				
				adminDataUtil = new AdminDataUtil(datasource);
			} catch (Exception ex) {
				throw new ServletException(ex);
			}
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setAttribute("flight_list", adminDataUtil.getFlights());

		RequestDispatcher dispatch = request.getRequestDispatcher("/view_flights.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
