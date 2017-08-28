package com.bank.daoimpl;

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
public class DaoImpl implements DAO{
	
		@Override
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
