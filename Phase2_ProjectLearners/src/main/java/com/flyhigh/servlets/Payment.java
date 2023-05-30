package com.flyhigh.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Payment() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String email = request.getParameter("emailid");
		String date = request.getParameter("date");
		String phone = request.getParameter("phone");
		String bname = request.getParameter("bankname");
		System.out.println(name+email+date);
		PrintWriter out = response.getWriter();
//		out.println("<p>Result = "+(result)+"</p>");
		out.println("<p><table></p>");
		out.println("<p><h1><center> Payment Details <center></h1></p>");
		out.println("<p><center>Name : "+(name)+"<center></p>");
		out.println("<p><center>Emailid = "+(email)+"<center></p>");
		out.println("<p><center>Phoneno = "+(phone)+"<center></p>");
		out.println("<p><center>Date of travelling = "+(date)+"<center></p>");
		out.println("<p><center>payment is done through "+(bname)+" bank<center></p>");
		out.println("<p><center><h1><font color=\"green\">payment successfull</font><center></h1> </p>");
		out.println("<p><table></p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
