package com.reimb.pojo;

import java.sql.Timestamp;

public class Remibursment {
	private int remibID;
	private Users sender;
	private Users resolver;
	private ApproveStat stat;
	private Timestamp sumbitDate;
	private Timestamp resolveDate;
	private String description;
	private String note;
	private double amount;
	
	public Remibursment(int remibID, Users sender, Users resolver, ApproveStat stat, Timestamp sumbitDate, Timestamp resolveDate, String description, String note, double amount){
		this.remibID=remibID;
		this.sender=sender;
		this.resolver=resolver;
		this.stat=stat;
		this.sumbitDate=sumbitDate;
		this.resolveDate=resolveDate;
		this.description=description;
		this.note=note;
		this.amount=amount;
	}
	
	public Remibursment(){
		
	}
	
	public int getID(){
		return remibID;
	}
	
	public void setID(int remibID){
		this.remibID=remibID;
	}
	
	public Users getSender(){
		return sender;
	}
	
	public void setSender(Users sender){
		this.sender=sender;
	}
	
	public Users getResolver(){
		return resolver;
	}
	
	public void setResolver(Users resolver){
		this.resolver=resolver;
	}
	
	public ApproveStat getStatus(){
		return stat;
	}
	
	public void setStatus(ApproveStat stat){
		this.stat=stat;
	}
	
	public Timestamp getSumbitDate(){
		return sumbitDate;
	}
	
	public void setSumbitDate(Timestamp sumbitDate){
		this.sumbitDate=sumbitDate;
	}
	
	public Timestamp getResolveDate(){
		return resolveDate;
	}
	
	public void setResolveDate(Timestamp resolveDate){
		this.resolveDate=resolveDate;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public String getNote(){
		return note;
	}
	
	public void setNote(String note){
		this.note=note;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public void setAmount(double amount){
		this.amount=amount;
	}
}
