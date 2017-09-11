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
	
	// callable statement assignment
	public String getPerson(int id) {
		Connection connect = null;
		CallableStatement cs = null;
		String person = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {	
			String sql = "{? = call findPerson(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			person = cs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
	
	
	// callable statement
	public int getID(String name) {
		Connection connect = null;
		CallableStatement cs = null;
		int id = 0;
		
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findID(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();
			id = cs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cs.close();
				connect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	// prepared statement
	public int addExample(String fn, String ln) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "insert into example (firstname, lastname) values (?, ?)";
			String[] key = new String[1];
			key[0] = "ex_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			
			ps.executeUpdate();  // could be int numRowsAdded = ps.executeUpdate();
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
		return -1;
	}
	
	//Statement - get all examples
	public ArrayList<Example> getAll() {
		ArrayList<Example> list = new ArrayList();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from example";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString("firstname");
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

	//Statement - get fave songs
	public ArrayList<Example> getFaveSongs() {
		ArrayList<Example> list = new ArrayList();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT ex.ex_id, ex.firstname, ex.lastname, tr.name FROM example ex LEFT JOIN track tr ON ex.fave_song_id = tr.trackid";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString("firstname");
				String ln = rs.getString("lastname");
				String favSong = rs.getString(4);
				
				Example temp = new Example(id, fn, ln, favSong);
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}













