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

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.ReimbursementDTO;
import com.reimburse.service.Service;

@WebServlet("/getOneReimbursement")
public class GetOneReimbursementServlet extends HttpServlet {

	final static Logger logger = Logger.getLogger(GetOneReimbursementServlet.class);
	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = -3282075575789709210L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Inside doPost of LoginMessageServlet");

		ArrayList<String> tx = readValuesFromRequest(req);

		Service service = new Service();
		
		// Format is: [ id ]
		int id = Integer.parseInt(tx.get(0));
		
		ReimbursementDTO reimburseDto = service.getReimbursement(id);
		
		logger.info("Get one reimbursement: " + reimburseDto);
		
		writeValueToResponse(resp, reimburseDto);

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
	
	private void writeValueToResponse(HttpServletResponse resp, Reimbursement reimbursement) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursement);	// reimbursements may be null
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
}
