package com.Servlets.SerHan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Reburse.Service.Service;
import com.Reburse.dto.DTOStats;
import com.Reburse.pojos.Reimbursement;
import com.Reburse.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getManDashInfo")
public class getDashManInfoServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in Dash Man info servlet");
		
		Service ser = new Service();
		
		HttpSession ses = request.getSession();
		
		User sessionUser = (User)ses.getAttribute("User");
		
		if(sessionUser != null) {
			ArrayList<Reimbursement> rems = ser.getAllReim();
			int tempP = 0;
			int tempA = 0;
			int tempD = 0;
			for(int i = 0; i < rems.size(); i++) {
				switch(rems.get(i).getStatus()) {
				case "<b style='color: blue'>Pending<b>":
					tempP++;
					break;
				case "<b style='color: green'>Approved<b>":
					tempA++;
					break;
				case "<b style='color: red'>Denied<b>":
					tempD++;
					break;
				}
			}
			DTOStats dto = new DTOStats(tempP, tempA, tempD);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		}
		else {
			response.setStatus(418);
		}
	}
	
}
