package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.ConnectionFactory;

public class DAOReimbursement {

  public int createReimbursement(int submitid, String description, double amount, Timestamp date){
   
    try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
      conn.setAutoCommit(false);
     
      String sql = "insert into reimbursements (SUBMITTERID,"
          + "DESCRIPTION, AMOUNT, SUBMITDATE)"
          + "values(?, ?, ? , ?)";
      String[] key = new String[1];
      key[0] = "reimburseId";
      
      PreparedStatement ps = conn.prepareStatement(sql, key);
      ps.setInt(1, submitid);
      ps.setString(2, description); 
      ps.setDouble(3, amount);
      ps.setTimestamp(4,  date);
      
      ps.executeUpdate();
      int id = 0;
      ResultSet pk = ps.getGeneratedKeys();
      while (pk.next()) {
        id = pk.getInt(1);
      }
      conn.commit();
      return id;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }
  /**
   * Gets a single reimbursement case.
   * get single case by using primary key.
   * @return Return reimbursement
   */
  public   Reimbursement getReimbursementById(int id){

    Reimbursement singleCase = new Reimbursement();

    try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

      /*to only retrieve a single case what is the primary key in this case? "reimbursement id?*/
      String sql = "select * from reimbursements where REIMBURSEID =  ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet info = ps.executeQuery();

      while (info.next()) {
        singleCase.setReimburseId(info.getInt(1));
        singleCase.setSubmitterID(info.getInt(2));
        singleCase.setResolverID(info.getInt(3)); 
        singleCase.setSubmitDate(info.getTimestamp(4));
        singleCase.setResolvedDate(info.getTimestamp(5));
        singleCase.setStatusID(info.getInt(6));
        singleCase.setDescription(info.getString(7));
        singleCase.setResolvedNote(info.getString(8));
        singleCase.setAmount(info.getDouble(9));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return singleCase;
  }
  
/**
 * 
 * @param userID
 * @return returns all reimbursements for selected user.
 */
  public ArrayList<Reimbursement> getEmployeeReimbursements(int userID) {

    ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

    try(Connection conn = ConnectionFactory.getInstance().getConnection();){

      conn.setAutoCommit(false);
      String sql = "select * from reimbursements "
          + "where submitterID = ? order by submitdate desc";

      //setup prepared with sql and allocate space for key
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, userID);

      //execute and get values
      ResultSet rs = ps.executeQuery();

      while(rs.next()){
        Reimbursement u = new Reimbursement(rs.getInt("REIMBURSEID"), rs.getInt("SUBMITTERID"), rs.getInt("RESOLVERID"),
            rs.getTimestamp("SUBMITDATE"), rs.getTimestamp("RESOLVED"), rs.getInt("STATUSID"), rs.getString("DESCRIPTION"),
            rs.getString("RESOLVNOTES"), rs.getDouble("AMOUNT"));
        reimbursements.add(u);
      }
      conn.commit();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return reimbursements;
  }
  /** Only mangers can view all reimbursements for all users.
   * 
   * @return Returns all reimbursements for all users.
   */
  public ArrayList<Reimbursement> getAllEmployeeReimbursements(){

    ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

    try(Connection conn = ConnectionFactory.getInstance().getConnection();){

      conn.setAutoCommit(false);
      String sql = "select * from reimbursements "
          + "order by submitdate desc";

      //setup prepared with sql and allocate space for key
      PreparedStatement ps = conn.prepareStatement(sql);
      //ps.setInt(1, userID);

      //execute and get values
      ResultSet rs = ps.executeQuery();

      while(rs.next()){
        Reimbursement u = new Reimbursement(rs.getInt("REIMBURSEID"), rs.getInt("SUBMITTERID"), rs.getInt("RESOLVERID"),
            rs.getTimestamp("SUBMITDATE"), rs.getTimestamp("RESOLVED"), rs.getInt("STATUSID"), rs.getString("DESCRIPTION"),
            rs.getString("RESOLVNOTES"), rs.getDouble("AMOUNT"));
        reimbursements.add(u);
      }
      conn.commit();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return reimbursements;
  }
  
  
  
  
  public void resolveReimbursement(Reimbursement r) {
    // TODO Auto-generated method stub

  }



}
