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

@WebServlet("/updateReim")
public class UpdateReim extends HttpServlet{

	final static Logger log = Logger.getLogger(UpdateReim.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

		Map<String, String[]> myMap = req.getParameterMap();
		
		Set<String> transObject = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		
		Object obj = transObject.toArray()[0];
		ArrayList<String> to = jackson.readValue((String) obj, ArrayList.class);
	
		log.debug("Reimbursement Update Info\t" + to);
		
		Service s= new Service();
		
		int reimID = Integer.parseInt(to.get(0));
		String status = to.get(1);
		String notes = to.get(2);
		
		String json = null;
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("User");
		
		log.debug("Current User\t" + u);

		ObjectMapper mapper = new ObjectMapper();
		if(s.updateReimbursements(reimID, u, status, notes)) {
			json = mapper.writeValueAsString((u.getFName() +" "+ u.getLName()));
		}
		else {
			json = mapper.writeValueAsString("Failure");
		}
				
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		log.debug("Response\t" + json);
	}

}
