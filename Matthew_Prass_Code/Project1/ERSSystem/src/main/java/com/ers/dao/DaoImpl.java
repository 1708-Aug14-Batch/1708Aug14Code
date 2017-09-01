package com.ers.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.pojos.ReimbursementStatus;

public class DaoImpl implements EmployeeDao,ReimburseDao,ReimbursementStatusDao {

	@Override
	public ArrayList<ReimbursementStatus> getAllStatuses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement createReimbursement(Employee submit, Date submitdate, String desc, double amt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursementsFromEmployee(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllResolvedByEmployee(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addEmployee(String fn, String ln, String email, String pass, String usrnm, int manage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployeeInfo(Employee e) {
		// TODO Auto-generated method stub
		
	}

}
