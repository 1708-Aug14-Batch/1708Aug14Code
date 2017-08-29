package com.ex.service;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;

import oracle.net.aso.u;
//import com.ex.pojos.User;

public class Service {
	
	private static DAO dao;
	
	/* 
	 * Creates a Service object that will be called in BankRun
	 * The service object creates a new DAOImpl object
	 * The DAOImpl object will communicate the following changes
	 * - adding user/account - updating user/account(s)
	 * to the Bank DataBase (DB)  
	 */
	
	public Service() {
		this.setDao(new DAOImpl());
	}
	
	public void editUserFName(String email, String choice) {
		dao.updateUserFName(email, choice);
	}
	
	public void editUserLName(String email, String choice) {
		dao.updateUserLName(email, choice);
	}
	
	//public void editUserEmail(String email, String choice) {
	//	dao.updateUserEmail(email, choice);
	//}
	
	public void editUserPass(String email, String choice) {
		dao.updateUserPass(email, choice);
	}
	
	public void editBalance(double b, String email, String type) {
		dao.updateUserAccount(b, email, type);
	}
	
	public void transferFunds(double change, String rEmail, String aEmail) {
		dao.updateUserAccounts(change, rEmail, aEmail);
	}
	
	public void closeAccount(String cEmail) {
		dao.closeUserAccount(cEmail);
	}
	
	public DAO getDao() {
		return dao;
	}

	public static void setDao(DAO dao) {
		Service.dao = dao;
	}

}
