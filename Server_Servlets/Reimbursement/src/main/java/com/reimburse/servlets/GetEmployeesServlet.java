package com.reimburse.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.pojos.Worker;
import com.reimburse.service.Service;

@WebServlet("/getEmployees")
public class GetEmployeesServlet extends HttpServlet {
	
	final static Logger logger = Logger.getLogger(GetEmployeesServlet.class);
	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = -3282075575789709210L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPost");

		Service service = new Service();
				
		ArrayList<Worker> workers = service.getAllWorkers();

		logger.info("Returning employees: " + workers);
		writeValueToResponse(resp, workers);

	}
	
	private void writeValueToResponse(HttpServletResponse resp, ArrayList<Worker> workers) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(workers);	// reimbursements may be null
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
}
