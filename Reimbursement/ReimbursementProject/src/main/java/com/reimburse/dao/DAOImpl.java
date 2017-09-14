package com.reimburse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;
import com.reimburse.util.ConnectionFactory;

public class DAOImpl implements DAO {
	public HashMap<Integer, String> getEmails(){
		HashMap<Integer, String> emails = new HashMap<Integer, String>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select userid, email from users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt(1);
				String email = rs.getString(2);
				emails.put(id, email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emails;
		
		
	}


	public User getUserById(int id) {
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from users where userId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				u.setId(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setEmail(info.getString(4));
				u.setPassword(info.getString(5));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
				
				
		return u;
	}

	
	public int addUser(String firstname, String lastname, String email, String pwd) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String sql = "insert into users" 
							+ "(firstname, lastname, email, password) "
							+ "values(?,?,?,?)";
			String [] key = new String[1];
			key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, pwd);
			
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);				
			}
			conn.commit();
			return id;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return 0;
	}

	
	public Reimbursement addReimbursement(User u, String desc, double amt) {
		Reimbursement r = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into reimbursement(submitterId, description,amount)"
					+"values(?,?,?)"; 
			String[] key = new String[1];
			key[0] = "reimId";
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setInt(1,u.getId());
			ps.setString(2, desc);
			ps.setDouble(3, amt);
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			r.setReimburseid(id);
			conn.commit();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	public ArrayList<Reimbursement> getReimburseByUser(User u){
		ArrayList<Reimbursement> reimburse = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select r.reimId, r.description, r.amount, s.name as Status "
					+ "from reimbursements r inner join users on users.userid = r.submitterid"
					+ " inner join status s on s.statusid = r.statusid where users.userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet info = ps.executeQuery();
			while(info.next()){
				Reimbursement temp = new Reimbursement();
				temp.setReimburseid(info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitterid(u);
				//temp.setStatusid(info.);
				reimburse.add(temp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reimburse;
	}

}
