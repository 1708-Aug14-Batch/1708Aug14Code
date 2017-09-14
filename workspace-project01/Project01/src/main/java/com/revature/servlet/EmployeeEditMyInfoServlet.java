package com.revature.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.UserEditDTO;
import com.revature.model.RUser;
import com.revature.service.ReimbursementService;

@WebServlet("/employee-edit-my-info")
public class EmployeeEditMyInfoServlet extends HttpServlet {

	private static final int FORBIDDEN = 403;
	ReimbursementService service = new ReimbursementService();
	private static final long serialVersionUID = 950956289513676190L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RUser loggedInUser = (RUser) request.getSession().getAttribute("user");
		if (loggedInUser != null) {
			request.getRequestDispatcher("partial/employee/edit-info.html").forward(request, response);
		} else {
			response.setStatus(FORBIDDEN);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		UserEditDTO userData = this.getUserDataFromRequest(request);
		RUser loggedInUser = (RUser) request.getSession().getAttribute("user");
		RUser user = this.prepareUserDataForDatabaseUpdate(userData, loggedInUser);
		this.attemptToUpdateUser(request, response, user);
	}

	private UserEditDTO getUserDataFromRequest(HttpServletRequest request)
			throws IOException, JsonParseException, JsonMappingException {
		Enumeration<String> requestParams = request.getParameterNames();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = requestParams.nextElement();
		UserEditDTO userData = (UserEditDTO) mapper.readValue(jsonString, UserEditDTO.class);
		return userData;
	}

	private RUser prepareUserDataForDatabaseUpdate(UserEditDTO userData, RUser loggedInUser) {
		RUser user = null;
		if (userData.getCurrentPassword().equals(loggedInUser.getPassword())) {
			user = new RUser();
			user.setRUserID(loggedInUser.getRUserID());
			user.setFirstName(userData.getFirstName());
			user.setLastName(userData.getLastName());
			user.setEmail(userData.getEmail());
			user.setPassword(userData.getNewPassword());
		}
		return user;
	}

	private void attemptToUpdateUser(HttpServletRequest request, HttpServletResponse response, RUser user)
			throws ServletException, IOException {
		boolean editSuccess = (0 != this.service.editUser(user));
		if (editSuccess) {
			request.getRequestDispatcher("partial/employee/view-info.html").forward(request, response);
		} else {
			response.sendRedirect(response.encodeRedirectURL("partial/employee/edit-failure.html"));
		}
	}

}
