package com.ers.test;

import com.ers.dao.DaoImpl;
import com.ers.service.Service;

public class TesingErs {

	public static void main(String[] args) {
		
		Service s = new Service();
		DaoImpl dao = new DaoImpl();
		//s.registerEmployee("Matt", "Prass", "mattprass@gmail.com");
		
		System.out.println(s.getAllEmployees());
		//System.out.println(s.validateEmployee("mattprass@gmail.com", "6915383"));
		//System.out.println(s.login(2, "6754755"));
		
		System.out.println(s.updateInfo(dao.getEmployee(2),"matt", "prass", "something", "somethingelse", "mprass"));
		s.submitReimbursement(dao.getEmployee(2), "test", 10000);
	}

}
