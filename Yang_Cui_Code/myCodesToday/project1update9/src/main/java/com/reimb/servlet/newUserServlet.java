package com.reimb.servlet;
import java.io.IOException;
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
import com.reimb.main.DBControl;
import com.reimb.pojo.Users;

@WebServlet("/createUser")
public class newUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//Grab all paramenters, in this case only 1 JSON String
		Map<String, String[]> myMap = req.getParameterMap();

		//Get the the keySet from the map, returns a Set
		Set<String> txObject = myMap.keySet();

		//API for converting our JSON into a Java Object
		ObjectMapper jackson = new ObjectMapper();

		//Convert the the keySet into an array, then get the first element (index 0) from that set
		Object obj = txObject.toArray()[0];
		
		ArrayList<String> tx =  jackson.readValue(((String)obj), ArrayList.class);
		
		String userName=tx.get(0);
		String firstName=tx.get(1);
		String lastName=tx.get(2);
		String email=tx.get(3);
		String pass=tx.get(4);
		String role=tx.get(5);
		
		DBControl dbcon=new DBControl();
		boolean sucess=dbcon.createNewUser(userName, firstName, lastName, email, pass, role);
		
		if(sucess){
			System.out.println("created a new user");
		}else{
			System.out.println("failed create new user");
		}
	}
}
