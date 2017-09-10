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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

//@WebServlet("/updateUserInfo")
@WebServlet(name="updateUserInfo", urlPatterns="/updateUserInfo", loadOnStartup=13)
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> myMap = req.getParameterMap();
		
		Set<String> transObject = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		
		Object obj = transObject.toArray()[0];
		ArrayList<String> to = jackson.readValue((String) obj, ArrayList.class);
	
		Service s= new Service();

		HttpSession session = req.getSession();

		User sessionUser = (User) session.getAttribute("User");
		
		User newUser = new User(sessionUser.getUserID(),to.get(0),to.get(1),to.get(2),to.get(3),sessionUser.getIsManager());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		if(s.updateUserInfo(newUser)) {
			newUser = s.getUserByID(sessionUser.getUserID());
			session.setAttribute("User", newUser);
			json = mapper.writeValueAsString("User Information Updated");
		}else {
			json = "";
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
}
}
