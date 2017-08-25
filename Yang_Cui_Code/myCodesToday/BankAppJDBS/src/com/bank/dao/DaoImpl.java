package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;


public class DaoImpl implements DAO{

	@Override
	public ArrayList<User> getAllUser() {
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from example";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt(1);
				String fn=rs.getString(2);
				String ln=rs.getString(3);
				String email=rs.getNString(4);
				String pwd=rs.getNString(5);
				
				User user = new User(id,fn,ln,email,pwd);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int addUser(String fn, String ln, String email, String pwd) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql="insert into Users (firstname, lastname, email, password) values(?,?,?,?)";
			String[] key= new String[1];
			key[0]="userid";
			PreparedStatement ps= conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, email);
			ps.setString(4, pwd);
			ps.executeUpdate();
			int uid=0;
			ResultSet pk =ps.getGeneratedKeys();
			while(pk.next()){
				uid=pk.getInt(1);
			}
			conn.commit();
			return uid;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void deleteUser(User user) {

	}
	
	@Override
	public User changeBalance(User user, int amount, boolean deposit) {

		return null;
	}
	
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql="update users set firstname=?, lastname=?, email=?, password=? where userID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstname());	System.out.println(user.getFirstname());
			ps.setString(2, user.getLastname());	System.out.println(user.getLastname());
			ps.setString(3, user.getEmail());		System.out.println(user.getEmail());
			ps.setString(4, user.getPassword());	System.out.println(user.getPassword());
			ps.setInt(5, user.getID());
			ps.executeUpdate();
			int uid=user.getID();
			/*ResultSet pk =ps.getGeneratedKeys();
			while(pk.next()){
				uid=pk.getInt(1);
			}*/
			conn.commit();
			return uid;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public User authentication(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addAccount(User u, int typeId) {
		// TODO Auto-generated method stub
		Account a =null;
		try(Connection conn=ConnectionFactory.getInstance().getConnection();){
			String sql ="insert into account (userid,typeid) values (?,?)";
			String[] key = new String[1];
			key[0]="accountid";
			PreparedStatement ps= conn.prepareStatement(sql, key);
			ps.setInt(1, u.getID());
			ps.setInt(2, typeId);
			ps.executeUpdate();
			int aid=0;
			ResultSet pk =ps.getGeneratedKeys();
			while(pk.next()){
				aid=pk.getInt(1);
			}
			conn.commit();
			return aid;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
}
