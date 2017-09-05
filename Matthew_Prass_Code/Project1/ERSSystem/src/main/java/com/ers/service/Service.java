package com.ers.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;

public class Service {
	
	//may need to change this?
	static DaoImpl dao = new DaoImpl();
	Employee e = new Employee();
	
	public int validateEmployee(String email, String username)
	{
		int id = -1;
		ArrayList<Employee> list = dao.getAllEmployees();

		for(Employee e : list){
			if(e.getEmail().equals(email) || e.getUsername().equals(username)) {
				id  = e.getId();
			}
		}

		return id;
	}
	
	public Employee login(int id, String pass)
	{
		//change?
		e= dao.getEmployee(id);
		if(e.getPassword().equalsIgnoreCase(pass)){
			return e;
		}
		else return null;
	}
	
	public void registerEmployee(String fn, String ln, String email)
	{
		int passNum = (int) Math.floor(10000000*Math.random());
		String tempPass  = ""+passNum;
		int userNum = (int) Math.floor(10000000*Math.random());
		String tempUsername = ""+userNum;
		int id = dao.addEmployee(fn, ln, email, tempPass, tempUsername,0);
		Employee emp = new Employee(fn,ln,email,tempPass, tempUsername,0);
		emp.setId(id);
		//set emp equal to e?
	}
	
	public Reimbursement submitReimbursement(Employee emp,String descript, double amt)
	{
		Reimbursement r = dao.createReimbursement(emp, Timestamp.valueOf(LocalDateTime.now()), descript, amt);
		return r;
	}
	
	public ArrayList<Reimbursement> getAllReimbursements()
	{
		return dao.getAllReimbursements();
	}
	
	public ArrayList<Reimbursement> getAllReimbursementsForEmployee(int id)
	{
		return dao.getAllReimbursementsFromEmployee(id);
	}
	
	public Employee getInfo()
	{
		return e;
	}
	
	public Employee updateInfo(Employee e,String fn, String ln, String email, String pass, String username)
	{
		//need id
		e.setFirstname(fn);
		e.setLastname(ln);
		e.setEmail(email);
		e.setPassword(pass);
		e.setUsername(username);
		dao.updateEmployeeInfo(e);
		return e;
	}
	
	public Reimbursement resolve(Reimbursement r, String notes, int status)
	{
		r.setResolver(e);
		r.setResolveddate(Timestamp.valueOf(LocalDateTime.now()));
		r.setNotes(notes);
		r.setType(dao.getStatus(status));
		dao.updateReimbursement(r);
		return r;
	}
	
	public ArrayList<Reimbursement> getAllResolved()
	{
		return dao.getAllResolved();
	}
	
	public ArrayList<Employee> getAllEmployees()
	{
		return dao.getAllEmployees();
	}
	
	
}
