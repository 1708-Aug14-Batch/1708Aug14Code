package com.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name = "U_ID")
	@SequenceGenerator(name = "U_ID_SEQ",sequenceName = "U_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "U_ID_SEQ")
	private Long id;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	
	public User() {
		
	}
	public User(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
