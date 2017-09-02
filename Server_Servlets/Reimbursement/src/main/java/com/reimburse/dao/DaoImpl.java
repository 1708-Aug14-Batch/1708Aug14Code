package com.reimburse.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.reimburse.pojos.*;
import com.reimburse.pojos.Reimbursement.reimbursementStatus;
import com.reimburse.util.ConnectionFactory;

// NOTE: SQL is 1-indexed rather than 0-indexed
// FIXME remove redundant code

public class DaoImpl implements Dao {

	// LocalDateTime.parse(day) reference: 2017-08-30T13:31:18.553
	// Database reference: TO_TIMESTAMP(:ts_val, 'YYYY-MM-DD_HH24:MI:SS')
	public String getFormattedTimestamp(LocalDateTime day) {
		// Replace the 'T' with a space, and cut off the milliseconds
		
		if (day == null)
			return null;
		
		String time = day.toString();
		
		// Cut off the three millisecond digits and the decimal place
		time = time.substring(0, (time.length()-1)-3);
		
		// Replace the 'T' with ' '
		int tIndex = time.indexOf('T');
		char[] timeArray = time.toCharArray();
		timeArray[tIndex] = ' ';
		
		return String.copyValueOf(timeArray);
	}
	public LocalDateTime fromFormattedTimestamp(String str) {
		if (str == null || str.equals("null"))
			return null;

		// Put the 'T' back in index 10 where it belongs
		char[] timeArray = str.toCharArray();
		timeArray[10] = 'T';
		
		return LocalDateTime.parse(String.copyValueOf(timeArray));
	}

	public Worker createWorker(String firstName, String lastName, String email,
			String username, String password, boolean isManager, boolean isHired) {
		Worker work = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);

			// No semi-colon inside the quotes
			String sql = "INSERT INTO worker(first_name, last_name, email, username, password, is_manager, is_hired)" + 
					" VALUES(?, ?, ?, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "worker_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setInt(6, isManager?1:0);
			ps.setInt(7, isHired?1:0);

			// executeUpdate() returns the number of rows updated
			ps.executeUpdate();

			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next())
				id = pk.getInt(1);

			conn.commit();
			work = new Worker(id, firstName, lastName, email, username, password, isManager, isHired);

		} catch (SQLException e) {
			System.out.println("Database error");
		}

		return work;

	}

	@Override
	public Worker readWorker(int workerId) {
		Worker work = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM worker WHERE worker_id=?";
			String[] key = new String[1];
			key[0] = "worker_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, workerId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				workerId = rs.getInt(1);		// This line is redundant
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				boolean isManager = (rs.getInt(7) == 0)?false:true;
				boolean isHired = (rs.getInt(8) == 0)?false:true;

				work = new Worker(workerId, firstName, lastName, email, username, password, isManager, isHired);
				
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}

		return work;
	}

	public Worker readWorker(String username) {
		Worker work = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM worker WHERE username=?";
			String[] key = new String[1];
			key[0] = "worker_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				int workerId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				username = rs.getString(5);		// This line is redundant
				String password = rs.getString(6);
				boolean isManager = (rs.getInt(7) == 0)?false:true;
				boolean isHired = (rs.getInt(8) == 0)?false:true;

				work = new Worker(workerId, firstName, lastName, email, username, password, isManager, isHired);
				
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}

		return work;
	}

	@Override
	public boolean updateWorker(int workerId, Worker work) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);

			// No semi-colon inside the quotes
			String sql = "UPDATE worker SET" + 
					" first_name=?, last_name=?, email=?, birth_date=TO_DATE(?,'yyyy-mm-dd'), deceased=?" + 
					" WHERE worker_id=?";
			String[] key = new String[1];
			key[0] = "worker_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, work.getFirstName());
			ps.setString(2, work.getLastName());
			ps.setString(3, work.getEmail());
			ps.setString(4, getFormattedDate(work.getBirthDate()));
			ps.setInt(5, work.isDeceased()?1:0);
			ps.setInt(6, workerId);

			// executeUpdate() returns the number of rows updated
			ps.executeUpdate();

			conn.commit();
			return true;

		} catch (SQLException e) {
			System.out.println("Database error");
		}

		return false;

	}

	@Override
	public boolean deleteWorker(int workerId) {

		Worker work = readWorker(workerId);
		if (work == null)
			return false;

		work.setHired(false);
		return updateWorker(workerId, work);

	}

	@Override
	public ArrayList<Worker> readAllWorkers() {
		ArrayList<Worker> list = new ArrayList<Worker>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * from worker";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				int workerId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				boolean isManager = (rs.getInt(7) == 0)?false:true;
				boolean isHired = (rs.getInt(8) == 0)?false:true;

				Worker work = new Worker(workerId, firstName, lastName, email, username, password, isManager, isHired);

				list.add(work);
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}

		return list;
	}

	@Override
	public Reimbursement createReimbursement(int submitterId, reimbursementStatus status,
			LocalDateTime submitDate, String description, int ammount) {
		Reimbursement reimburse = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);

			String sql = "INSERT INTO reimbursement(submitter_id_fk, status_id_fk, submit_date, description, ammount)" + 
					" VALUES(?, ?, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?)";
			String[] key = new String[1];
			key[0] = "reimbursement_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, submitterId);
			ps.setInt(2, status.ordinal());
			ps.setString(3, getFormattedTimestamp(submitDate));
			ps.setString(4, description);
			ps.setInt(5, ammount);
			
			// executeUpdate() returns the number of rows updated
			ps.executeUpdate();

			Integer id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next())
				id = pk.getInt(1);

			conn.commit();
			reimburse = new Reimbursement(id, submitterId, status, submitDate, description, ammount);

		} catch (SQLException e) {
			System.out.println("Database error");
		}

		// Something went wrong
		return reimburse;

	}

	@Override
	public Reimbursement readReimbursement(int reimbursementId) {
		Reimbursement reimburse = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM reimbursement WHERE reimbursement_id=?";
			String[] key = new String[1];
			key[0] = "reimbursement_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, reimbursementId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				reimbursementId = rs.getInt(1);		// This line is redundant
				int submitterId = rs.getInt(2);
				int resolverId = rs.getInt(3);
				reimbursementStatus status =  reimbursementStatus.values()[rs.getInt(4)];
				LocalDateTime submitDate = fromFormattedTimestamp(rs.getString(5));
				LocalDateTime resolvedDate = fromFormattedTimestamp(rs.getString(6));
				String description = rs.getString(7);
				String resolveNotes = rs.getString(8);
				int ammount = rs.getInt(9);
				
				reimburse = new Reimbursement(reimbursementId, submitterId, status, submitDate, description, ammount);
				reimburse.setResolverId(resolverId);
				reimburse.setResolvedDate(resolvedDate);
				reimburse.setResolveNotes(resolveNotes);
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}

		return reimburse;
	}

	@Override
	public boolean updateReimbursement(int reimbursementId, Reimbursement reimburse) {

		// A null date cannot be formatted into the sql string below
		if (reimburse.getResolvedDate() == null)
			updateReimbursementNoDate(reimbursementId, reimburse);
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);

			// No semi-colon inside the quotes
			String sql = "UPDATE reimbursement SET" + 
					" balance=?, level_id=?, deleted=?" + 
					" WHERE reimbursement_id=?";
			String[] key = new String[1];
			key[0] = "reimbursement_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, reimburse.getBalance().toString());
			ps.setInt(2, reimburse.getLevel().ordinal());
			ps.setInt(3, reimburse.isDeleted()?1:0);
			ps.setInt(4, reimbursementId);

			// executeUpdate() returns the number of rows updated
			ps.executeUpdate();

			conn.commit();
			return true;

		} catch (SQLException e) {
			System.out.println("Database error");
		}

		return false;

	}

	@Override
	public ArrayList<Reimbursement> readAllReimbursements() {
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * from reimbursement";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				int reimbursementId = rs.getInt(1);		// This line is redundant
				int submitterId = rs.getInt(2);
				int resolverId = rs.getInt(3);
				reimbursementStatus status =  reimbursementStatus.values()[rs.getInt(4)];
				LocalDateTime submitDate = fromFormattedTimestamp(rs.getString(5));
				LocalDateTime resolvedDate = fromFormattedTimestamp(rs.getString(6));
				String description = rs.getString(7);
				String resolveNotes = rs.getString(8);
				int ammount = rs.getInt(9);
				
				Reimbursement reimburse = new Reimbursement(reimbursementId, submitterId, status, submitDate, description, ammount);
				reimburse.setResolverId(resolverId);
				reimburse.setResolvedDate(resolvedDate);
				reimburse.setResolveNotes(resolveNotes);
				
				list.add(reimburse);
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}

		return list;
	}

}