package com.reimb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.reimb.pojo.ApproveStat;
import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;
import com.reimb.util.ConnectionFactory;

public class DAOImpl implements DAO{

	public Users getUser(int userID) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Remibursment getRemib(int remibID) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ApproveStat getStatus(int statID) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from Status where statID=?";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
