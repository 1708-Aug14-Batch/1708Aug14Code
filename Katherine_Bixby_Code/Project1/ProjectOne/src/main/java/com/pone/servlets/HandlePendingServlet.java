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

@WebServlet("/handlePending")
public class HandlePendingServlet extends HttpServlet{

	static Service service = new Service();
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String jsonPar = request.getParameter("json");
		
		jsonPar = jsonPar.replaceAll("\\\\","");
		String[] jparStr = jsonPar.split(":");
		String[] vars = {"",""};
		int spot = 0;
		for(String s:jparStr) {
			String[] str = s.split("\"");
			for (String st:str) {
				if(!st.equals("")&&!st.equals("{")&&!st.equals("}")&&!st.equals(",")&&!st.equals("rid")&&!st.equals("todo")) {
					//System.out.println("st: "+st);
					vars[spot] = st;
					spot++;
				}
			}
		}
		String todo = vars[0];
		int rid = Integer.parseInt(vars[1]);
		
		AUser loggedIn = (AUser) session.getAttribute("auser");	
		
		int statId = 0;
		////////////////////////////////// HARD CODING IN STATUS TYPE //////////////
		if(todo.equals("A")) {
			statId = 1;
		}
		else if(todo.equals("D")) {
			statId = 2;
		}
		service.editStatusId(rid, statId);
		service.editResolveDate(rid);
		service.editResolverId(rid, loggedIn.getU_id());
		RequestDispatcher rd = request.getRequestDispatcher("managerhome.html");
		session.setAttribute("auser", loggedIn);
		rd.forward(request, response); // successful login
		
		
		
		
	}
	
	
	
	
}
