package com.revature.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.revature.model.Reimbursement;

public interface IReimbursementDAO {
	
	/**
	 * CREATE
	 */
	int create(Reimbursement reimbursement);
	
	/**
	 * READ
	 */
	Reimbursement read(int rID);
	
	/**
	 * READ ALL
	 */
	ArrayList<Reimbursement> readAll();
	
	/**
	 * UPDATE
	 */
	void update(Reimbursement reimbursement);

}
