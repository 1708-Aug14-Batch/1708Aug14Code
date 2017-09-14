package com.revature.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import com.revature.dao.DAO;
import com.revature.dao.DAOReimbursement;
import com.revature.dao.DAOUser;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class Service {
  static DAO myDao = new DAOUser();
  DAOReimbursement daoRem = new DAOReimbursement();   

  public int validateUser(String email){
    int id = 0;
    HashMap<Integer, String> users = myDao.getEmails();

    for(Integer n:users.keySet()){
      if(users.get(n).equalsIgnoreCase(email)){
        id = n;
      }
    }

    return id;
  }

  public User login(int id, String pass){
    User u = myDao.getUserById(id);
    if(u.getPassword().equalsIgnoreCase(pass)){
      return u;
    }
    else return null;
  }

  public User addUser(User u){
    int id = myDao.addUser(u.getFirstName(), u.getLastNAme(), u.getEmail(), u.getPassword());
    u.setUserId(id);
    return u;
  }
  public User getUser(int id) {
    User user = myDao.getUserById(id);
    return user;
  }


  public Reimbursement addReimbursment(Reimbursement r){

    daoRem.createReimbursement(r.getSubmitterID(),
        r.getDescription(),r.getAmount(),r.getSubmitDate());
    // r.setReimburseId(id);

    return r;
  }

  /** returns all reimbursements for user by id*/;
  public ArrayList<Reimbursement> getUserRemibursements(User u){

    return daoRem.getEmployeeReimbursements(u.getUserId());
  }
  /** handles single reimbursements*/
  public Reimbursement getReimbursement(int id){
    return daoRem.getReimbursementById(id);
  }
  /** used only for management purposes*/
  public void resolveReimbursement(Reimbursement r){
    daoRem.resolveReimbursement(r);
  }




}


