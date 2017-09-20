package com.banking.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	
	@Id
	@Column(name = "User_ID")
	@SequenceGenerator(name = "SEQ_USER_ID", sequenceName = "SEQ_USER_ID")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "SEQ_USER_ID")
	int id; 
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	String firstname;
	@Column
	String lastname;
	@Column
	String email;
	@Column
	String password;
	
	
	public User() {};
	public User(int id, String firstname, String lastname, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
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
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password
				+ "]";
	}
	
}
