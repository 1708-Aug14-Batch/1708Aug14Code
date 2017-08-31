package com.reimburse.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.dao.DaoImpl;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.Worker;
import com.reimburse.service.Service;

/**
 * Servlet implementation class TesterServlet
 */
public class TesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoImpl dao = new DaoImpl();

		Service serve = new Service();
		
		Worker work = serve.getWorker(1);
		Worker manager = serve.getWorker(2);
		Reimbursement reimburse = null;

		ArrayList<Reimbursement> reimburseList = serve.getReimbursements();
		reimburse = reimburseList.get(0);
		
		// This will fail
		serve.resolveReimbursement(1, 1, null, LocalDateTime.now(), "");
		
		System.out.println(work);
		System.out.println(manager);
		System.out.println(reimburse);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
