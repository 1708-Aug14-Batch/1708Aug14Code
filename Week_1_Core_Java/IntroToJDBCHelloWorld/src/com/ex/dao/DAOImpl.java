package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.ex.pojos.Example;
import com.ex.util.ConnectionFactory;

public class DAOImpl {

	/*
	 * Callable Statement
	 */
	
	public int getID(String name) {
		Connection connect = null; //Create the connection and the callable statement
		CallableStatement cs = null;
		int id = 0;
		
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findPerson(?)}"; //Always gotta use {} when using callable statements
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC); //First question mark
			cs.setString(2, name); //Second question mark
			cs.execute();
			id = cs.getInt(1);
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
	
	//Name example callable statement
	public String getName(int num) {
		Connection connect = null; //Create the connection and the callable statement
		CallableStatement cs = null;
		String name = new String();
		
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call getName(?)}"; //Always gotta use {} when using callable statements, not for prepared statements
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR); //First question mark
			cs.setLong(2, num); //Second question mark
			cs.execute();
			name += cs.getString(1);
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
		
		return name;
	}
	
	/*
	 *  PREPARED STATEMENT
	 */
	public int addExample(String fn, String ln) {
	
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			
			String sql = "insert into example(firstname, lastname)" + 
					"values(?,?)";
			
			String[] keys = new String[1];
			keys[0] = "ex_id"; //Same as the primary key of the table
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, fn);
			ps.setString(2, ln);
			
			ps.executeUpdate(); //Execute update for this example because its editing the table
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
		return 0;
	}
	
	/*
	 * STATEMENT - get all examples
	 * 
	 */
	
	public ArrayList<Example> getAll(){
		ArrayList<Example> list = new ArrayList<Example>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from example";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				int song = rs.getInt(4);
				Example e = new Example(id,firstname,lastname,song);
				list.add(e);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
}

