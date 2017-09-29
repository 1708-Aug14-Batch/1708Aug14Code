package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bank_user")
public class BankUser implements Serializable {
	
	private static final long serialVersionUID = 2001777075542887341L;

	@Id
	@Column(name="bank_user_id")
	@SequenceGenerator(name="bank_user_id_seq", sequenceName="bank_user_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bank_user_id_seq")
	private int bankUserID;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="has_checking")
	private boolean hasChecking;

	@Column(name="has_savings")
	private boolean hasSavings;

	@Column(name="has_credit")
	private boolean hasCredit;

	@Column(name="enabled")
	private boolean enabled;

	public BankUser() {}

	public BankUser(int bankUserID, String firstName, String lastName, String email, String password,
			boolean hasChecking, boolean hasSavings, boolean hasCredit, boolean enabled) {
		this.bankUserID = bankUserID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.hasChecking = hasChecking;
		this.hasSavings = hasSavings;
		this.hasCredit = hasCredit;
		this.enabled = enabled;
	}

	public int getBankUserID() {
		return bankUserID;
	}

	public void setBankUserID(int bankUserID) {
		this.bankUserID = bankUserID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isHasChecking() {
		return hasChecking;
	}

	public void setHasChecking(boolean hasChecking) {
		this.hasChecking = hasChecking;
	}

	public boolean isHasSavings() {
		return hasSavings;
	}

	public void setHasSavings(boolean hasSavings) {
		this.hasSavings = hasSavings;
	}

	public boolean isHasCredit() {
		return hasCredit;
	}

	public void setHasCredit(boolean hasCredit) {
		this.hasCredit = hasCredit;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
