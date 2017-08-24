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

public class DAOImpl implements DAO{

	public int getID(String name){
		Connection connect = null;
		CallableStatement cs = null;
		int id = 0;
		try{
			connect = ConnectionFactory
					.getInstance()
					.getConnection();

			cs = connect.prepareCall("{? = call findPerson(?) }");
			cs.registerOutParameter(1,  Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();
			id = cs.getInt(1);

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{cs.close();} catch(Exception e){e.printStackTrace();}
			try{connect.close();} catch(Exception e){e.printStackTrace();
			}

		}
		return id;
	}

	/*
	 * INTO example
  (
    firstname,
    lastname,
    fave_song_id
  )
  VALUES
  (
    'testing',
    'test',
    152
  );
	 */
	public int addExample(String fn, String ln){
		try(Connection connect = ConnectionFactory.getInstance().getConnection();)
		{
			// Step 1 in update methods, set autocommit to false
			connect.setAutoCommit(false);
			String sql = "insert into example"
					+ "(firstname, lastname) "
					+ "VALUES(?,?)";
			String[] keys = new String[1];
			keys[0] = "ex_id";
			PreparedStatement ps = connect.prepareStatement(sql, keys);
			ps.setString(1, fn);
			ps.setString(2, ln);

			int num = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
				System.out.println(id); //column number
			}

			connect.commit();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public ArrayList<Example> getAll(){
		ResultSet rs = null;
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "select * from example";
			Statement statement = connect.createStatement();
			rs = statement .executeQuery(s);

			// Extract data from resultset
			while(rs.next()){
				Example temp = new Example();
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString("lastname");
				int song = rs.getInt("fave_song_id");
				temp.setId(id);
				temp.setFn(fn);
				temp.setLn(ln);
				temp.setSong(song);

				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return list;
	}


}
