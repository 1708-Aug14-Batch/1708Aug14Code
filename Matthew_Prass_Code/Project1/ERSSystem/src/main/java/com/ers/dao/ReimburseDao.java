package com.ers.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;

public interface ReimburseDao {
	
	public Reimbursement createReimbursement(Employee submit,Date submitdate,String desc,double amt);
	public ArrayList<Reimbursement> getAllReimbursements();
	public ArrayList<Reimbursement> getAllReimbursementsFromEmployee(int empid);
	public ArrayList<Reimbursement> getAllResolved();
	public ArrayList<Reimbursement> getAllResolvedByEmployee(int empid);
	public void updateReimbursement(Reimbursement r);
	public void deleteReimbursement(Reimbursement r);
}
