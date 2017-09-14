package com.revature.dto;

import java.util.ArrayList;

import com.revature.model.Reimbursement;
//import java.util.ArrayList;
import com.revature.model.User;
//import com.revature.model.Reimbursement;

public class DTO {

  private User user;
 private ArrayList<Reimbursement> rem;

  public DTO(){}

  public DTO(User user, ArrayList<Reimbursement> rem) {
   super();
    this.user = user;
  this.rem = rem;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public ArrayList<Reimbursement> getReimbursement() {
    return rem;
  }

  public void setReimbursement(ArrayList<Reimbursement> rem) {
    this.rem = rem;
  }



}

