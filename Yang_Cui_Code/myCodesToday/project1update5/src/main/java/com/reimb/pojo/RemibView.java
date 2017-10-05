package com.reimb.pojo;

import java.sql.Timestamp;

public class RemibView {
	private String remibID;
	private String sender;
	private String resolver;
	private String stat;
	private String sumbitDate;
	private String resolveDate;
	private String description;
	private String note;
	private String amount;
	
	public RemibView(String remibID, String sender, String resolver, String stat, String sumbitDate, String resolveDate, String description, String note, String amount) {
		super();
		this.remibID = remibID;
		this.sender = sender;
		this.resolver = resolver;
		this.stat = stat;
		this.sumbitDate = sumbitDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.note = note;
		this.amount = amount;
	}
	
	public RemibView(){
		
	}

	public String getRemibID() {
		return remibID;
	}

	public void setRemibID(String remibID) {
		this.remibID = remibID;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getSumbitDate() {
		return sumbitDate;
	}

	public void setSumbitDate(String sumbitDate) {
		this.sumbitDate = sumbitDate;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
