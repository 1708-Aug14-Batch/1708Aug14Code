package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getmessage")
public class LoginMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String[]> paramMap = request.getParameterMap();
		String obj = paramMap.keySet().toArray()[0].toString();

		ObjectMapper mapper = new ObjectMapper();		
		@SuppressWarnings("unchecked")
		List<String> tx = mapper.readValue(obj, ArrayList.class);

		HttpSession session = request.getSession();

		String email    = tx.get(0);
		String password = tx.get(1);

		String errorMessage = Service.loginUser(email, password);
		
		System.out.println("Error: " + errorMessage);

		if (errorMessage == null) {
			session.setAttribute("user", Service.getCurrentUser());

			request.getRequestDispatcher("success.html").forward(request, response);
			return;
		}

		System.out.println("in PrintWriter");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(errorMessage);
	}
}
