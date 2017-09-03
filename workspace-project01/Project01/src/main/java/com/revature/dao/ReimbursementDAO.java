/**
 * 
 */
package com.revature.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.revature.model.Reimbursement;

/**
 * @author will
 *
 */
public class ReimbursementDAO implements IReimbursementDAO {

	/* (non-Javadoc)
	 * @see com.revature.dao.IReimbursementDAO#create(com.revature.model.Reimbursement)
	 */
	@Override
	public void create(Reimbursement reimbursement) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.revature.dao.IReimbursementDAO#read(int, java.time.LocalDateTime)
	 */
	@Override
	public Reimbursement read(int submitterID, LocalDateTime dateSubmitted) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.IReimbursementDAO#readAll()
	 */
	@Override
	public ArrayList<Reimbursement> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.IReimbursementDAO#update(com.revature.model.Reimbursement)
	 */
	@Override
	public void update(Reimbursement reimbursement) {
		// TODO Auto-generated method stub

	}

}
