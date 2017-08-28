package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Formatter;

import com.bank.pojo.Account;
import com.bank.pojo.AccountType;
import com.bank.pojo.DAO;
import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class DAOIm implements DAO {

	public int addUser(String fn, String ln, String em, String pw){
		try(

				Connection conn = ConnectionFactory.
				getInstance()
				.getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into users" + "(Firstname, lastname, email, password)"
					+ "values(?, ?, ?, ?)";
			String [] key = new String [1];
			key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, em);
			ps.setString(4, pw);
			int numRowsAdded = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
		} catch(SQLException e){
			e.printStackTrace();

		}
		return -1;
	}

	@Override
	public Account addAccount(User u, int typeId) {
		Account a = new Account();
		try(
				Connection conn = ConnectionFactory.
				getInstance()
				.getConnection();){
			conn.setAutoCommit(false);

			String sql = "insert into account(userid, typeid)"
					+ "values (?, ?)";
			String [] key = new String[1];
			key[0] = "accountid";
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setInt(1, u.getUserId());
			ps.setInt(2, typeId);

			ps.executeUpdate();

			int id = 1;
			ResultSet pt = ps.getGeneratedKeys();
			while(pt.next()){
				id = pt.getInt(1);
			}
			AccountType some = new AccountType();
			
			a.setId(id);
			a.setBalance(0);
			a.setType(a.getType());
			some.setId(typeId);
			some.setName(some.getName());
			a.setType(some);
			a.setUser(u);
			conn.commit();
			return a;
		} catch(SQLException e){
			e.printStackTrace();

		}
		return a;// change this when we need I get to accounts

	}
	/** calling stored procedure getuser*/
	public User getUser(String email, String password){
		User add = null;
		try(
           
				Connection conn = ConnectionFactory.
				getInstance()
				.getConnection();){
			conn.setAutoCommit(false);
			String sql = "call getUser(?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(2, email);
			cs.setString(3, password);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();


			ResultSet result = (ResultSet) cs.getObject(1);				

			if(result.next()){
				add = new User();

				add.setUserId(result.getInt("userId"));
				add.setFirstName(result.getString("firstname"));
				add.setLastName(result.getString("lastname"));
				add.setEmail(result.getString("email"));
				add.setPassword(result.getString("password"));
			} 
		} catch(SQLException e){
			e.printStackTrace();
		}
		return add;
	}

	public Account getAccount(User someUser){
		Account add = null;
		try( 
				Connection conn = ConnectionFactory.
				getInstance()
				.getConnection();){
			conn.setAutoCommit(false);
			String sql = "call getAccount(?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(2, someUser.getUserId());
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			// cast object to result set
			ResultSet result = (ResultSet) cs.getObject(1);

			if(result.next()){
				add = new Account();
				AccountType some = new AccountType();
			
				add.setId(result.getInt("accountId"));
				add.setBalance(result.getDouble("balance"));
				some.setId(result.getInt("typeId"));
				some.setName(result.getString("name"));
				add.setType(some);
				add.setUser(someUser);
			} 
		} catch(SQLException e){
			e.printStackTrace();
		}
		return  add;
	}
	
	
	public int updateAccount(int userId, Double balance) {
	 int num = 0;
		
		try( 
				Connection conn = ConnectionFactory.
				getInstance()
				.getConnection();){
			conn.setAutoCommit(false);
			String sql = "Call Deposit(?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(2, balance);
			cs.setInt(3, userId);
			cs.registerOutParameter(1, OracleTypes.NUMBER);
			cs.execute();
			
			num =  cs.getInt(1);
			
	}catch(SQLException e){
		e.printStackTrace();
	}
	return  num;
}
	public int editUser(int userId, String email, String password) {
		 int num = 0;
			
			try( 
					Connection conn = ConnectionFactory.
					getInstance()
					.getConnection();){
				conn.setAutoCommit(false);
				String sql = "Call editAccount(?, ?, ?, ?)";
				CallableStatement cs = conn.prepareCall(sql);
				cs.setInt(2, userId);
				cs.setString(3, email);
				cs.setString(4, password);
				cs.registerOutParameter(1, OracleTypes.NUMBER);
				cs.execute();
				
				num =  cs.getInt(1);
				
		}catch(SQLException e){
			System.out.println("invalid email");
		}
			
		return  num;
	}

	
	
	
	
	
	}
	
	