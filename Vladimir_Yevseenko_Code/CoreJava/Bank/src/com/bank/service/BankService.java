package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DBDAO;
import com.bank.pojos.User;

public class BankService {
	private DAO dao;
	private User curUser;
	
	public BankService() {
		dao = new DBDAO();
	}
	
	public void createNewUser(String fn, String ln, String e, String pw) {
		dao.createNewUser(new User(fn, ln, e, pw));
	}
}
