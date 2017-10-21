package com.project.one.test;

import java.util.ArrayList;

import com.project.one.pojos.Employee;
import com.project.one.pojos.Reimbursement;
import com.project.one.service.Service;

public class Test {

	public static void main(String[] args) {
		Service server = new Service();
		//server.addEmployee("Emma", "test", "ek@testeroo.com", "password", 0);
	//	Employee tester = new Employee(1, "Emma", "test", "ek@tester.com");
//		Employee test2 = new Employee(4, "Emma", "test", "ek@testeroo.com");
		ArrayList<Employee> employees = server.getEmployees();
		for(Employee e : employees) {
			System.out.println(e.toString());
		}
//		server.submitRequest(test2, 1000, "Other Expenses");
//		ArrayList<Reimbursement> reqs = server.getRequests();
//		ArrayList<Reimbursement> myReqs = server.getRequests(tester);
//		for(Reimbursement r: reqs) {
//			System.out.println(r.toString());
//		}
//		for(Reimbursement r: myReqs) {
//			System.out.println(r.toString());
//		}
//		Employee test = server.login("not valid");
//		Employee test2 = server.login("ek@tester.com");
//		System.out.println(test);
//		System.out.println("Should not be null "+ test2);
//		System.out.println("Should be true: "+server.validate(test2, "password"));
//		System.out.println("Should be false: "+server.validate(test2, "not a pw"));
//		ArrayList<Employee> empls = server.getEmployees();
//		for(Employee e: empls) {System.out.println(e.toString());}
//		
//		Employee test3 = server.updateEmployee(1, "New Emma", "New LAst", "email", "pwd", 0);
//		System.out.println(test3);
		
//		ArrayList<Reimbursement> reqs = server.getRequests();
//		Reimbursement R = reqs.get(0);
//		Reimbursement A = reqs.get(1);
//		server.approveRequest(8, "Becase why not", test2);
//		server.denyRequest(9, "Because  I don't like you", test2);
//		
//		ArrayList<Reimbursement> reqs = server.getRequests();
//		for(Reimbursement r: reqs) {
//			System.out.println(r.toString());}
		
	}

}
