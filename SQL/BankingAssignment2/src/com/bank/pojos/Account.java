package com.bank.pojos;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
		
	// Account id number is initialized when the account is created
	private final int accountId;
	
	// The date the account was opened
	private final Date accountOpenedDate;

	// BigDecimal: Immutable, arbitrary-precision signed decimal number
	private BigDecimal balance = BigDecimal.ZERO;
	
	// Marks whether an account was deleted
	// When a user deletes their account all of their information is persisted
	// The only change is that the account is marked as deleted and afterwards
	// can only be accessed by bank personel.
	private boolean deleted = false;
	
	private accountType type;
	
	private accountLevel level;
	
	// ID of associated user who owns this account
	private int userId;
	
	/*
	 * Account type determines interest rate for savings account and
	 * the percentage of rewards accrued per purchase, and the interest
	 * rate for a credit account
	 */
	public enum accountLevel {
		BRONZE,
		SILVER,
		GOLD,
		PLATINUM,
		DOUBLE_PLATINUM
	};
	public enum accountType {
		CHECKING,
		SAVINGS,
		CREDIT,
		REWARD
	}
	
	public Account(int accountId, Date accountOpenedDate, BigDecimal balance,
			boolean deleted, accountType type, accountLevel level, int userId) {
		super();
		this.accountId = accountId;
		this.accountOpenedDate = accountOpenedDate;
		this.balance = balance;
		this.deleted = deleted;
		this.type = type;
		this.level = level;
		this.userId = userId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public accountType getType() {
		return type;
	}
	public void setType(accountType type) {
		this.type = type;
	}
	public accountLevel getLevel() {
		return level;
	}
	public void setLevel(accountLevel level) {
		this.level = level;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getAccountOpenedDate() {
		return accountOpenedDate;
	}
	public int getAccountId() {
		return accountId;
	}
	@Override
	public String toString() {
		return "Account [accountOpenedDate=" + accountOpenedDate + ", accountId=" + accountId + ", balance=" + balance
				+ ", deleted=" + deleted + ", type=" + type + ", level=" + level + ", userId=" + userId + "]";
	}

}
