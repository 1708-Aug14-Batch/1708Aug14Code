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

@WebServlet("/submitReim")
public class SubmitReimRequestServlet extends HttpServlet{

	final static Logger log = Logger.getLogger(SubmitReimRequestServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> myMap = req.getParameterMap();
		
		Set<String> transObject = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		
		Object obj = transObject.toArray()[0];
		ArrayList<String> to = jackson.readValue((String) obj, ArrayList.class);
	
		log.debug("Reimbursement Request Info\t" + to);
		
		Service s= new Service();

		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");
		
		log.debug("Current User\t" + sessionUser);

		if(sessionUser!=null) {
			String description = to.get(0);
			double amount = Double.parseDouble(to.get(1));
			
			ObjectMapper mapper = new ObjectMapper();
			
			if(s.createReimbursement(sessionUser, description, amount)) {
				String json = mapper.writeValueAsString("Reimbursement Submitted");
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				out.write(json);
				log.debug("Reponse\t" + json);
			}	
		}
	}
}
