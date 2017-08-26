package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;


public class DaoImpl implements DAO{

	@Override
	public ArrayList<User> getAllUser() {
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt(1);
				String fn=rs.getString(2);
				String ln=rs.getString(3);
				String email=rs.getNString(4);
				String pwd=rs.getNString(5);
				
				//User user = new User(id,fn,ln,email,pwd);
				users.add(new User(id,fn,ln,email,pwd));
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
	public int deleteUser(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql ="delete from users where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getID());
			ps.executeUpdate();
			conn.commit();
			return user.getID();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql="update users set firstname=?, lastname=?, email=?, password=? where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstname());	//System.out.println(user.getFirstname());
			ps.setString(2, user.getLastname());	//System.out.println(user.getLastname());
			ps.setString(3, user.getEmail());		//System.out.println(user.getEmail());
			ps.setString(4, user.getPassword());	//System.out.println(user.getPassword());
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
		User user=getUser(id);
		if(password.equals(user.getPassword()))
			return user;
		else
			return null;
	}


	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from users where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				String fn=rs.getString(2);
				String ln=rs.getString(3);
				String email=rs.getNString(4);
				String pwd=rs.getNString(5);
				User user = new User(id,fn,ln,email,pwd);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addAccount(User user, int typeId) {
		// TODO Auto-generated method stub
		try(Connection conn=ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql ="insert into account (userid,typeid) values (?,?)";
			String[] key = new String[1];
			key[0]="accountid";
			PreparedStatement ps= conn.prepareStatement(sql, key);
			ps.setInt(1, user.getID());
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
	
	@Override
	public Account changeBalance(Account acct) {
		try(Connection conn=ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql ="update account set balance=? where accountid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, acct.getBalance());
			ps.setInt(2, acct.getID());
			ps.executeUpdate();
			conn.commit();
			return acct;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Account> getAccount(User user) {
		// TODO Auto-generated method stub
		ArrayList<Account> userAcc =new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql ="select * from account where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int a_id=rs.getInt(1);
				double money=rs.getDouble(2);
				int t_id=rs.getInt(4);
				userAcc.add(new Account(a_id,money,user,getAccountType(t_id)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userAcc;
	}
	
	@Override
	public int closeAccount(Account acc) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql ="delete from account where accountid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acc.getID());
			ps.executeUpdate();
			conn.commit();
			return acc.getID();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public ArrayList<Account> getAllAccount() {
		// TODO Auto-generated method stub
		ArrayList<Account> alist=new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql ="select * from account";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int a_id=rs.getInt(1);
				double money=rs.getDouble(2);
				int u_id=rs.getInt(3);
				int t_id=rs.getInt(4);
				//Account acc=new Account(a_id,money,getUser(u_id),getAccountType(t_id));
				alist.add(new Account(a_id,money,getUser(u_id),getAccountType(t_id)));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return alist;
	}
	
	@Override
	public Account getAnAccount(int id) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql ="select * from account where accountid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				int a_id=rs.getInt(1);
				double money=rs.getDouble(2);
				int u_id=rs.getInt(3);
				int t_id=rs.getInt(4);
				Account acc=new Account(a_id,money,getUser(u_id),getAccountType(t_id));
			return acc;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountType getAccountType(int id) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from accounttype where typeid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();	
			if(rs.next()){
				String name=rs.getString(2);
				AccountType accType=new AccountType(id,name);
				return accType;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<AccountType> getAllAccountType() {
		// TODO Auto-generated method stub
		ArrayList<AccountType> atlist=new ArrayList<AccountType>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from accounttype";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				atlist.add(new AccountType(id,name));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return atlist;
	}
}
