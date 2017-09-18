package com.reimbursement.servlets;

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
import com.fasterxml.jackson.databind.ObjectWriter;
import com.reimbursement.dto.DTO;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;;

@WebServlet("/resolveRequest")
public class ResolveRequestServlet extends HttpServlet {

	private Service runApp = new Service();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> myMap = request.getParameterMap();
		Set<String> txObject = myMap.keySet();
		ObjectMapper jackson = new ObjectMapper();
		Object obj = txObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
		
		HttpSession session = request.getSession(false);
		User u = (User)session.getAttribute("user");
		int id = Integer.parseInt(tx.get(0));
		int status = Integer.parseInt(tx.get(1));
		String notes = tx.get(2);
		System.out.println(id+" "+status+" "+notes);
		runApp.resolveRequest(id, status, notes, u.getId());
		Reimbursement reimb = runApp.getReimbursementById(id);
		ArrayList<Reimbursement> requests = new ArrayList<Reimbursement>();
		requests.add(reimb);
		DTO dto = new DTO(u, requests, null);

		//System.out.println(reimb.getResolve_notes());
		
		ObjectWriter objWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = objWriter.writeValueAsString(dto);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.close();
	}
}
