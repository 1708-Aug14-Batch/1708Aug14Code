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

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursments.DAO.DAOImpl;
import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Users;
import com.reimbursments.service.Service;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/AddRei")
public class ReimSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ReimSubmitServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReimSubmitServlet() {
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
		log.debug("In the Submitting Reim Post");
		HttpSession session = request.getSession();
		Map<String,String[]> myMap = request.getParameterMap();
		Set<String> keys = myMap.keySet();
		Users sessionUser = (Users) session.getAttribute("user");
		log.debug("user= "+sessionUser);
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];

		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		String email = list.get(0);
		String password = list.get(1);
		log.debug("email= "+email+", password= "+password);


		if (email != null && password != null &&
				email.equals(sessionUser.getEmail()) && password.equals(sessionUser.getPassword())) {

			String reason = list.get(2);
			Double amount = Double.parseDouble(list.get(3));
			Users u = new Users(email,password);
			Reimburs r = new Reimburs(reason,amount);
			Service service = new Service();
			log.debug("before submit");
			service.submitReimbursement(u, r);
			log.debug("Submittal Success?");
			
			request.getRequestDispatcher("AddRei.html").forward(request, response);
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.write("Failed to submit request");
		}
		//doGet(request, response);
	}

}
