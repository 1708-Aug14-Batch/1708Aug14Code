package com.pone.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pone.pojos.AUser;
import com.pone.service.Service;

@WebServlet("/editEmp")
public class EditEmpServlet extends HttpServlet {
	
	static Service service = new Service();
	
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		AUser loggedUser = (AUser) session.getAttribute("auser");
		String firstName = request.getParameter("editfirst");
		if(firstName == null || firstName=="") {
			firstName = loggedUser.getFirstName();
		}
		String lastName = request.getParameter("editlast");
		if(lastName == null || lastName=="") {
			lastName = loggedUser.getLastName();
		}
		String userName = request.getParameter("edituname");
		if(userName == null || userName=="") {
			userName = loggedUser.getUserName();
		}
		String email = request.getParameter("editemail");
		if(email == null || email=="") {
			email = loggedUser.getEmail();
		}
		String password = request.getParameter("editpassword");
		if(password == null || password=="") {
			password = loggedUser.getPassword();
		}
		int theUID = loggedUser.getU_id();
		service.editFirstName(theUID, firstName);
		service.editLastName(theUID, lastName);
		service.editUserName(theUID, userName);
		service.editEmail(theUID, email);
		service.editPassword(theUID, password);
		AUser theUpdated = service.getUser(theUID);
		RequestDispatcher rd = request.getRequestDispatcher("employeehome.html");
		session.setAttribute("auser", theUpdated);
		rd.forward(request, response);
		
		
	}



}