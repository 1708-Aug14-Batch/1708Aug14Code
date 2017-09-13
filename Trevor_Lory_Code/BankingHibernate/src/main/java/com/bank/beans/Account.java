package com.bank.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
public class Account {

	@Id
	@Column(name="ACCOUNTID")
	@SequenceGenerator(name="ACCOUNTID_SEQ", sequenceName="ACCOUNTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNTID_SEQ")
	private int ACCOUNTID; //Primary Key
	
	@Column(name="BALANCE", nullable=false)
	private double BALANCE; //default 0.0
	@Column(name="NAME", nullable=false)
	private String NAME; //not null
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USERID", nullable=false)
	private User USERID; //not null FK -> AccountTypes userid
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TYPEID", nullable=false)
	private AccountType TYPEID; //not null FK -> Users typeid
	
	public Account() {}

	public Account(int aCCOUNTID, double bALANCE, String nAME, User uSERID, AccountType tYPEID) {
		super();
		ACCOUNTID = aCCOUNTID;
		BALANCE = bALANCE;
		NAME = nAME;
		USERID = uSERID;
		TYPEID = tYPEID;
	}

	public int getACCOUNTID() {
		return ACCOUNTID;
	}

	public void setACCOUNTID(int aCCOUNTID) {
		ACCOUNTID = aCCOUNTID;
	}

	public double getBALANCE() {
		return BALANCE;
	}

	public void setBALANCE(double bALANCE) {
		BALANCE = bALANCE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public User getUSERID() {
		return USERID;
	}

	public void setUSERID(User uSERID) {
		USERID = uSERID;
	}

	public AccountType getTYPEID() {
		return TYPEID;
	}

	public void setTYPEID(AccountType tYPEID) {
		TYPEID = tYPEID;
	}

	@Override
	public String toString() {
		return "Account [ACCOUNTID=" + ACCOUNTID + ", BALANCE=" + BALANCE + ", NAME=" + NAME + ", USERID=" + USERID
				+ ", TYPEID=" + TYPEID + "]";
	}
	
}
