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

@WebServlet("/updateReimResData")
public class updateReimResServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in updateEmpSet servlet");
		
		Service ser = new Service();
		
		HttpSession ses = request.getSession();
		
		User sessionUser = (User)ses.getAttribute("User");
		
		if(sessionUser != null) {
			Map<String, String[]> myMap = request.getParameterMap();
			Set<String> txObject = myMap.keySet();
			ObjectMapper jackson = new ObjectMapper();
			Object obj = txObject.toArray()[0];
			ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
			PrintWriter p = response.getWriter();
			
			int ID = Integer.parseInt(tx.get(0));
			String desc = tx.get(1);
			boolean res;
			if(tx.get(2).equals("A")) {
				res = true;
			}
			else {
				res = false;
			}
			
			boolean val = ser.UpdateReimPen(ID, desc, res, sessionUser.getUserID());
			
			System.out.println(tx.get(0));
			System.out.println(tx.get(1));
			
			if(val) {
				p.write("true");
			}
			else {
				p.write("false");
			}
		}
		else {
			response.setStatus(418);
		}
	}
	
}
