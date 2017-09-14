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
import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

@WebServlet("/reimInfo")
public class ReimInfoServlet extends HttpServlet {

	final static Logger logger = Logger.getLogger(ReimInfoServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service s = new Service();

		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");

		logger.debug(sessionUser);

		if (sessionUser != null) {
			HashSet<Reimbursement> reims = null;
			ObjectMapper mapper = new ObjectMapper();

			if (sessionUser.getIsManager() == 0) {

				reims = s.getUserReimbursement(sessionUser.getUserID());

				String json = mapper.writeValueAsString(reims);

				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");

				out.write(json);
			} else if (sessionUser.getIsManager() == 1) {
				reims = s.getReimbursements();
				logger.debug(reims);
				String json = mapper.writeValueAsString(reims);

				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");

				out.write(json);
			}
		}
		/*
		 * else { resp.setStatus(418); }
		 */
	}
}
