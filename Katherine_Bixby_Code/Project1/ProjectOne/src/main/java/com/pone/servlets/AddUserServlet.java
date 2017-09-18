package com.pone.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pone.pojos.AUser;
import com.pone.service.Service;


@WebServlet("/addEmp")
public class AddUserServlet extends HttpServlet {

	static Service service = new Service();
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		boolean noCommit = false;
		
		AUser newUser = new AUser();
		String firstName = request.getParameter("addfirst");
		if(firstName==null||firstName=="") {
			noCommit = true;
		}
		String lastName = request.getParameter("addlast");
		if(lastName==null||lastName=="") {
			noCommit = true;
		}
		String userName = request.getParameter("adduname");
		if(userName==null||userName=="") {
			noCommit = true;
		}
		String email = request.getParameter("addemail");
		if(email==null||email=="") {
			noCommit = true;
		}
		String password = request.getParameter("addpassword");
		if(password==null||password=="") {
			noCommit = true;
		}
		if(noCommit==false) {
			newUser = service.addUser(firstName, lastName, userName, email, password);
		}
		else {
			newUser = null;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("managerhome.html");
		session.setAttribute("addedUser", newUser);
		rd.forward(request, response);
		
		
	}
	
}
