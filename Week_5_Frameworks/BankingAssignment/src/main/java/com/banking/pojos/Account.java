package com.banking.pojos;

import javax.persistence.*;

@Entity
@Table(name= "ACCOUNT")
public class Account {

	@Id
	@Column(name = "ACCT_ID")
	@SequenceGenerator(name = "SEQ_ACCT_ID", sequenceName = "SEQ_ACCT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCT_ID")
	private int id;
	
	@Column
	private int balance;
	

	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.REMOVE)
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private AccountType type;
	
	@Column
	private String status;

	public Account() {}

	public Account(int id, int balance, User user, AccountType type, String status) {
		super();
		this.id = id;
		this.balance = balance;
		this.user = user;
		this.type = type;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	};

	
	
}
