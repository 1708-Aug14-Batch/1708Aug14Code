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
@Table(name="USERS")
public class User implements Serializable {

	
	@Id
	@Column(name="U_ID")
	@SequenceGenerator(name="U_ID_SEQ",sequenceName="U_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="U_ID_SEQ")
	private int id;
	
	@Column(name="FIRSTNAME", nullable=false)
	private String firstname;
	@Column(name="LASTNAME", nullable=false)
	private String lastname;
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	public User(){}

	public User(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
}
