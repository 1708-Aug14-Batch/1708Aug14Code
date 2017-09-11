package com.revature.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.revature.model.Reimbursement;

public interface IReimbursementDAO {
	
	/**
	 * CREATE
	 */
	void create(Reimbursement reimbursement);
	
	/**
	 * READ
	 */
	Reimbursement read(int submitterID, Date dateSubmitted);
	
	/**
	 * READ ALL
	 */
	ArrayList<Reimbursement> readAll();
	
	/**
	 * UPDATE
	 */
	void update(Reimbursement reimbursement);

}
