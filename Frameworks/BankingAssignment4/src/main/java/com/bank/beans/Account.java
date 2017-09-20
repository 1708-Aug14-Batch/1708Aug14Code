package com.bank.beans;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
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
@Table
public class Account {

	@Id
	@Column(name = "ACCOUNT_ID")
	@SequenceGenerator(name = "ACCOUNT_ID_SEQ", sequenceName = "ACCOUNT_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ID_SEQ")
	private int accountId;

	// The date the account was opened
	@Column(nullable = false)
	private final LocalDate accountOpenedDate;

	// BigDecimal: Immutable, arbitrary-precision signed decimal number
	@Column
	private BigDecimal balance = BigDecimal.ZERO;

	// Marks whether an account was deleted
	// When a user deletes their account all of their information is persisted
	// The only change is that the account is marked as deleted and afterwards
	// can only be accessed by bank personel.
	@Column
	private boolean deleted = false;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private AccountType type;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private AccountLevel level;

	// ID of associated user who owns this account
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn
	private BankUser bankUser;

	public static final Map<AccountType, Double> rewardsRateMap = new TreeMap<AccountType, Double>();
	public static final Map<AccountType, Double> savingsRateMap = new TreeMap<AccountType, Double>();
	public static final Map<AccountType, Double> creditRateMap = new TreeMap<AccountType, Double>();

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	// Initialization block
	static {
		AccountType bronze = new AccountType("BRONZE");
		AccountType silver = new AccountType("SILVER");
		AccountType gold = new AccountType("GOLD");
		AccountType platinum = new AccountType("PLATINUM");
		AccountType doublePlatinum = new AccountType("DOUBLE_PLATINUM");

		rewardsRateMap.put(bronze, (double) 1 / 100);
		rewardsRateMap.put(silver, (double) 2 / 100);
		rewardsRateMap.put(gold, (double) 3 / 100);
		rewardsRateMap.put(platinum, (double) 5 / 100);
		rewardsRateMap.put(doublePlatinum, (double) 10 / 100);

		savingsRateMap.put(bronze, (double) 3 / 100);
		savingsRateMap.put(silver, (double) 4 / 100);
		savingsRateMap.put(gold, (double) 5 / 100);
		savingsRateMap.put(platinum, (double) 6 / 100);
		savingsRateMap.put(doublePlatinum, (double) 8 / 100);

		creditRateMap.put(bronze, (double) 25 / 100);
		creditRateMap.put(silver, (double) 23 / 100);
		creditRateMap.put(gold, (double) 20 / 100);
		creditRateMap.put(platinum, (double) 17 / 100);
		creditRateMap.put(doublePlatinum, (double) 12 / 100);

	}

	public Account(BankUser bankUser, LocalDate accountOpenedDate, BigDecimal balance, boolean deleted,
			AccountType type, AccountLevel level) {
		super();

		this.bankUser = bankUser;
		this.accountOpenedDate = accountOpenedDate;
		this.balance = balance;
		this.deleted = deleted;
		this.type = type;
		this.level = level;
	}

	public Account(BankUser bankUser, AccountType type, AccountLevel level) {
		super();

		this.bankUser = bankUser;
		this.accountOpenedDate = LocalDate.now();
		this.balance = new BigDecimal(0);
		this.deleted = false;
		this.type = type;
		this.level = level;
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

	public AccountType getType() {
		return type;
	}

	public boolean setType(AccountType type) {
		this.type = type;
		return true;
	}

	public AccountLevel getLevel() {
		return level;
	}

	public boolean setLevel(AccountLevel level) {
		this.level = level;
		return true;
	}

	public BankUser getBankUser() {
		return bankUser;
	}

	public void setBankUser(BankUser bankUser) {
		this.bankUser = bankUser;
	}

	public LocalDate getAccountOpenedDate() {
		return accountOpenedDate;
	}

	public int getAccountId() {
		return accountId;
	}

	public double getCreditRate() {
		return creditRateMap.get(level);
	}

	public double getRewardsRate() {
		return rewardsRateMap.get(level);
	}

	public double getSavingsRate() {
		return savingsRateMap.get(level);
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountOpenedDate=" + accountOpenedDate + ", balance=" + balance
				+ ", deleted=" + deleted + ", type=" + type + ", level=" + level + ", bankUser=" + bankUser + "]";
	}

}
