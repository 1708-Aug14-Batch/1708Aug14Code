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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

@WebServlet("/employeeInfo")
public class EmployeeInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Service s = new Service();

		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");

		if (sessionUser != null) {

			if (sessionUser.getIsManager() == 1) {
				HashSet<User> emps = null;
				ObjectMapper mapper = new ObjectMapper();
				emps = s.getEmployees();
				String json = mapper.writeValueAsString(emps);

				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");

				out.write(json);
			}
		}
	}
	
}
