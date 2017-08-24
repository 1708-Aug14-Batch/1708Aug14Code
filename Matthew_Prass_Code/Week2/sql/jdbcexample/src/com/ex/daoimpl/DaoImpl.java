package com.ex.daoimpl;

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

public class DaoImpl {

	//callable statement
	public int getID(String name)
	{
		Connection conn  = null;
		CallableStatement cs = null;
		int id = 0;
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findPerson(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();
			id =cs.getInt(1);
		}
		catch(SQLException e)
		{
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
	
	//get name from id
	public String getName(int id)
	{
		Connection conn = null;
		CallableStatement cs = null;
		String name = "";
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findName(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			name = cs.getString(1);
		}
		catch(Exception e)
		{
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
		return name;
	}
	
	//prepared statement
	public int addExample(String fn,String ln)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			conn.setAutoCommit(false);
			String sql = "insert into example " + "(firstname,lastname) " + 
					"values(?, ?)";
			String[] keys = new String[1];
			keys[0] = "ex_id";
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1, fn);
			ps.setString(2, ln);
			
			int numRows = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next())
			{
				id = pk.getInt(1);
			}
			
			conn.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//statement
	public ArrayList<Example> getAll()
	{
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select ex.ex_id,ex.firstname,ex.lastname,tr.name\r\n" + 
					"from example ex\r\n" + 
					"left join track tr\r\n" + 
					"on ex.fave_song_id = tr.trackid";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString("lastname");
				String song = rs.getString(4);
				
				Example ex = new Example(id, firstname, lastname, song);
				
				list.add(ex);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
}
