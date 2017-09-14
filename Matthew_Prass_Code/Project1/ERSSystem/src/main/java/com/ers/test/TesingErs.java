package com.ers.test;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.pojos.ReimbursementStatus;
import com.ers.service.Service;

import oracle.sql.BLOB;

public class TesingErs {

	public static void main(String[] args) {
		
		Service s = new Service();
		DaoImpl dao = new DaoImpl();
		//s.registerEmployee("Matt", "Prass", "mattprass@gmail.com");
		
		//System.out.println(s.getAllEmployees());
		//System.out.println(s.validateEmployee("something", "mrprass"));
		//System.out.println(s.login(2, "somethingelse"));
		
//		System.out.println(s.updateInfo(dao.getEmployee(2),"matt", "prass", "something", "somethingelse", "mprass"));
//		s.submitReimbursement(dao.getEmployee(2), "test", 10000);
	
		System.out.println(dao.getBlob(55));
		System.out.println(dao.getBlob(56));
	}

}
