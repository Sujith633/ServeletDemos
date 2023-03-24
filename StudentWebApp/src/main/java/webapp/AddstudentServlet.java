package webapp;

import java.io.IOException;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.annotation.Resource;

@WebServlet("/addstudent")
public class AddstudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource( name = "jdbc/studentweb")
	private DataSource datasource;
    private StudentDataUtil studentDataUtil;
    
    
    public void init(ServletConfig config) throws ServletException {
		try {
			
			studentDataUtil = new StudentDataUtil(datasource);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email"); 
		
		studentDataUtil.addStudent(firstname,lastname,email);


		request.setAttribute("students_list", studentDataUtil.getStudents());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add_student.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
