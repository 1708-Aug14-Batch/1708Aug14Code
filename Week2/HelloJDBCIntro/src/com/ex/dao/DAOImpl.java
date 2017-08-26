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
	
	//Callable statement
	public int getId(String name){
		Connection connect = null;
		CallableStatement cs = null;
		
		int id = 0;
		try{
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findPerson(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
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
			}catch(Exception e){e.printStackTrace();}
		}
		return id;
		
	}
	
	
	//Prepared Statements
	public int addExample(String fn, String ln){
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into example(firstname,lastname)" + "values(?,?)";
			String[] key = new String[1];
			key[0] = "ex_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);			
			int numRowAdded = ps.executeUpdate();
			int id =0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
	
	//Statements
	
	public ArrayList<Example> getAll(){
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
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
				
			
		}catch (SQLException e){
			e.printStackTrace();
		}return list;
	}
	
//	public String getName(int id){
//		Connection connect = null;
//		CallableStatement cs = null;
//		
//		String name = null;
//		try{
//			connect = ConnectionFactory.getInstance().getConnection();
//			int id = "{? = call findPerson(?)}";
//			
//			
//		}
//		
//		return null;
//	}
	
	

}
