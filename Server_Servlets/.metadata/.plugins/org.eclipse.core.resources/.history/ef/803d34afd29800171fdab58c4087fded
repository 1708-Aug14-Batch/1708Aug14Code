package com.reimburse.servlets;

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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.Worker;
import com.reimburse.service.Service;

@WebServlet("/getReimbursements")
public class GetReimbursementsServlet extends HttpServlet {

	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = -3282075575789709210L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doPost of GetReimbursementsServlet");

		ArrayList<String> tx = readValuesFromRequest(req);

		Service service = new Service();
		
		// Format is: [ id, type ]
		int id;
		if (tx.get(0).equals("undefined"))
			id = -1;
		else id = Integer.parseInt(tx.get(0));	// id will be -1 to specify no worker
		String type = tx.get(1);	// possible values are: "", "PENDING", "RESOLVED"
		
		Worker user = service.getWorker(id);

		ArrayList<Reimbursement> reimbursements;	// result to be returned
		if (id == -1) {
			// No user is specified
			if (type.equals("PENDING"))
				reimbursements = service.getPendingReimbursements();
			else if (type.equals("RESOLVED"))
				reimbursements = service.getResolvedReimbursements();
			else reimbursements = service.getAllReimbursements();
		} else if (user != null) {
			// Get reimbursements for a particular worker
			if (type.equals("PENDING"))
				reimbursements = service.getPendingReimbursements(id);
			else if (type.equals("RESOLVED"))
				reimbursements = service.getResolvedReimbursements(id);
			else reimbursements = service.getWorkersReimbursements(id);
		} else reimbursements = new ArrayList<Reimbursement>();	// Empty
		
		System.out.println("Returning reimbursements: " + reimbursements);
		writeValueToResponse(resp, reimbursements);

	}
	
	private ArrayList<String> readValuesFromRequest(HttpServletRequest req) throws JsonParseException, JsonMappingException, IOException {
		// Grab all params, even though in this case it is 1 JSON String
		// name values
		Map<String, String[]> myMap = req.getParameterMap();

		// Get the keyset from the map
		Set<String> dtoObject = myMap.keySet();

		// use Jackson. API for converting JSON to java
		ObjectMapper jackson = new ObjectMapper();

		// Convert our keyset into an array, then get what we need
		Object obj = dtoObject.toArray()[0];
		return jackson.readValue((String) obj, ArrayList.class);
	}
	
	private void writeValueToResponse(HttpServletResponse resp, ArrayList<Reimbursement> reimbursements) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);	// reimbursements may be null
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
}
