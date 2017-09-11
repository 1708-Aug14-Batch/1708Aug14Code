package com.ers.test;

import java.util.ArrayList;

import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.pojos.ReimbursementStatus;
import com.ers.service.Service;

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
		ArrayList<Reimbursement> list = dao.getAllReimbursements();
		for(Reimbursement r: list)
		{
			System.out.println(r);
		}
		
		ArrayList<Employee> list2 = s.getAllEmployees();
		for(Employee r: list2)
		{
			System.out.println(r);
		}
	}

}
