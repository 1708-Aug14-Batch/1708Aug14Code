package com.Servlets.SerHan;

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

import com.Reburse.Service.Service;
import com.Reburse.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/attemptLogin")
public class attemptLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		System.out.println("Attempting Log in");
		//Grab all params, even though in this case it is only one JSON string
		Map<String, String[]> myMap = request.getParameterMap();
		//Get the keyset from the map
		Set<String> txObject = myMap.keySet();
		//Use Jackson.API for converting JSON to java
		ObjectMapper jackson = new ObjectMapper();
		//Convert our keyset into an array, then get what we need from it
		Object obj = txObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
		String email = tx.get(0);
		System.out.println(email);
		String password = tx.get(1);
		System.out.println(password);
		Service ser = new Service();
		User u = ser.getUser(email, password);
		if(u != null) {
			ses.setAttribute("User", u);
			System.out.println("Forwarding to home");
			request.getRequestDispatcher("app.html").forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			String json = "Failed";
			out.write(json);
		}
	}
	
}
