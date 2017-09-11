package com.reimburse.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.service.Service;

@WebServlet("/resolveReimbursement")
public class ResolveServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession session = req.getSession();
		Service bankService = new Service();
		
		try{
			Integer rid = Integer.valueOf(req.getParameter("reimbursementid"));
			int sId = Integer.valueOf(req.getParameter("statusid"));
		}catch(NumberFormatException e){
			return;
		}
		//get reimbursement
		Reimbursement r = bankService.getReimbursement(Integer.valueOf(req.getParameter("reimbursementid")));
		
		//update info
		r.setManagerNotes(req.getParameter("reason"));
		r.setResolveId((int)session.getAttribute("userid"));
		
		int status = Integer.valueOf(req.getParameter("statusid"));
		
		if(status == 1){
			r.setStatusId(1);
		}
		else{
			r.setStatusId(2);
		}
		
		//send
		bankService.resolveReimbursement(r);

	}
}
