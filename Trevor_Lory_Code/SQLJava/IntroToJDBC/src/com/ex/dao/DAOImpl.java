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
		Connection conn = null;
		CallableStatement cs = null;
		int id = 0;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findPerson(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();
			id = cs.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cs.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	//HomeWork Part 1 - Getting First and Last names via id
	public String getName(int id) {
		String s = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{? = call findName(?)}";
			CallableStatement cs = null;
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			s = cs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/*
	 * Prepared Statement
	 */
	public int addExample(String fn, String ln) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into example (firstname, lastname) " + 
						 "values (?, ?)";
			String[] key = new String[1];
			key[0] = "ex_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			int numRowsAdded = ps.executeUpdate();
			int id  = 0;
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
	
	/*
	 * Statement - get all examples
	 */
	public ArrayList<Example> getAll() {
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from example";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString("lastname"); //can do this as well
				int song = rs.getInt(4);
				Example temp = new Example(id, fn, ln, song);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//HomeWork Part 2 - Get all examples with their songs titles
	public ArrayList<Example> getAllWithTitle() {
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select example.ex_id, example.firstname, example.lastname, track.name from example left join track on track.trackid = example.fave_song_id";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString("lastname"); //can do this as well
				String title = rs.getString(4);
				Example temp = new Example(id, fn, ln, title);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
