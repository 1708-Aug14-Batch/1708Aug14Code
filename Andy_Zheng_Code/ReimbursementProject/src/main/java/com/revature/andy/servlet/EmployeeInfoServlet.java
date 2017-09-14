package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

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

@WebServlet("/employeeInfo")
public class EmployeeInfoServlet extends HttpServlet{
	
	final static Logger log = Logger.getLogger(EmployeeInfoServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Service s = new Service();

		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");

		log.debug("Current User\t" + sessionUser);
		
		if (sessionUser != null) {

			if (sessionUser.getIsManager() == 1) {
				HashSet<User> emps = null;
				ObjectMapper mapper = new ObjectMapper();
				emps = s.getEmployees();
				
				log.debug("Employees");
				for(User e: emps) {
					log.debug(e);
				}
				
				
				String json = mapper.writeValueAsString(emps);
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");

				out.write(json);
				log.debug("Response\t" + json);
			}
		}
	}
	
}
