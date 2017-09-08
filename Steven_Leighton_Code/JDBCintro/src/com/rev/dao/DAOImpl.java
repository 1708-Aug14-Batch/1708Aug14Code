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

	/*
	 * Callable statement
	 */
	
	public int getID(String name){
		Connection conn = null;
		CallableStatement cs = null;
		int id = 0;
		
		try{
			conn = ConnectionFactory.getInstance().getConnection();
			cs = conn.prepareCall("{? = call findPerson(?)}");
			//set first ? to number (numeric) type
			cs.registerOutParameter(1, Types.NUMERIC);
			//set second ? to findPerson for variable name
			cs.setString(2, name);
			//execute
			cs.execute();
			
			//get back first out parameter
			id = cs.getInt(1);
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				
				//close connection/state
				cs.close();
				conn.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	public String getName(int num){
		Connection conn = null;
		CallableStatement cs = null;
		String name = "no one found";
		
		try{
			conn = ConnectionFactory.getInstance().getConnection();
			cs = conn.prepareCall("{? = call findPersonByID(?)}");
			//set first ? to number (numeric) type
			cs.registerOutParameter(1, Types.VARCHAR);
			//set second ? to findPerson for variable name
			cs.setInt(2, num);
			//execute
			cs.execute();
			
			//get back first out parameter
			name = cs.getString(1);
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				
				//close connection/statement
				cs.close();
				conn.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		return name;
	}
	
	/*
	 * prepared statements
	 */
	
	public int addExample(String fn, String ln){
		int id = -1;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			String sql = "insert into example (firstname, lastname) values (?,?)";
			
			//to get back primary key
			String[] key = new String[1];
			key[0] = "ex_id";
			
			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql,key);
			//set values into sql string ?'s
			ps.setString(1, fn);
			ps.setString(2, ln);
			
			//execute and get values
			int numRowsAdded = ps.executeUpdate();

			//results from keys
			ResultSet primaryKeys = ps.getGeneratedKeys();
			while(primaryKeys.next()){
				id = primaryKeys.getInt(1);
			}
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	/*
	 * Statements
	 */
	
	public ArrayList<Example> getAll(){
		ArrayList<Example> all = new ArrayList<Example>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from example";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString("lastname");
				//null values = 0
				int favSong = rs.getInt("favorite_song_id");
				
				Example temp = new Example(id,fn,ln,favSong);
				all.add(temp);
				
				//all.add(new Example(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return all;
	}
	
	/*
	 * Get all of example w/ name of favsong instead of id
	 */
	public void getAllWithSongName(){
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT ex.ex_id, "
					+ "ex.firstname,ex.lastname,tr.name"
					+ " FROM example ex"
					+ " LEFT JOIN track tr"
					+ " ON ex.favorite_song_id = tr.trackid";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String favSong = rs.getString(4);
				
				System.out.println("id: " + id +", firstname: "+fn+", lastname: "+ln+", favsongname: "+favSong );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}