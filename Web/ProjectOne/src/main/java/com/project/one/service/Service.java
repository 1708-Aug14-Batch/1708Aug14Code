package com.project.one.service;

import java.sql.Date;
import java.util.ArrayList;

import com.project.one.dao.DaoImpl;
import com.project.one.pojos.Employee;
import com.project.one.pojos.Reimbursement;
import com.project.one.pojos.Status;

public class Service {
	private static DaoImpl dao;
	
	/**
	 * This will retrieve the information for any Employee in the system, it will not validate them
	 * to validate, use validate
	 * @param email
	 * @return Employee
	 */
	public static Employee login(String email) {
		dao = new DaoImpl();
		Employee empl = null;
		String info = dao.getEmployee(email);
		if(info ==null) {
			return empl;
			}
		else{
			String[] inf = info.split(":");
			int id = Integer.parseInt(inf[0]);//EMPLOYEEID number Primary Key,
			String fn = inf[1];//FIRSTNAME VARCHAR2(30),
			String ln = inf[2];//LASTNAME VARCHAR2(30),
			String pass = inf[3];//PASSWORD VARCHAR2(30) NOT NULL,
			int mngr = Integer.parseInt(inf[4]);//ISMANAGER NUMBER NOT NULL
			empl = new Employee(id,fn,ln,email,pass,mngr);
			return empl;
			}
		}

	/**
	 * This validates an employee's credentials
	 * @param empl
	 * @param pwd
	 * @return true if the password is correct, false if incorrect
	 */
	public static boolean validate(Employee empl, String pwd) {
		return (empl.getPwd()==pwd);
	}

	public void addEmployee(String fn, String ln, String email, String pwd, int mngr) {
		dao = new DaoImpl();
		dao.addEmployee(fn, ln, email, pwd, mngr);
	}
	
	/**
	 * This will add a new Reimbursement request to the database
	 * @return newly added Reimbursement request
	 */
	public Reimbursement submitRequest(Employee empl, double amount, String desc) {
		dao = new DaoImpl();
		int emplid = empl.getId();
		int id = dao.addReimbursement(emplid, amount, desc);
		Reimbursement newReq = new Reimbursement(id, empl, amount, desc);
		return newReq;
	}
	
	/**
	 * Returns all requests made by the given employee
	 * @param Employee e
	 * @return
	 */
	public ArrayList<Reimbursement> getRequests(Employee e){
		ArrayList<Reimbursement> reqs;
		dao = new DaoImpl();
		int emplid = e.getId();
		reqs = dao.getRequests();
		for(int i =0; i<reqs.size();i++) {
			Reimbursement r = reqs.get(i);
			if(r.getEmpl().getId() != e.getId()) {
				reqs.remove(i);
			}
		}
		return reqs;
	}
	
	public ArrayList<Reimbursement> getRequests(){
		ArrayList<Reimbursement> reqs;
		dao = new DaoImpl();
		reqs = dao.getRequests();
		return reqs;
	}

	public ArrayList<Employee> getEmployees(){
		dao = new DaoImpl();
		ArrayList<Employee> empls;
		empls = dao.getEmployees();
		return empls;
	}
	
	public Employee updateEmployee(int id, String fn, String ln, String email, String pwd, int mngr) {
		Employee e = new Employee( id, fn, ln, email, pwd, mngr);
		dao = new DaoImpl();
		dao.updateEmpl(id, fn, ln, email, pwd);
		return e;
	}
	
	public void approveRequest(int id, String reason,  Employee m) {
		dao = new DaoImpl();
		int stat = 1;
		int mngr = m.getId();
		dao.updateReimbursement(id, stat, mngr, reason);
	}
	public void denyRequest(int id, String reason,  Employee m) {
		dao = new DaoImpl();
		int stat = 2;
		int mngr = m.getId();
		dao.updateReimbursement(id, stat, mngr, reason);
	}
}

