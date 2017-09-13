package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dao.DBDAO;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public class Service {
	private DBDAO dao;
	private User curUser;
	
	public Service() {
		dao = new DBDAO();
	}
	
	public boolean attemptLogin(String email, String password) {
		return (curUser = dao.attemptLogin(email, password)) != null;
	}
	
	public boolean addUser(String first, String last, String email, String pass, boolean isManager) {
		return dao.addUser(new User(first, last, email, pass, isManager));
	}
	
	public User getCurUser() {
		return curUser;
	}
	
	
	public static Service getFromSession(HttpSession ses) {
		Service serv = (Service) ses.getAttribute("service");
		if (serv == null) {
			Service newServ = new Service();
			ses.setAttribute("service", newServ);
			return newServ;
		}
		return serv;
	}
	
	public Reimbursement[] getUsersReimbursements(User u) {
		List<Reimbursement> reimbs = dao.getUsersReimbursements(u);
		return reimbs.toArray(new Reimbursement[reimbs.size()]);
	}
	
	public Reimbursement[] getAllReimbursements() {
		List<Reimbursement> reimbs = dao.getAllReimbursements();
		return reimbs.toArray(new Reimbursement[reimbs.size()]);
	}
}
