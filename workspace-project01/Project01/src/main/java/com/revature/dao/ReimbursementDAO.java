/**
 * 
 */
package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionSingleton;

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
		if (reimbursement == null) {
			throw new IllegalArgumentException("Reimbursement cannot be null");
		}
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO r_user(r_id, submitter_id, resolver_id, status_id, date_submitted, date_resolver, description, resolution_notes, amount) VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";
			String[] key = {"r_id"};
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, reimbursement.getSubmitterID());
			statement.setInt(2, reimbursement.getResolverID());
			statement.setInt(3, reimbursement.getStatusID());
			statement.setDate(4, reimbursement.getDateSubmitted());
			statement.setDate(5, reimbursement.getDateResolved());
			statement.setString(6, reimbursement.getDescription());
			statement.setString(7, reimbursement.getResolutionNotes());
			statement.setDouble(8, reimbursement.getAmount());
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
