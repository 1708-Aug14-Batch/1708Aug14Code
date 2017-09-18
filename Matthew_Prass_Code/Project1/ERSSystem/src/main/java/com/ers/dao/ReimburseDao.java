package com.ers.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;

public interface ReimburseDao {
	
	public Reimbursement createReimbursement(Employee submit,Timestamp submitdate,String desc,double amt,String file);
	public ArrayList<Reimbursement> getAllReimbursements();
	public ArrayList<Reimbursement> getAllReimbursementsFromEmployee(int empid);
	public ArrayList<Reimbursement> getAllResolved();
	public ArrayList<Reimbursement> getAllResolvedByEmployee(int empid);
	public void updateReimbursement(Reimbursement r);
	public void deleteReimbursement(Reimbursement r);
}
