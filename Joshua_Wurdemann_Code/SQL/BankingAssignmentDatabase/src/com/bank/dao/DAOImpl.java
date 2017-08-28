package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;

public class DAOImpl {
	/** Callable statement*/

	public int getUserId(String name){
		Connection connect = null;
		CallableStatement cs = null;
		int id = 0;

		try{ 
			connect = ConnectionFactory
					.getInstance()
					.getConnection();
			String sql = "{? = call findPerson(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();
			id = cs.getInt(1);


		} catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				cs.close();
				connect.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return id ;
	}
	/** PREPARED STATEMENT*/
	public int addUser(String fn, String ln, String em, String pw){
		try (
			Connection conn = ConnectionFactory.
					getInstance()
					.getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into example" + "(Firstname, lastname, email, password)"
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
	/** STATEMENT - get all examples*/
	public ArrayList<User> getAll(){
		ArrayList<User> list = new ArrayList<>();
		try (
			Connection conn = ConnectionFactory.
					getInstance()
					.getConnection();){
						String sql = "select * from User";
						Statement statement = conn.createStatement();
						ResultSet rs = statement.executeQuery(sql);
						
						while(rs.next()){
							int userid = rs.getInt(1);
							String fn = rs.getString("firstname");
							String ln = rs.getString("lastname");
							String em = rs.getString("email");
							String pw = rs.getString("password");
														
							User temp = new User(userid, fn, ln, em, pw);
							list.add(temp);
							
						}
					
		} catch(SQLException e){
			e.printStackTrace();
	}
		return list;
	}
}

