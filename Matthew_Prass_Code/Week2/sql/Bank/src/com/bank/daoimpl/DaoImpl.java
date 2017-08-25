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
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

import Dao.DAO;
public class DaoImpl implements DAO{
	
		//prepared statement
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
		

		
		//statement
		public ArrayList<User> getAll()
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
					
					list.add(ex);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return list;
		}



		@Override
		public Account creatAccount(User u, int typeid) {
			Account a = null;
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				
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
				a.setId(id);
				a.setBalance(0);
				
				conn.commit();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return a;
		}
	}
