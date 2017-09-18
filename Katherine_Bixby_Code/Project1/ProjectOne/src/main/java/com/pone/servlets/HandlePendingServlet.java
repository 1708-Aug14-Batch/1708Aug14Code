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

@WebServlet("/runHandle")
public class HandlePendingServlet extends HttpServlet{

	static Service service = new Service();
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		boolean commit=true;
		
		AUser loggedIn = (AUser) session.getAttribute("auser");
		int handleRID = Integer.parseInt(request.getParameter("ridoption"));
		String handleType = request.getParameter("actionHand");
		String resNotes = request.getParameter("thereason");
		
		if(handleType==null) {
			commit=false;
		}
		if(request.getParameter("ridoption")==null) {
			commit=false;
		}
		if(resNotes==null) {
			resNotes="";
		}
		
		/////////////// HARD CODING THIS IN ///////////////////
		int stId = 0;
		if(handleType.equals("A")) {
			stId=1;
		}
		else if(handleType.equals("D")) {
			stId=2;
		}
		

		int resolverId = loggedIn.getU_id();
		if(commit==true) {
			service.editResolveDate(handleRID);
			service.editResolveNotes(handleRID, resNotes);
			service.editStatusId(handleRID, stId);
			service.editResolverId(handleRID, resolverId);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("managerhome.html");
		session.setAttribute("auser", loggedIn);
		rd.forward(request, response); 
		
		
		
		
	}
	
	
	
}
