package com.reimburse.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.dto.ManagerDTO;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;
import com.reimburse.service.Service;

@WebServlet("/managerhomepage")
public class ManagerHomePageServlet extends HttpServlet{
	final static Logger logger = Logger.getLogger(ManagerHomePageServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Service bankService = new Service();
		PrintWriter writer = res.getWriter();

		User manager = bankService.getUser((int)session.getAttribute("userid"));
		ArrayList<User> employees = bankService.getAllEmployees();
		ArrayList<Reimbursement> pending = bankService.getAllPending();
		ArrayList<Reimbursement> resolved = bankService.getAllResolved();
		for(Reimbursement r : resolved){
			User m = bankService.getUser(r.getResolveId());
			User u = bankService.getUser(r.getSubmitId());
			r.setResolveName(m.getFirstname() + " " + m.getLastname());
			r.setSubmitName(u.getFirstname() + " " + u.getLastname());
		}

		for(Reimbursement r : pending){
			User u = bankService.getUser(r.getSubmitId());
			r.setSubmitName(u.getFirstname() + " " + u.getLastname());
		}
		
		ManagerDTO mDTO = new ManagerDTO(manager,employees,pending,resolved);

		//get json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(mDTO);

		//send json
		System.out.println(json);
		res.setContentType("application/json");
		writer.println(json); 

		logger.info("GET MANAGER: "+json);
	}
}
