package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

public class DAOImpl implements DAO{

	//prepared statement
	public int addUser(String fn, String ln, String usr, String pwd) {
		int id = -1;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			//create the String we will pass in prepared statement
			String sql = "insert into users(firstname, lastname, username, pass_word)"
					+ "values(?,?,?,?)";
			//this array contains the names of the target table that contain 
			//auto generated keys that should be returned
			String[] key = new String[1];
			key[0] = "user_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, usr);
			ps.setString(4, pwd);

			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
		}
		catch(SQLIntegrityConstraintViolationException e) {
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int addAccount(User user, int type) {
		int id = -1;
		int userId = user.getUserId();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			//create the String we will pass in prepared statement
			String sql = "insert into account(user_id, type_id)"
					+ "values(?,?)";
			//this array contains the names of the target table that contain 
			//auto generated keys that should be returned
			String[] key = new String[1];
			key[0] = "account_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, userId);
			ps.setInt(2, type);
			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int getUser(String username) {
		int id =0;
		Connection connect = null;
		CallableStatement cs = null;
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call get_user_id(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, username);
			cs.execute();
			id =cs.getInt(1);
		}
		catch(SQLException e) {
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

	public String getUser(int id) {
		String usr = null;
		Connection connect = null;
		CallableStatement cs = null;
		try {
			//gets an instance of the connection & gets the actual connection
			connect = ConnectionFactory.getInstance().getConnection();
			//for prepared statements, have to surround in curly braces
			String sql = "{? = call get_user(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			usr =cs.getString(1);
		}
		catch(SQLException e) {
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
		return usr;
	}

	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Account> getAccounts(int id) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		Connection connect = null;
		CallableStatement cs = null;
		try {
			//gets an instance of the connection & gets the actual connection
			connect = ConnectionFactory.getInstance().getConnection();
			//for prepared statements, have to surround in curly braces
			String sql = "select * from account where user_id ="+id;
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				int aid = rs.getInt("account_id");
				int type = rs.getInt("type_id");
				double balance = rs.getDouble("balance");
				Date open = rs.getDate("open_date");
				Date close = rs.getDate("close_date");
				Account temp = new Account(aid, type, balance, open, close);
				accounts.add(temp);
			}

		}
		catch(SQLException e) {
			e.printStackTrace();

		}
		return accounts;

	}

	public void closeAccount(int id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			//create the String we will pass in prepared statement
			String sql = "update account set close_date = sysdate, balance = 0 where ACCOUNT_ID = ?";
			//this array contains the names of the target table that contain 
			//auto generated keys that should be returned
			//			String[] key = new String[1];
			//			key[0] = "account_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void updateUsers(int id, String fn,String ln, String usr, String pwd) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			//create the String we will pass in prepared statement
			String sql = "update Users set FIRSTNAME = ?, LASTNAME = ?, PASS_WORD = ?,"
					+ "USERNAME = ? where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pwd);
			ps.setString(4, usr);
			ps.setInt(6, id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void updateBalance(int id, double bal) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			//create the String we will pass in prepared statement
			String sql = "update Account set balance = ? where USER_ID = ?";
			//this array contains the names of the target table that contain 
			//auto generated keys that should be returned
			//			String[] key = new String[1];
			//			key[0] = "account_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, bal);
			ps.setInt(2, id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}



}
