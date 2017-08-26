package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

public class DAOImpl implements DAO{

	
	public int addUser(String fn, String ln, String email, String pass){
		try(Connection conn  = ConnectionFactory
				.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String sql = "insert into users "
					+ "(firstname, lastname, email, password) "
					+ "values(?, ?, ?, ? )";
			String [] key = new String[1];
			key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, email);
			ps.setString(4, pass);
			
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			
			conn.commit();
			return id;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public Account createAccount(User u, int typeId){
		Account a = null;
		
		try(Connection conn  = ConnectionFactory
				.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String sql = "insert into account(userid, typeid)"
					+ " values (?, ?)";
			String[] key = new String[1];
			key[0] = "accountid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, u.getId());
			ps.setInt(2, typeId);
			
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			
			a.setId(id);
			a.setBalance(0);
		//	a.setType();
			
			conn.commit();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return a;
	}
	
	
	
	
	
	
}


