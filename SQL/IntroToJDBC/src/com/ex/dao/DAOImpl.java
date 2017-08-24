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
	 * Callable statement
	 * calls findPerson function in DB that takes in a
	 * string (firstname) as a parameter then returns the
	 * person's ID
	 */
	public int getID(String name){
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
			cs.setString(2, name );
			cs.execute();
			id = cs.getInt(1);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				cs.close();
				connect.close();
			} catch(Exception e){e.printStackTrace();}
		}
		return id;
	}
	
	/*
	 * PREPARED STATEMENT
	 */
	public int addExample(String fn, String ln){
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into example "
					+ "(FIRSTNAME, LASTNAME) "
					+ "values(?, ?)";
			String[] key = new String[1];
			key[0] = "ex_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			
			int numRowsAdded = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	/*
	 * STATEMENT - get all examples
	 */
	
	public ArrayList<Example> getAll(){
		ArrayList<Example> list = new ArrayList<Example>();
		
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			
			String sql = "select * from example";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString("lastname");
				int song = rs.getInt("fave_song_id");
				
				Example temp = new Example(id, fn, ln, song);
				
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
