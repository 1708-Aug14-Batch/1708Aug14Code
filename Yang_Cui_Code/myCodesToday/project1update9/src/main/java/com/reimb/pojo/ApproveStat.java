package com.reimb.pojo;

public class ApproveStat {
	private int statID;
	private String state;
	
	public ApproveStat(int statID, String state){
		this.statID=statID;
		this.state=state;
	}
	
	public ApproveStat(){
		
	}
	
	public int getID(){
		return statID;
	}
	
	public void setID(int statID){
		this.statID=statID;
	}
	
	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state=state;
	}
}
