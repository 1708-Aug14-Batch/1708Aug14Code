package com.ex.fakedao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.ex.pojos.Examples;
import com.ex.util.ConnectionFactory;

public class FakeDaoImpl {
	
	// function to take in example id and return full name
	// change get all to get track name
	
	/*
	 * Callable statement
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
	
	// prepared statement
	
	public int addExample(String fn, String ln) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO EXAMPLE(F_NAME, L_NAME) VALUES(?,?)";
			String[] key = new String[1];
			key[0] ="EX_ID";
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			
			int numRowsAdded = ps.executeUpdate();
			int id = 0;
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				id=rs.getInt(1);
			}
			conn.commit();
			return id;
			
		}catch(SQLException e){
			
		}
				
		return -1;
	}
	
	// Statement -get all examples
	// bad 
	
	public ArrayList<Examples> getAll(){
		ArrayList<Examples> list = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select EXAMPLE.EX_ID, EXAMPLE.F_NAME, EXAMPLE.L_NAME, TRACK.NAME FROM EXAMPLE LEFT JOIN TRACK ON EXAMPLE.FAV_SONG_ID = TRACK.TRACKID";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString("L_NAME");
				String song = rs.getString(4);
				
				Examples temp = new Examples(id,fn,ln,song);
				list.add(temp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}