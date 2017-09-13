package com.bank.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	//user variables
	
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name = "USER_ID_SEQ", sequenceName="USER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ID_SEQ")
	private int id;
	
	@Column
	private String firstname;
	@Column
	private String lastname;
	
	@Column(nullable=false,unique=true)
	private String username;
	@Column
	private String password;
	
	//constructors
	public User() {
	}

	public User(int id, String firstname, String lastname, String username, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	
	public User(String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public List<String> getInfoAsStringList(){
		List<String> info = new ArrayList<String>();
		info.add(String.valueOf(id));
		info.add(firstname);
		info.add(lastname);
		info.add(username);
		info.add(password);
		
		return info;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + "]";
	}
	
}
