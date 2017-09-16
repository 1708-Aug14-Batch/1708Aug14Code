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

	final static Logger log = Logger.getLogger(ReimInfoServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

		Service s = new Service();

		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");

		log.debug("Current User\t" + sessionUser);

		if (sessionUser != null) {
			HashSet<Reimbursement> reims = null;
			ObjectMapper mapper = new ObjectMapper();

			String json = null;
			
			if (sessionUser.getIsManager() == 0) {

				reims = s.getUserReimbursement(sessionUser.getUserID());
				
				json = mapper.writeValueAsString(reims);

				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");

				out.write(json);
			} else if (sessionUser.getIsManager() == 1) {
				reims = s.getReimbursements();
				
				json = mapper.writeValueAsString(reims);

				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");

				out.write(json);
			}
			
			log.debug("Reimbursements");
			for(Reimbursement r: reims) {
				log.debug(r);
			}
			log.debug("Response\t" + json);
		}
	}
}
