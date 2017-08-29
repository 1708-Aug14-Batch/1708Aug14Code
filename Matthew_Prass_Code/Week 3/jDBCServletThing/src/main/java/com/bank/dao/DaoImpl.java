package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;
public class DaoImpl implements DAO{
	
	@Override
	public HashMap<Integer, String> getEmails(){
		HashMap<Integer, String> emails = new HashMap<Integer, String>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			String sql = "select user_id, email from users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt(1);
				String email = rs.getString(2);
				emails.put(id, email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emails;
	}
	
	
	@Override
	public User getUserByID(int id)
	{
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			conn.setAutoCommit(false);
			String sql = "select * from users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				u.setId(rs.getInt(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return u;
	}
	
		@Override
		//add a user as a prepared statement
		public int addUser(String fn,String ln,String email,String pw)
		{
			try(Connection conn = ConnectionFactory.getInstance().getConnection();)
			{
				conn.setAutoCommit(false);
				String sql = "insert into users(firstname,lastname,email,password)" + 
						"values(?,?,?,?)";
				String[] keys = new String[1];
				keys[0] = "user_id";
				PreparedStatement ps = conn.prepareStatement(sql,keys);
				ps.setString(1, fn);
				ps.setString(2, ln);
				ps.setString(3, email);
				ps.setString(4, pw);
				
				int numRows = ps.executeUpdate();
				int id = 0;
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next())
				{
					id = pk.getInt(1);
				}
				
				conn.commit();
				return id;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}
		
		@Override
		//create a new account as a prepared statement
		public Account creatAccount(User u, int typeid) {
			Account a = null;
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				
				conn.setAutoCommit(false);
				String sql = "insert into account(user_id, type_id)" + 
						"values(?,?)";
				
				String[] key = new String[1];
				key[0]= "account_id";
				PreparedStatement ps = conn.prepareStatement(sql, key);
				ps.setInt(1, u.getId());
				ps.setInt(2, typeid);
				
				int numRows = ps.executeUpdate();
				int id = 0;
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next())
				{
					id = pk.getInt(1);
				}
				
				conn.commit();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return a;
		}

		@Override
		//retrieve all the users registered as a statement
		public ArrayList<User> getAllUsers()
		{
			ArrayList<User> list = new ArrayList<User>();
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				
				String sql = "select * from users";
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next())
				{
					int id = rs.getInt(1);
					String firstname = rs.getString(2);
					String lastname = rs.getString(3);
					String email = rs.getString(4);
					String pw = rs.getString(5);
					
					User ex = new User(firstname, lastname, email, pw);
					ex.setId(id);
					list.add(ex);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return list;
		}
		
		@Override
		//get all the accounts belonging to a user as a prepared statement
		public ArrayList<Account> getAllAccountsForUser(int userid)
		{
			ArrayList<Account> list = new ArrayList<Account>();

			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				conn.setAutoCommit(false);
				String sql = "select * from account " + 
								"where user_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					int id = rs.getInt(1);
					double bal = rs.getDouble(2);
					int uid = rs.getInt(3);
					int actid = rs.getInt(4);
					
					Account ex = new Account(bal, getUser(uid), getAccountType(actid));
					ex.setId(id);
					list.add(ex);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return list;
		}
		
		@Override
		//get all the account types as a statement
		public ArrayList<AccountType> getAllAccountTypes() {
			ArrayList<AccountType> list = new ArrayList<AccountType>();

			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				
				String sql = "select *" + 
						"from accounttype";
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next())
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					
					AccountType ex = new AccountType(id,name);
					
					list.add(ex);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return list;
		}
		
		
		@Override
		//using the get all method, able to find one of the users within it
		public User getUser(int id)
		{
			ArrayList<User> list = getAllUsers();
			for(User u:list)
			{
				if(u.getId() == id)
					return u;
			}
			return null;
		}
		
		@Override
		//using the get all method, able to find one of the account types
		public AccountType getAccountType(int id)
		{
			ArrayList<AccountType> list = getAllAccountTypes();
			for(AccountType at:list)
			{
				if(at.getId() == id)
					return at;
			}
			return null;
		}

		@Override
		//updating the user credentials by calling a stored procedure
		public void updateUser(User u) 
		{
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "{ call updateUser(?,?,?,?,?) }";
				
				
				CallableStatement cs = conn.prepareCall(sql);
				cs.setString(2, u.getFirstname());
				cs.setString(3, u.getLastname());
				cs.setString(4, u.getEmail());
				cs.setString(5, u.getPassword());
				cs.setInt(1, u.getId());
				cs.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		//updating a user account by calling a stored procedure
		public void updateAccount(Account a) 
		{
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "{ call updateAccount(?,?) }";
				
				
				CallableStatement cs = conn.prepareCall(sql);
				cs.setDouble(2, a.getBalance());
				cs.setInt(1, a.getId());
				cs.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			
		}

		@Override
		//deleting a user by calling a stored procedure
		public void deleteUser(User u) {
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "{ call deleteUser(?) }";
				
				
				CallableStatement cs = conn.prepareCall(sql);
				cs.setInt(1,u.getId());
				cs.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		//deleting an account held by a user by calling a stored procedure
		public void deleteAccount(Account a) {
		
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "{ call deleteAccount(?) }";
				
				
				CallableStatement cs = conn.prepareCall(sql);
				cs.setInt(1,a.getId());
				cs.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
