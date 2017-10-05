package com.reimb.dto;

import java.util.ArrayList;

import com.reimb.pojo.RemibView;
import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;


public class DTO {
	private Users user;
	private ArrayList<Remibursment> reimbs;
	private ArrayList<RemibView> rv;
	
	public DTO(){}
	public DTO(Users user, ArrayList<Remibursment> reimbs, ArrayList<RemibView> rv){
		super();
		this.user=user;
		this.reimbs=reimbs;
		this.rv=rv;
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
	
	public ArrayList<RemibView> getRV(){
		return rv;
	}
	
	public void setRV(ArrayList<RemibView> rv){
		this.rv=rv;
	}
}

