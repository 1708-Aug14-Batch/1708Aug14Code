package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bank_account")
public class BankAccount {
	
	@Id
	@Column(name="bank_account_id")
	@SequenceGenerator(name="bank_account_id_seq", sequenceName="bank_account_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bank_account_id_seq")
	private int bankAccountID;
	
	@Column(name="balance")
	private double balance;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bank_user_id")
	private int bankUserID;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="account_type_id")
	private int accountTypeID;

	public BankAccount(int bankAccountID, double balance, int bankUserID, int accountTypeID) {
		this.bankAccountID = bankAccountID;
		this.balance = balance;
		this.bankUserID = bankUserID;
		this.accountTypeID = accountTypeID;
	}

	public BankAccount() {}

	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getBankUserID() {
		return bankUserID;
	}

	public void setBankUserID(int bankUserID) {
		this.bankUserID = bankUserID;
	}

	public int getAccountTypeID() {
		return accountTypeID;
	}

	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	
	

}
