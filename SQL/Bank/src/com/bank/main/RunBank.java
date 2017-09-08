package com.bank.main;

import com.bank.dao.DAOImpl;
import com.bank.pojos.User;

public class RunBank {
	
	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
		
		if (dao.getEmails().containsValue("email") == true){
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}
		
		String pass = "pass";
		User u = dao.getUserById(1);
		try{
			if (u.getPassword().equalsIgnoreCase(pass)){
				System.out.println("Success");
			} else {
				System.out.println("Failure");
			}
		} catch (NullPointerException e){
			System.out.println("Failure");
		}
		
		dao.createAccount(u, 1);
		
		
	}

}
