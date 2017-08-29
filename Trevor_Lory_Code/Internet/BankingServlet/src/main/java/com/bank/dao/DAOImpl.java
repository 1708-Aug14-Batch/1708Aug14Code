package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

public class DAOImpl implements DAO {

	public int addUser(String fn, String ln, String em, String psw) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into users (firstname, lastname, email, password) " + 
						 "values (?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, em);
			ps.setString(4, psw);
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) { }
		return -1;
	}
	
	public User getUser(String email, String password) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select userid, firstname, lastname, email, password from users where email = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String em = rs.getString(4);
				String pass = rs.getString(5);
				u = new User(id, fn, ln, em, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public Account createAccount(User u, int typeid, String AccountName) {
		Account a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into accounts (name, userid, typeid) values (?, ?, ?)";
			String[] key = new String[1];
			key[0] = "accountid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, AccountName);
			ps.setInt(2, u.getId());
			ps.setInt(3, typeid);
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			AccountType acct = new AccountType(typeid);
			a = new Account(id, 0, AccountName, u.getId(), acct);
			conn.commit();
		} catch (SQLException e) { }
		return a;
	}
	
	public boolean updateUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "update users set firstname = ?, lastname = ?, email = ?, password = ? where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean closeAccount(Account a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "delete from accounts where accountid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Account> getUserAccount(User u) {
		ArrayList<Account> list = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from accounts where userid = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, u.getId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				AccountType acc = new AccountType(rs.getInt(5));
				Account temp = new Account(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getInt(4), acc);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean updateAccount(Account a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update accounts set balance = ? where accountid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
