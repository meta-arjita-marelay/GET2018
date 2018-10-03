package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.UserDetails;
import com.facade.UserFacade;

/**
 * Servlet implementation class Friends
 */
public class Friends extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		List<UserDetails> friendsList = UserFacade.getFriendList(email);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<form action='GetFriendProfile' method='POST'");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>");
		out.println("First name");
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>");
		out.println("Last name");
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>");
		out.println("Email id");
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>");
		out.println("Contact number");
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>");
		out.println("Organization name");
		out.println("</th>");
		out.println("</tr>");
		for (UserDetails friends : friendsList) {
			String fname = friends.getFirstName();
			String lname = friends.getLastname();
			String emailId = friends.getEmailId();
			String contactnumber = friends.getConNumber();
			String orgname = friends.getOrgName();
			out.println("<tr>");
			out.println("<td>" + fname + "</td>");
			out.println("<td>" + lname + "</td>");
			out.println("<td>" + emailId + "</td>");
			out.println("<td>" + contactnumber + "</td>");
			out.println("<td>" + orgname + "</td>");
			out.println("<td>" + "<a href='FriendProfile ? email='" + emailId
					+ "'>View friend</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</form>");
		out.println("</html></body>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
