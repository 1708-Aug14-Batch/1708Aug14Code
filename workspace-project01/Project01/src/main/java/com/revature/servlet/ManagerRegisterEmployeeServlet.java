package com.revature.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.RegisterEmpDTO;
import com.revature.dto.UserEditDTO;
import com.revature.service.ReimbursementService;

@WebServlet("/manager-register-employee")
public class ManagerRegisterEmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3344165540846554620L;
	private ReimbursementService service = new ReimbursementService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("partial/manager/register-employee.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Enumeration<String> requestParams = request.getParameterNames();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = requestParams.nextElement();
		RegisterEmpDTO registrationData = (RegisterEmpDTO) mapper.readValue(jsonString, RegisterEmpDTO.class);
		this.service.registerEmployee(registrationData);
	}

}
