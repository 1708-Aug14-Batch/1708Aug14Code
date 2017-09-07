package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.dao.DaoImpl;
import com.ers.dto.DTO;
import com.ers.pojos.Reimbursement;
import com.ers.pojos.Employee;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getEmployeeInfo")
public class GetUserInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		System.out.println("getting user info");
		Service s = new Service();
		DaoImpl dao = new DaoImpl();
		
		HttpSession sesh = req.getSession();
		Employee seshuser = (Employee)sesh.getAttribute("employee");
		
		if(seshuser != null)
		{
			ArrayList<Reimbursement> reimbs = new ArrayList<Reimbursement>();
			reimbs = s.getAllReimbursementsForEmployee(seshuser.getId());
			
			System.out.println("converting our user and account to dto");
			DTO dto = new DTO(seshuser,reimbs);
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(dto);
			
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			out.write(json);
		}
		else {
			res.setStatus(418);
		}
	}

}
