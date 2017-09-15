package com.reimbursments.servlets;

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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Users;
import com.reimbursments.service.Service;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/AddRei")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN POST");
		HttpSession session = request.getSession();
		Map<String,String[]> myMap = request.getParameterMap();
		Set<String> keys = myMap.keySet();
		Users sessionUser = (Users) session.getAttribute("user");
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];
		
		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		String email = list.get(0);
		String password = list.get(1);
		if(sessionUser.getEmail() == email && sessionUser.getPassword() == password) {
		String reason = list.get(2);
		Integer amount = Integer.parseInt(list.get(3));
		Users u = new Users(email,password);
		Reimburs r = new Reimburs(reason,amount);
		Service service = new Service();
		service.submitReimbursement(u, r);
		System.out.println("Submittal Success?");
		}
		else {
			PrintWriter pw = response.getWriter();
			
			response.sendRedirect("AddRei.html");
		}
		//doGet(request, response);
	}

}
