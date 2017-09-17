package com.reimb.servlet;

import java.io.IOException;
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
import com.reimb.main.DBControl;
import com.reimb.pojo.Users;

@WebServlet("/resolve")
public class ResolveServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//String userID=req.getParameter("userID");
		//String description=req.getParameter("description");
		//String amount=req.getParameter("amount");
		
		//Grab all paramenters, in this case only 1 JSON String
		Map<String, String[]> myMap = req.getParameterMap();

		//Get the the keySet from the map, returns a Set
		Set<String> txObject = myMap.keySet();

		//API for converting our JSON into a Java Object
		ObjectMapper jackson = new ObjectMapper();

		//Convert the the keySet into an array, then get the first element (index 0) from that set
		Object obj = txObject.toArray()[0];
		
		ArrayList<String> tx =  jackson.readValue(((String)obj), ArrayList.class);
		System.out.println(tx);
		
		DBControl dbcon=new DBControl();
		boolean success=false;
		
		HttpSession session = req.getSession();
		Users sessionUser=(Users)session.getAttribute("user");
		int userID=sessionUser.getID();
		String statID=tx.get(tx.size()-1);
		String note=tx.get(tx.size()-2);

		for(int i=0; i<tx.size()-2; i++){
			success=dbcon.ResolveReimb(tx.get(i), userID, note, statID);
			if(success){
				System.out.println("sumbitted a new Reimbersument Request");
			}else{
				System.out.println("failed to simbit new Request");
			}
		}
	}
}