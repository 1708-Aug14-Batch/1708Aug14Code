package com.bank.dao;

import java.io.Closeable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.rev.utils.ConnectionFactory;

public class DBDAO implements Closeable {
	private Connection dbConn;
	
	public DBDAO() {
		dbConn = ConnectionFactory.getInstance().getConnection();
		try {
			dbConn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean createNewUser(String fn, String ln, String email, String pw) {
		final String sql = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
		try (PreparedStatement cs = dbConn.prepareStatement(sql)) {
			cs.setString(1, fn);
			cs.setString(2, ln);
			cs.setString(3, email);
			cs.setString(4, pw);
			cs.execute();
			dbConn.commit();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public void updateUserFirst(int userId, String fn) {
		final String sql = "UPDATE users SET first_name = ? WHERE user_id = ?";
		try (PreparedStatement cs = dbConn.prepareStatement(sql)) {
			cs.setString(1, fn);
			cs.setInt(2, userId);
			cs.execute();
			dbConn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateUserLast(int userId, String ln) {
		final String sql = "UPDATE users SET last_name = ? WHERE user_id = ?";
		try (PreparedStatement cs = dbConn.prepareStatement(sql)) {
			cs.setString(1, ln);
			cs.setInt(2, userId);
			cs.execute();
			dbConn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateUserPassword(int userId, String pw) {
		final String sql = "UPDATE users SET password = ? WHERE user_id = ?";
		try (PreparedStatement cs = dbConn.prepareStatement(sql)) {
			cs.setString(1, pw);
			cs.setInt(2, userId);
			cs.execute();
			dbConn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean createNewAccount(int userId, AccountType type) {
		final String selSql = "SELECT * FROM accounts WHERE user_id = ? AND account_type_id = ?";
		try (PreparedStatement s = dbConn.prepareStatement(selSql)) {
			s.setInt(1,  userId);
			s.setInt(2, type.getId());
			ResultSet rs = s.executeQuery();
			if (rs.next())
				return false;
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		final String inSql = "INSERT INTO accounts (user_id, account_type_id) VALUES (?, ?)";
		try (PreparedStatement cs = dbConn.prepareStatement(inSql)) {
			cs.setInt(1, userId);
			cs.setInt(2, type.getId());
			cs.execute();
			dbConn.commit();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Account selectAccount(int userId, AccountType type) {
		final String sql = "SELECT * FROM accounts WHERE user_id = ? AND account_type_id = ?";
		try (PreparedStatement cs = dbConn.prepareStatement(sql)) {
			cs.setInt(1, userId);
			cs.setInt(2, type.getId());
			ResultSet rs = cs.executeQuery();
			
			Account acc = new Account();
			if (rs.next()) {
				acc.setId(rs.getInt("account_id"));
				acc.setBalance(new BigDecimal(rs.getFloat("balance")));
				acc.setType(type);
				return acc;
			}
			
			return null;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public User attemptLogin(String email, String password) {
		final String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
		try (PreparedStatement s = dbConn.prepareStatement(sql)) {
			User usr = new User();
			
			s.setString(1, email);
			s.setString(2, password);
			
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				usr.setId(rs.getInt("user_id"));
				usr.setFirst(rs.getString("first_name"));
				usr.setLast(rs.getString("last_name"));
				usr.setEmail(email);
				usr.setPassword(password);
				return usr;
			}
			
			return null;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void deposit(int accId, BigDecimal b) {
		final String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
		try (PreparedStatement s = dbConn.prepareStatement(sql)) {
			s.setDouble(1, b.doubleValue());
			s.setInt(2, accId);
			s.execute();
			dbConn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void withdraw(int accId, BigDecimal b) {
		final String sql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
		try (PreparedStatement s = dbConn.prepareStatement(sql)) {
			s.setDouble(1, b.doubleValue());
			s.setInt(2, accId);
			s.execute();
			dbConn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void transfer(int usrId, AccountType fromType, AccountType toType, BigDecimal b) {
		final String sql1 = "UPDATE accounts SET balance = balance - ? WHERE user_id = ? AND account_type_id = ?";
		final String sql2 = "UPDATE accounts SET balance = balance + ? WHERE user_id = ? AND account_type_id = ?";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql1);
			ps.setDouble(1, b.doubleValue());
			ps.setInt(2, usrId);
			ps.setInt(3, fromType.getId());
			ps.execute();
			ps.close();
			
			ps = dbConn.prepareStatement(sql2);
			ps.setDouble(1, b.doubleValue());
			ps.setInt(2, usrId);
			ps.setInt(3, toType.getId());
			ps.execute();
			ps.close();
			
			dbConn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void closeAcc(int accId) {
		final String sql = "DELETE FROM accounts WHERE account_id = ?";
		try (PreparedStatement p = dbConn.prepareStatement(sql)) {
			p.setInt(1, accId);
			p.execute();
			dbConn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void close() {
		try {
			dbConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
