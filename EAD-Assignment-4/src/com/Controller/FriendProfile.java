package com.Controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.UserDetails;
import com.facade.UserFacade;

/**
 * Servlet implementation class FriendProfile
 */
@WebServlet("/FriendProfile")
public class FriendProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		UserDetails friend = UserFacade.getFriendProfile(email);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>");
		out.println("first name");
		out.println("</th>");
		out.println("<th>");
		out.println(friend.getFirstName());
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>");
		out.println("last name");
		out.println("</th>");
		out.println("<th>");
		out.println(friend.getLastname());
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>");
		out.println("email id");
		out.println("</th>");
		out.println("<th>");
		out.println(friend.getEmailId());
		out.println("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>");
		out.println("contact number");
		out.println("</th>");
		out.println("<th>");
		out.println(friend.getConNumber());
		out.println("</th>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</html></body>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
