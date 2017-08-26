package com.bank.main;

import com.bank.dao.DAOImpl;

public class RunBank {

	
	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
		
		dao.addUser("Java", "tester", "email", "pass");
		
	}
}
