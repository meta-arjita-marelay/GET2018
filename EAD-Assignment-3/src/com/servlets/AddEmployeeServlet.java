package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.database.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AddEmployeeServlet is servlet and will be called when add employee button of
 * addemployee.html is called
 * 
 * @author Arjita
 *
 */
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		int age = (Integer.parseInt(request.getParameter("age")));

		Employee employee = new Employee();
		employee.setFname(fname);
		employee.setLname(lname);
		employee.setEmail(email);
		employee.setAge(age);
		try {
			QueryService.insertEmployee(employee);
			request.getRequestDispatcher("ShowEmployeeServlet").include(
					request, response);

		} catch (SQLException e) {
			out.println(e);
		}
		out.println("<!DOCTYPE html><html><head>"
				+ "<link href='style.css' rel=stylesheet></head>" + "<body>");
		out.println("<a href = 'http://localhost:8080/EAD-Assignment-3/'"
				+ " id='backlink'>Back</a> ");
		out.println("</html></body>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
