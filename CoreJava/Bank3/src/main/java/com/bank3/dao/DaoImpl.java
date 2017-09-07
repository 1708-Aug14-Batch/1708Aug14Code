package com.bank3.dao;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank3.pojos.Account;
import com.bank3.pojos.User;
import com.bank3.util.ConnectionFactory;

public class DaoImpl implements DAO {

	// @Override
	public void addUser(String fn, String ln, String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "insert into users (firstname, lastname, username, password) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createAccount(int userid, int typeid) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "insert into account (userid, typeid) values (?,?)";
			String sql2 = "select userid, typeid from account where userid = ? and typeid = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, userid);
			ps2.setInt(2, typeid);
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				System.out.println("You already have that account");
				return;
			} else {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				ps.setInt(2, typeid);
				ps.executeUpdate();
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editUser(String fn, String ln, String pw, int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "update users set firstname = ?, lastname = ?, password = ? where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setInt(4, id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getUserID(String username, String pw) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select userid from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double getBalance(int id, int typeid) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select balance from account where userid = ? and typeid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, typeid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getDouble(1);
			} else {
				return 0.0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0.0;
	}
	
	public void updateBalance(int id, int typeid, double deposit) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "update account set balance = ? where userid = ? and typeid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, deposit + getBalance(id, typeid));
			ps.setInt(2, id);
			ps.setInt(3, typeid);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAcct(int id, int typeid) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "delete account where userid = ? and typeid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, typeid);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int id) {
		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select firstname, lastname, username, password from users where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<Account> getAccountsByUser(int id) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select acc.ACCTID, acc.balance, t.name"
					+ " from account acc inner join users on users.userid = acc.userid"
					+ " inner join accounttype t on t.typeid = acc.typeid where users.userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				Account temp = new Account();
				temp.setAcctid(info.getInt(1));
				temp.setBalance(info.getDouble(2));
				temp.setUserid(id);
				temp.setTypeid(info.getInt(3));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
}
