package com.bank.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// A BankUser can have many acounts
// Only has access to their own data

// FIXME save password as a hash
// 		Same for Clerk
//		When validating, check saved password hash against supplied password hash

@Entity
@Table
public class BankUser extends Person {

	@Id
	@Column(name = "BANK_USER_ID")
	@SequenceGenerator(name = "BANK_USER_ID_SEQ", sequenceName = "BANK_USER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANK_USER_ID_SEQ")
	private int userId;

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(nullable = false)
	private final String username;

	@Column(nullable = false)
	private String password;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	public BankUser(Person person, String username,	String password) {
		super(person.getFirstName(), person.getLastName(), person.getEmail());
		
		this.person = person;
		this.username = username;
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "BankUser [userId=" + userId + ", username=" + username + ", password=" + password + ", person=" + person
				+ "]";
	}

}
