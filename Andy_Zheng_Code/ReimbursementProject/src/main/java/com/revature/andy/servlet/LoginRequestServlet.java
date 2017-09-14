package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

@WebServlet("/loginRequest")
public class LoginRequestServlet extends HttpServlet{

	final static Logger log = Logger.getLogger(LoginRequestServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> myMap = req.getParameterMap();
		
		Set<String> transObject = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		
		Object obj = transObject.toArray()[0];
		ArrayList<String> to = jackson.readValue((String) obj, ArrayList.class);
	
		log.debug("Login Info\t" + to);
		
		Service s= new Service();
		
		String email = to.get(0);
		String password = to.get(1);
		
		HttpSession session = req.getSession();
		
		log.debug("Session User\t" + session.getAttribute("User"));
		
		int valid = s.validateLogin(email, password);
		String json = null;
		if(valid==1) {
			User newUser = null;
			newUser = s.login(email, password);
			log.debug("Logged in User\t" + newUser);
			session.setAttribute("User", newUser);
			json = Integer.toString(newUser.getIsManager());
		}else if(valid==2) {
			json = "Incorrect Password";
		}else if(valid==0) {
			json = "Incorrect Credentials";
		}
			
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		log.debug("Response\t" + json);
	}
}