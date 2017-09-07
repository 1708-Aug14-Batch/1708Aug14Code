package com.reimb.dto;

import java.util.ArrayList;

import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;

/*public class DTO {
	private Users user;
	private ArrayList<Remibursment> reimbsPending;
	private ArrayList<Remibursment> reimbsResolve;
	
	public DTO(){}
	public DTO(Users user, ArrayList<Remibursment> reimbsPending, ArrayList<Remibursment> reimbsResolve){
		super();
		this.user=user;
		this.reimbsPending=reimbsPending;
		this.reimbsResolve=reimbsResolve;
	}
	
	public Users getUser(){
		return user;
	}
	
	public void setUser(Users user){
		this.user=user;
	}
	
	public ArrayList<Remibursment> getReimbPending(){
		return reimbsPending;
	}
	
	public void setReimbPending(ArrayList<Remibursment> reimbsPending){
		this.reimbsPending=reimbsPending;
	}
	
	public ArrayList<Remibursment> getReimbResolve(){
		return reimbsResolve;
	}
	
	public void setReimbResolve(ArrayList<Remibursment> reimbsResolve){
		this.reimbsResolve=reimbsResolve;
	}
}*/


public class DTO {
	private Users user;
	private ArrayList<Remibursment> reimbs;
	
	public DTO(){}
	public DTO(Users user, ArrayList<Remibursment> reimbs){
		super();
		this.user=user;
		this.reimbs=reimbs;
	}
	
	public Users getUser(){
		return user;
	}
	
	public void setUser(Users user){
		this.user=user;
	}
	
	public ArrayList<Remibursment> getReimb(){
		return reimbs;
	}
	
	public void setReimbPending(ArrayList<Remibursment> reimbs){
		this.reimbs=reimbs;
	}
}

