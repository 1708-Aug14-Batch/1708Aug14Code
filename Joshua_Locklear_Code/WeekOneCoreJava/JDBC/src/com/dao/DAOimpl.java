package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.pojo.Example;
import com.util.ConnectionFactory;

public class DAOimpl {
	/*
	 * callable statement
	 */
	
	public int getID(String name){
		Connection conn = null;
		CallableStatement cs = null;
		int id = 0;
		
		try{
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findPersion(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();
			id = cs.getInt(1);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				cs.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/*
	 * prepared statement
	 */
	
	public int addExample(String fn, String ln){
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into example(FIRST_NAME, LAST_NAME)"+
					"values(?,?)";
			String [] keys = new String[1];
			keys[0]="ex_id";
			PreparedStatement ps = conn.prepareStatement(sql,keys);
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
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return -1;
	}
	
	public ArrayList<Example> getAll(){
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from example";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				int song = rs.getInt("favorite_song_id");
				
				Example temp = new Example(id,fn,ln,song);
				list.add(temp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	public String getNameById(int employeeId){
		String myString = null;
		CallableStatement cs = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String mySql = "{? = call finedNameOnId(?)}";
			cs = conn.prepareCall(mySql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, employeeId);
			cs.execute();
			myString = cs.getString(1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return myString;
	}
	public ArrayList<Example> getAll2(){
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = ("SELECT ex.ex_id, ex.first_name, ex.last_name, tr.name" +
							"FROM example ex LEFT JOIN TRACK TR ON EX.FAVORITE_SONG_ID = TR.TRACKID");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				int song = rs.getInt(3);
				String songName = rs.getString(4);
				
				Example temp = new Example(id,fn,ln,song,songName);
				list.add(temp);
			}
			conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

}
