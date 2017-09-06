package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;
import com.reimbursement.pojos.Reimbursement;

public class EmployeeServlet  extends HttpServlet {

	private Service runApp = new Service();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User tmp = (User)session.getAttribute("user");
		if (tmp == null) {
			response.sendRedirect("login.html");
		}
		else {
			StringBuilder sb = new StringBuilder("");
			HashMap<Integer, Reimbursement> requests = runApp.getRequestsByEmployee(tmp);

			for (HashMap.Entry<Integer, Reimbursement> entry : requests.entrySet()) {
			    Integer id = entry.getKey();
			    Reimbursement rq = entry.getValue();
			    sb.append("<tr>\n");
			    sb.append("\t<th>"+rq.getStatusName()+"</th>\n");
			    sb.append("\t<th>$"+rq.getAmount()+"</th>\n");
			    sb.append("\t<th>"+rq.getSubmit_date()+"</th>\n");
			    if (rq.getResolve_date() == null) {
				    sb.append("\t<th>-</th>\n");
				    sb.append("\t<th>-</th>\n");
			    }
			    else {
				    sb.append("\t<th>"+rq.getResolve_date()+"</th>\n");
				    sb.append("\t<th>"+rq.getResolver().getFirstname()+" "+rq.getResolver().getLastname()+"</th>\n");
			    }
			    sb.append("</tr>\n");
			}
			PrintWriter out = response.getWriter();
			out.write(sb.toString());
			out.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
