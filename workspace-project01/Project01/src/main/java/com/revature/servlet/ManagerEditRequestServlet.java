package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.EditRequestDTO;
import com.revature.dto.UserEditDTO;
import com.revature.model.RUser;
import com.revature.service.ReimbursementService;

@WebServlet("/manager-edit-request")
public class ManagerEditRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5259162121672073852L;
	private ReimbursementService service = new ReimbursementService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Enumeration<String> requestParams = request.getParameterNames();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = requestParams.nextElement();
		EditRequestDTO reqData = (EditRequestDTO) mapper.readValue(jsonString, EditRequestDTO.class);
		this.service.updateReimb(reqData);
		request.getRequestDispatcher("partial/manager/view-all-requests.html").forward(request, response);
	}

}
