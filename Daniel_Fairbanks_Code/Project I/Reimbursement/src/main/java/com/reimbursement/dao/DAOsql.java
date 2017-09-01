package com.reimbursement.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;

import com.reimbursement.pojos.User;
import com.reimbursement.util.ConnectionFactory;

public class DAOsql implements DAO {
	
	public User getUser(String email) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM Users";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String mail = rs.getString(4);
				if (mail.equals(email)) {
					int id = rs.getInt(1);
					String fname = rs.getString(2);
					String lname = rs.getString(3);
					String pword = rs.getString(5);
					boolean isMgr = rs.getInt(6) == 0 ? false : true;
					User u = new User(id, fname, lname, mail, pword, isMgr);
					return u;
				}
			}	
		} catch (SQLException e) {
			System.out.println("ERROR: DAOsql - getUser");
		} 
		return null;
	}
	
	public HashMap<Integer, User> getAllUsers() {
		HashMap<Integer, User> users = new HashMap<Integer, User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT u.UserID, u.Firstname, u.Lastname, u.Email, u.Password, a.Balance, t.Name "
					+ "FROM Users u "
					+ "LEFT JOIN Account a "
					+ "ON u.UserID = a.UserID "
					+ "LEFT JOIN AccountType t "
					+ "ON a.TypeID = t.TypeID";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				User tmp = new User();
				tmp.setId(id);
				tmp.setFirstname(firstname);
				tmp.setLastname(lastname);
				tmp.setEmail(email);
				tmp.setPassword(password);
				users.put(id, tmp);
			}
		} catch (Exception e) {
			System.out.println("ERROR: DAOsql - getAllUsers");
		}
		return users;
	}

}
