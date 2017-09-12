package com.reimb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.reimb.pojo.ApproveStat;
import com.reimb.pojo.RemibView;
import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;
import com.reimb.util.ConnectionFactory;

public class DAOImpl implements DAO{

	@Override
	public Users getUser(int userID) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from Users where userID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				String fn=rs.getString(2);
				String ln=rs.getString(3);
				String un=rs.getNString(4);
				String email=rs.getNString(5);
				String pwd=rs.getNString(6);
				String manange=rs.getNString(7);

				boolean isMana;
				if(manange.equals("y"))
					isMana=true;
				else
					isMana=false;
				Users user = new Users(userID,fn,ln,un,email,pwd,isMana);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int getUserID(String userName){
		System.out.println("in getUserID(userName)");
		int userID=-1;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println("connected to db");
			String sql="select userID from Users where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				userID=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("returned= "+userID);
		return userID;
	}

	@Override
	public Remibursment getRemib(int remibID) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from Reimbursment where reimID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, remibID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				int sID=rs.getInt(2);
				int rID=rs.getInt(3);
				Timestamp sDate=rs.getTimestamp(4);
				Timestamp rDate=rs.getTimestamp(5);
				int statID=rs.getInt(6);
				String describ=rs.getString(7);
				String note=rs.getString(8);
				double amount=rs.getDouble(9);
				
				Remibursment remib=new Remibursment(remibID,getUser(sID),getUser(rID),getStatus(statID),sDate,rDate,describ,note,amount);
				return remib;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Remibursment> getAllRemib() {
		ArrayList<Remibursment> remibs= new ArrayList<Remibursment>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from Reimbursment";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int remibID=rs.getInt(1);
				int sID=rs.getInt(2);
				int rID=rs.getInt(3);
				Timestamp sDate=rs.getTimestamp(4);
				Timestamp rDate=rs.getTimestamp(5);
				int statID=rs.getInt(6);
				String describ=rs.getString(7);
				String note=rs.getString(8);
				double amount=rs.getDouble(9);
				
				remibs.add(new Remibursment(remibID,getUser(sID),getUser(rID),getStatus(statID),sDate,rDate,describ,note,amount));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return remibs;
	}

	@Override
	public ApproveStat getStatus(int statID) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from Status where statusID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				int stID=rs.getInt(1);
				String state=rs.getString(2);
				
				ApproveStat stat=new ApproveStat(stID,state);
				return stat;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Users> getAllUser() {
		ArrayList<Users> allUser = new ArrayList<Users>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from Users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt(1);
				String fn=rs.getString(2);
				String ln=rs.getString(3);
				String un=rs.getNString(4);
				String email=rs.getNString(5);
				String pwd=rs.getNString(6);
				String manange=rs.getNString(7);

				boolean isMana;
				if(manange.equals("y"))
					isMana=true;
				else
					isMana=false;
				allUser.add(new Users(id,fn,ln,un,email,pwd,isMana));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUser;
	}

	@Override
	public ArrayList<Remibursment> getStatRemib(int statID) {
		ArrayList<Remibursment> statRemib=new ArrayList<Remibursment>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from Reimbursment where statusID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				int remibID=rs.getInt(1);
				int sID=rs.getInt(2);
				int rID=rs.getInt(3);
				Timestamp sDate=rs.getTimestamp(4);
				Timestamp rDate=rs.getTimestamp(5);
				//int statID=rs.getInt(6);
				String describ=rs.getString(7);
				String note=rs.getString(8);
				double amount=rs.getDouble(9);
				
				statRemib.add(new Remibursment(remibID,getUser(sID),getUser(rID),getStatus(statID),sDate,rDate,describ,note,amount));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return statRemib;
	}

	
	@Override
	public int submitRemib(Remibursment reimb) {
		System.out.println(reimb.getSender().getID());
		System.out.println(reimb.getResolver());
		System.out.println(reimb.getSumbitDate());
		System.out.println(reimb.getResolveDate());
		System.out.println(reimb.getStatus().getID());
		System.out.println(reimb.getDescription());
		System.out.println(reimb.getNote());
		System.out.println(reimb.getAmount());
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql="insert into Reimbursment (submitID, submitDate, statusID, description, amount) values (?,?,?,?,?)";
			String[] key= new String[1];
			key[0]="reimid";
			PreparedStatement ps= conn.prepareStatement(sql, key);
			ps.setInt(1, reimb.getSender().getID());
			ps.setTimestamp(2, reimb.getSumbitDate());
			ps.setInt(3, reimb.getStatus().getID());
			ps.setString(4, reimb.getDescription());
			ps.setDouble(5, reimb.getAmount());
			ps.executeUpdate();
			int id=0;
			ResultSet pk =ps.getGeneratedKeys();
			while(pk.next()){
				id=pk.getInt(1);
			}
			conn.commit();
			return id;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 	@Override
	public int submitRemib(Remibursment reimb) {
		System.out.println(reimb.getSender().getID());
		System.out.println(reimb.getResolver());
		System.out.println(reimb.getSumbitDate());
		System.out.println(reimb.getResolveDate());
		System.out.println(reimb.getStatus().getID());
		System.out.println(reimb.getDescription());
		System.out.println(reimb.getNote());
		System.out.println(reimb.getAmount());
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql="insert into Reimbursment (submitID, resolveID, submitDate, resolveDate, statusID, description, resolveNote, amount) values (?,?,?,?,?,?,?,?)";
			String[] key= new String[1];
			key[0]="reimid";
			PreparedStatement ps= conn.prepareStatement(sql, key);
			ps.setInt(1, reimb.getSender().getID());
			//ps.setInt(2, (Integer) null);
			ps.setNull(2, java.sql.Types.INTEGER);
			ps.setTimestamp(3, reimb.getSumbitDate());
			ps.setTimestamp(4, null);
			ps.setInt(5, reimb.getStatus().getID());
			ps.setString(6, reimb.getDescription());
			ps.setString(7, null);
			ps.setDouble(7, reimb.getAmount());
			ps.executeUpdate();
			int id=0;
			ResultSet pk =ps.getGeneratedKeys();
			while(pk.next()){
				id=pk.getInt(1);
			}
			conn.commit();
			return id;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}(non-Javadoc)
	 * @see com.reimb.dao.DAO#resolveRemib(com.reimb.pojo.Remibursment)
	 */
	@Override
	public int resolveRemib(Remibursment reimb) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql="update Reimbursment set approveID=?, approveDate=?, statusID=?, resolveNote=? where reimID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimb.getResolver().getID());
			ps.setTimestamp(2, reimb.getResolveDate());
			ps.setInt(3, reimb.getStatus().getID());
			ps.setString(4, reimb.getNote());
			ps.setInt(5, reimb.getID());
			ps.executeUpdate();
			int id=reimb.getID();
			conn.commit();
			return id;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int addUser(Users user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql="insert into Users (firstname, lastname, username, email, password, isManager) values(?,?,?,?,?,?)";
			String[] key= new String[1];
			key[0]="userid";
			PreparedStatement ps= conn.prepareStatement(sql, key);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			
			String mananger;
			if(user.getIsMananger())
				mananger="y";
			else
				mananger="n";
			ps.setString(6, mananger);
			
			return user.getID();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public ArrayList<Remibursment> getUserRemib(int userID) {
		ArrayList<Remibursment> remibs= new ArrayList<Remibursment>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from Reimbursment where submitID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int remibID=rs.getInt(1);
				int sID=rs.getInt(2);
				int rID=-1;
					if(rs.getString(3)==null)
						rID=-1;
					else
						rID=rs.getInt(3);
				System.out.println(rs.getString(3));
				System.out.println(rID);
				Timestamp sDate=rs.getTimestamp(4);
				Timestamp rDate=rs.getTimestamp(5);
				int statID=rs.getInt(6);
				String describ=rs.getString(7);
				String note=rs.getString(8);
				double amount=rs.getDouble(9);
				
				if(rID<0)
					remibs.add(new Remibursment(remibID,getUser(sID),null,getStatus(statID),sDate,rDate,describ,note,amount));
				else
					remibs.add(new Remibursment(remibID,getUser(sID),getUser(rID),getStatus(statID),sDate,rDate,describ,note,amount));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return remibs;
	}

	@Override
	public ArrayList<RemibView> getUserReimbView(ArrayList<Remibursment> remib) {
		// TODO Auto-generated method stub
		ArrayList<RemibView> rv=new ArrayList<RemibView>();
		String remibID;
		String sender;
		String resolver;
		String stat;
		String sumbitDate;
		String resolveDate;
		String description;
		String note;
		String amount;
		for(Remibursment eachRemib : remib){
			remibID=String.valueOf(eachRemib.getID());
			sender=String.valueOf(eachRemib.getSender().getFirstName()+eachRemib.getSender().getID());
			
			if(eachRemib.getResolver()==null)
				resolver="N/A";
			else
				resolver=String.valueOf(eachRemib.getResolver().getFirstName()+eachRemib.getResolver().getID());
			if(eachRemib.getStatus().getState()==null)
				stat="N/A";
			else
				stat=String.valueOf(eachRemib.getStatus().getState());
			
			sumbitDate=String.valueOf(eachRemib.getSumbitDate());
			
			if(eachRemib.getResolveDate()==null)
				resolveDate="N/A";
			else
				resolveDate=String.valueOf(eachRemib.getResolveDate());
			
			description=String.valueOf(eachRemib.getDescription());
			
			if(eachRemib.getNote()==null)
				note="N/A";
			else
				note=String.valueOf(eachRemib.getNote());
			
			amount=String.valueOf(eachRemib.getAmount());
			rv.add(new RemibView(remibID, sender, resolver, stat, sumbitDate, resolveDate, description, note, amount));
		}
		return rv;
	}
}
