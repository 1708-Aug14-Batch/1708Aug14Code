package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import com.rev.pojos.Example;
import com.rev.util.ConnectionFactory;

public class DAOImpl {
	
	
	//Callable statement
	public int getID(String name) {
		int ID = 0;
		Connection connect = null;
		CallableStatement cs = null;
		try {
			//gets an instance of the connection & gets the actual connection
			connect = ConnectionFactory.getInstance().getConnection();
			//for prepared statements, have to surround in curly braces
			String sql = "{? = call find_person(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();
			ID =cs.getInt(1);
		}
		catch(Exception e) {
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
		return ID;
	}
	
	
	public String getName(int ID) {
		String name = null;
		Connection connect = null;
		CallableStatement cs = null;
		try {
			//gets an instance of the connection & gets the actual connection
			connect = ConnectionFactory.getInstance().getConnection();
			//for prepared statements, have to surround in curly braces
			String sql = "{? = call find_person_name(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, ID);
			cs.execute();
			name =cs.getString(1);
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
	
	
	//This is an update, not a Query
	public int addExample(String fn, String ln) {
		int id = -1;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false); //this makes sure we don't ruin things if something goes wrong
			String sql = "insert into example (Firstname, lastname) "
					+ "values( ? , ? )"; //we could just concantinate with fn & ln, but then this would be just a STATEMENT which is BAD
			String[] key = new String[1];
			key[0] = "ex_id";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			
			//gives us the same thing printed out in bottom of thing
			int numRows = ps.executeUpdate();
			//returns anything created by a trigger
			ResultSet pk = ps.getGeneratedKeys();
			
			//
			while(pk.next()) {
				id = pk.getInt(1);
			}
			
			conn.commit();
			return id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	//Statement - Get all examples
	//We really only want to use these for get all, when we are not putting in any parameters
	
	public ArrayList<Example> getAll(){
		ArrayList<Example> list = new ArrayList<Example>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select ex.ex_id, ex.firstname, ex.lastname, tr.name from example ex left join track "
					+ "tr on ex.fave_song_id = tr.trackid";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			//get each element as temporary element, then store them into an array list
			while (rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String song = rs.getString(4);
				
				Example temp = new Example(id, fn, ln, song);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
}
