package com.pone.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import com.pone.pojos.AUser;
import com.pone.pojos.RStatus;
import com.pone.pojos.Reimbursement;
import com.pone.util.ConnectionFactory;

public class DAOImpl implements DAO{

	/**
	 * Adding a User to the table AUser
	 * @param fn
	 * 		User's first name
	 * @param ln
	 * 		User's last name
	 * @param userName
	 * 		User's user name
	 * @param email
	 * 		User's email address
	 * @param password
	 * 		User's password
	 * @return
	 * 		The unique user id that was assigned to this user in the AUser table
	 */
	public int addUser(String fn, String ln, String userName, String email, String password) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into AUser (firstname,lastname,username,email,password,ismanager) values(?,?,?,?,?,?)";
			String[] key = new String[1];
			key[0] = "u_id";
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, userName);
			ps.setString(4, email);
			ps.setString(5, password);
			int isManager = 0;
			ps.setInt(6, isManager);
			ps.executeUpdate(); // returns an int
			int id = 2;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;	
	}
	
	
	
	public AUser getAUser(int theUID) {
		Connection connect = null;;
		CallableStatement cs = null;
		String str="";
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call getAUser(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, theUID);
			cs.execute();
			str = cs.getString(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				cs.close();
				connect.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(str.equals("-1")) {
			return null;
		}
		else {
			AUser thisUser = new AUser();
			String[] myUser = str.split(",");
			thisUser.setU_id(Integer.parseInt(myUser[0]));
			thisUser.setFirstName(myUser[1]);
			thisUser.setLastName(myUser[2]);
			thisUser.setUserName(myUser[3]);
			thisUser.setEmail(myUser[4]);
			thisUser.setPassword(myUser[5]);
			thisUser.setIsManager(Integer.parseInt(myUser[6]));
			return thisUser;
		}
	}
	
	
	
	/**
	 * Add a Reimbursement Request
	 * @param submitterId
	 * 		ID of user who submitted the request
	 * @param description
	 * 		Description of what the request is for
	 * @param amount
	 * 		Amount requested (double)
	 * @return
	 * 		A reimbursement object with all the creation data in it, including its unique id.
	 */
	public Reimbursement addReimbursement(int submitterId,String description, double amount) {
		Reimbursement rem = new Reimbursement();
		try(Connection conn  = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String sql = "insert into reimbursement(submitterid,resolverid,submitdate,resolvedate,description,resolvenotes,amount) values(?,?,?,?,?,?,?)";
			String[] key = new String[1];
			key[0]="r_id";
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setInt(1, submitterId);
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			ps.setString(2,null);
			ps.setTimestamp(3, ts);
			ps.setTimestamp(4,null);
			ps.setString(5, description);
			ps.setString(6,"");
			ps.setDouble(7, amount);
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			rem.setR_id(id);
			rem.setAmount(amount);
			rem.setStatusId(0);
			rem.setDescription(description);
			rem.setSubmitDate(ts);
			rem.setSubmitterId(submitterId);
			rem.setResolveDate(null);
			rem.setResolverId(-1);
			rem.setResolveNotes(null);
			
			conn.commit();
		}  catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rem;
	}
	
	
	
	// I've gotten rid of methods for reimbursement type/status creation. That should be pre-determined.
	
	
	
	// user name to UID
	public int nameToId(String uname) {
		Connection connect = null;
		CallableStatement cs = null;
		int id = 0;
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call nametoid(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, uname);
			cs.execute();
			id = cs.getInt(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				cs.close();
				connect.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	
	
	// editFirstName
	public void editFirstName(int theUserId, String newFn) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update AUSER set firstname = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newFn);
			ps.setInt(2, theUserId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// editLastName
	public void editLastName(int theUserId, String newLn) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update AUSER set lastname = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newLn);
			ps.setInt(2, theUserId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// editUserName
	public void editUserName(int theUserId, String newUname) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update AUSER set username = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newUname);
			ps.setInt(2, theUserId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// editEmail
	public void editEmail(int theUserId, String newEmail) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update AUSER set email = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newEmail);
			ps.setInt(2, theUserId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// edit password
	public void editPassword(int theUserId, String newPass) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update AUSER set password = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setInt(2, theUserId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// getAllReimbursements
	public ArrayList<Reimbursement> allReimbursements(){
		ArrayList<Reimbursement> theReimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENT");
			Reimbursement temp = new Reimbursement();
			while (rs.next()) {
				temp = new Reimbursement();
				int rid = rs.getInt("r_id");
				int subid = rs.getInt("submitterid");
				int resid = rs.getInt("resolverid");
				Timestamp subdate = rs.getTimestamp("submitdate");
				Timestamp resdate = rs.getTimestamp("resolvedate");
				int statid = rs.getInt("statusId");
				String descr = rs.getString("description");
				String resnotes = rs.getString("resolvenotes");
				double amt = rs.getDouble("amount");
				
				temp.setR_id(rid);
				temp.setSubmitterId(subid);
				temp.setResolverId(resid);
				temp.setSubmitDate(subdate);
				temp.setResolveDate(resdate);
				temp.setStatusId(statid);
				temp.setDescription(descr);
				temp.setResolveNotes(resnotes);
				temp.setAmount(amt);
				theReimbursements.add(temp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return theReimbursements;
	}
	
	

	/**
	 * Gets all reimbursements submitted by user with id theUID
	 * @param theUID
	 * @return
	 */
	public ArrayList<Reimbursement> getUserReimbursements(int theUID){
		ArrayList<Reimbursement> theReimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENT");
			Reimbursement temp = new Reimbursement();
			while (rs.next()) {
				int subid = rs.getInt("submitterid");
				if(subid==theUID) {
					temp = new Reimbursement();
					int rid = rs.getInt("r_id");
					int resid = rs.getInt("resolverid");
					Timestamp subdate = rs.getTimestamp("submitdate");
					Timestamp resdate = rs.getTimestamp("resolvedate");
					int statid = rs.getInt("statusId");
					String descr = rs.getString("description");
					String resnotes = rs.getString("resolvenotes");
					double amt = rs.getDouble("amount");
					temp.setR_id(rid);
					temp.setSubmitterId(subid);
					temp.setResolverId(resid);
					temp.setSubmitDate(subdate);
					temp.setResolveDate(resdate);
					temp.setStatusId(statid);
					temp.setDescription(descr);
					temp.setResolveNotes(resnotes);
					temp.setAmount(amt);
					theReimbursements.add(temp);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return theReimbursements;
	}
	
	
	
	
	// getAllUsers
	public ArrayList<AUser> getAllUsers(){
		ArrayList<AUser> theUsers = new ArrayList<AUser>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM AUSER");
			AUser temp = new AUser();
			while (rs.next()) {
				temp = new AUser();
				int u_id = rs.getInt("u_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				int isManager = rs.getInt("isManager");
				
				temp.setU_id(u_id);
				temp.setFirstName(firstname);
				temp.setLastName(lastname);
				temp.setUserName(username);
				temp.setEmail(email);
				temp.setPassword(password);
				temp.setIsManager(isManager);
				
				theUsers.add(temp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return theUsers;
	}
	
	
	
	

	public ArrayList<RStatus> getReimbursementStatuses(){
		ArrayList<RStatus> theStati = new ArrayList<RStatus>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RSTATUS");
			RStatus temp = new RStatus();
			while (rs.next()) {
				temp = new RStatus();
				int st_id = rs.getInt("st_id");
				String stName = rs.getString("stname");
				
				temp.setSt_id(st_id);
				temp.setStName(stName);
				
				theStati.add(temp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return theStati;
	}
	
	
	/*
	 * EDIT REIMBURSEMENTS
	 */
	// editResolverId
	public void editResolverId(int resId, int solverId) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update REIMBURSEMENT set resolverid = ? where r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, solverId);
			ps.setInt(2, resId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 
	public void editResolveDate(int resId) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update REIMBURSEMENT set resolvedate = ? where r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(1, ts);
			ps.setInt(2, resId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 
	public void editStatusId(int resId, int statId) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update REIMBURSEMENT set statusid = ? where r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statId);
			ps.setInt(2, resId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 
	public void editResolveNotes(int resId, String resNotes) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update REIMBURSEMENT set resolvenotes = ? where r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, resNotes);
			ps.setInt(2, resId);
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
