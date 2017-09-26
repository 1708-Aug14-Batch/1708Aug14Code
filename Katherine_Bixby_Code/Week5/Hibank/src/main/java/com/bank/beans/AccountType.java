package com.bank.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
public class AccountType implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="typeSeq")
	@SequenceGenerator(allocationSize=1,name="typeSeq", sequenceName="TYPE_SEQ")
	@Column(name="TYPE_ID")
	private int id;
	
	@Column
	private String type;
	
	public AccountType(){}
	
	public AccountType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AccountType [id=" + id + ", type=" + type + "]";
	}
	
	

	
}