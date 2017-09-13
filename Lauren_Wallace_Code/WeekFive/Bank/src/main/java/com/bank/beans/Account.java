package com.bank.beans;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Account {
	
	@Id
	@Column(name="ACCOUNTID")
	@SequenceGenerator(name="ACCOUNTID_SEQ", sequenceName="ACCOUNTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNTID_SEQ")
	private int id;
	
	@Column(nullable = true)
	private double balance;
	
	@Column(nullable = false)
	private int uid;
	
	@Column(nullable = false)
	private int tid;
	
	@Column(nullable = true)
	private Timestamp closedOn;
	
	//MANY TO ONE
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn
	private User u;
	
	//MANY TO ONE
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn
	private AccountType acctype;
	
	public Account() {}

	public Account(int id, double balance, int uid, int tid, Timestamp closedOn) {
		super();
		this.id = id;
		this.balance = balance;
		this.uid = uid;
		this.tid = tid;
		this.closedOn = closedOn;
	}

	public Account(int id, double balance, int uid, int tid, Timestamp closedOn, User u) {
		super();
		this.id = id;
		this.balance = balance;
		this.uid = uid;
		this.tid = tid;
		this.closedOn = closedOn;
		this.u = u;
	}

	public Account(int id, double balance, int uid, int tid, Timestamp closedOn, User u, AccountType acctype) {
		super();
		this.id = id;
		this.balance = balance;
		this.uid = uid;
		this.tid = tid;
		this.closedOn = closedOn;
		this.u = u;
		this.acctype = acctype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Timestamp getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(Timestamp closedOn) {
		this.closedOn = closedOn;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public AccountType getAcctype() {
		return acctype;
	}

	public void setAcctype(AccountType acctype) {
		this.acctype = acctype;
	}
	
}
