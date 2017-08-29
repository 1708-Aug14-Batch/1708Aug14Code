package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

public class DAOImpl implements DAO {

	@Override
	public int addUser(String fn, String ln,String email,String password) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);;
			String sql = "insert into Users (firstname, lastname,email,password) values(?,?,?,?)";
			String[] key = new String[1];
			key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, email);
			ps.setString(4, password);
			
			ps.executeUpdate(); // returns an int
			int id = 0;
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
	
	public Account createAccount(User u, int typeId){
		Account a = new Account();
		
		try(Connection conn  = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String sql = "insert into account(userid, typeid) values (?, ?)";
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
			AccountType theType = getAccountType(typeId);
			a.setType(theType);
			
			conn.commit();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return a;
	}
	
	
	
	@Override
	public void addAccountType(int typeId, String name) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);;
			String sql = "insert into accounttype (typeid,name) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, typeId);
			ps.setString(2, name);
			
			ps.executeUpdate(); // returns an int
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account getAccount(int accId) {
		Connection connect = null;
		CallableStatement cs = null;
		String str = "";
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call getAccount(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, accId);
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
		if (str.equals("-1")) {
			return null;
		}
		else {
			Account myAccount = new Account();
			String[] mAS = str.split(",");
			myAccount.setId(Integer.parseInt(mAS[0]));
			myAccount.setBalance(Double.parseDouble(mAS[1]));
			User myUser = getUser(Integer.parseInt(mAS[2]));
			myAccount.setUser(myUser);
			AccountType myAccountType = getAccountType(Integer.parseInt(mAS[3]));
			myAccount.setType(myAccountType);
			return myAccount;
		}
	}
	
	
	public User getUser(int userId) {
		Connection connect = null;
		CallableStatement cs = null;
		String str = "";
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call getUser(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, userId);
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
		if (str.equals("-1")) {
			return null;
		}
		else {
			User thisUser = new User();
			String[] mu = str.split(",");
			thisUser.setId(Integer.parseInt(mu[0]));
			thisUser.setFirstname(mu[1]);
			thisUser.setLastname(mu[2]);
			thisUser.setEmail(mu[3]);
			thisUser.setPassword(mu[4]);
			return thisUser;
		}
	}
	
	
	public AccountType getAccountType(int accIdx) {
		Connection connect = null;
		CallableStatement cs = null;
		String str = "";
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call getAccType(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, accIdx);
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
		if (str.equals("-1")) {
			return null;
		}
		else {
			AccountType theType = new AccountType();
			String[] at = str.split(",");
			theType.setId(Integer.parseInt(at[0]));
			theType.setName(at[1]);
			return theType;
		}
	}
	
	
	public int unameToID(String uname) {
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
	
	public boolean accountUserMatch(int userId, int accountId) {
		
		Account theAccount = getAccount(accountId);
		if (theAccount.getUser().getId() == userId) {
			return true;
		}
		return false;
	}
	
	public void editEmail(int theUserId, String newEmail) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update USERS set email= ? where userid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newEmail);
			ps.setInt(2, theUserId);
			
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("done here");
	}
	
	public void editFirstName(int theUserId, String fn) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update Users set firstname=? where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setInt(2, theUserId);
			
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editLastName(int theUserId, String ln) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update users set lastname=? where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ln);
			ps.setInt(2, theUserId);
			
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("done here");
	}
	
	public void editPassword(int theUserId, String pass) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update users set password=? where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setInt(2, theUserId);
			
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("done here");
	}
	
	
	
	
	public void editBalance(int theUserId, int accountId, double amountChange) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update account set balance=balance+? where userid=? and accountid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amountChange);
			ps.setInt(2, theUserId);
			ps.setInt(3, accountId);
			
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Account> allAccounts(){
		ArrayList<Account> theAccounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
			Account temp = new Account();
			while (rs.next()) {
				temp = new Account();
				int aid = rs.getInt("AccountId");
				double balance = rs.getDouble("balance");
				int uid = rs.getInt("userid");
				User user = getUser(uid);
				int typeid = rs.getInt("typeid");
				AccountType theType = getAccountType(typeid);
				temp.setId(aid);
				temp.setBalance(balance);
				temp.setUser(user);
				temp.setType(theType);
				theAccounts.add(temp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return theAccounts;
	}
	
	
	
	
	
	

}
