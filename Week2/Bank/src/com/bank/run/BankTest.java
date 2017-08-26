package com.bank.run;

import com.bank.dao.DAOImpl;

public class BankTest {

	public static void main(String[] args) {
		
		DAOImpl dao = new DAOImpl();
		
		dao.addUser("test", "java", "email", "password");
		// TODO Auto-generated method stub

	}

}
