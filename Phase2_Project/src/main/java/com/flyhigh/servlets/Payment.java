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
		out.println("<p><h1> Payment Details </h1></p>");
		out.println("<p>Name : "+(name)+"</p>");
		out.println("<p>Emailid = "+(email)+"</p>");
		out.println("<p>Phoneno = "+(phone)+"</p>");
		out.println("<p>Date of travelling = "+(date)+"</p>");
		out.println("<p>payment is done through "+(bname)+" bank</p>");
		out.println("<p>payment successfull"+"</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
