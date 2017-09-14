package com.bankhib.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Account {
	@Id
	@Column(name="ACCTID")
	@SequenceGenerator(name="USERID_SEQ", sequenceName="ACCTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCTID_SEQ")
	private int acctid;
	
	private int typeid;
	
	@Column
	private double balance;
	
	private int userid;
	
	public Account() {}
	
	public Account(int acctid, int typeid, double balance, int userid) {
		super();
		this.acctid = acctid;
		this.typeid = typeid;
		this.balance = balance;
		this.userid = userid;
	}

	public int getAcctid() {
		return acctid;
	}

	public void setAcctid(int acctid) {
		this.acctid = acctid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Account [acctid=" + acctid + ", typeid=" + typeid + ", balance=" + balance + ", userid=" + userid + "]";
	}

}
