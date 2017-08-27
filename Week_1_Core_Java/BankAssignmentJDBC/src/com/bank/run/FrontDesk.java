package com.bank.run;

import com.bank.dao.DAOImpl;
import com.bank.pojos.User;
import com.bank.service.Service;


public class FrontDesk {

	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
		
		Service service = new Service();
		
		service.login();

		
		

	}

}
