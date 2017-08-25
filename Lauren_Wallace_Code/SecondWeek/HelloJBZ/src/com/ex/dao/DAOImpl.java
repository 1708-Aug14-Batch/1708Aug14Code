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
	 */
	public int getID(String name) {
		
		Connection connect = null;   //creates a connection
		CallableStatement cs = null; //creates a callablestatement
		int id = 0;
		
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findPerson(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);       
			cs.setString(2, name);                           //this is the 2nd ?
			cs.execute();
			id = cs.getInt(1);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cs.close();
				connect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	/*
	 * PREPARED STATEMENT
	 */

	public int addExample(String fn, String ln) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into example (firstname, lastname) values (?,?)";
			String[] key = new String[1];
			key[0] = "ex_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);  //it won't matter what is contained within the String
			ps.setString(2, ln);
			
			int numRowsAdded = ps.executeUpdate(); //will return num of rows inserted
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	/*
	 * STATEMENT - GET ALL EXAMPLES
	 */
	
	public ArrayList<Example> getAll() {
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from example";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString("lastname");
				int song = rs.getInt("fave_song_id");
				
				Example temp = new Example(id, fn, ln, song);
				list.add(temp);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
	
	/*
	 * STATEMENT - GET ALL EXAMPLES
	 */
	
	public ArrayList<Example> getAllAlbumTitle() {
		ArrayList<Example> alList = new ArrayList<Example>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select ex.ex_id, ex.firstname, ex.lastname, al.title " +
					     "from example ex " +
					     "inner join track tr " +
					     "on ex.fave_song_id = tr.trackid " +
					     "inner join album al " +
					     "on tr.albumid = al.albumid";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String title = rs.getString(4);
				
				Example temp = new Example(id, fn, ln, title);
				alList.add(temp);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return alList;
}
	
	/*
	 * 8/24/2017 Class homework where we take in the id 
	 * to return the firstname and lastname of the person
	 * the id belongs to
	 */
	public String getPersonID(int id) {
		
		Connection connect = null;   //creates a connection
		CallableStatement cs = null; //creates a CallableStatement
		String personName = "";
		
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findPersonByID(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);       //use varchar for getting String return
			cs.setString(2, Integer.toString(id));                           //this is the 2nd ?
			cs.execute();
			personName = cs.getString(1);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cs.close();
				connect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return personName;
	}
}
