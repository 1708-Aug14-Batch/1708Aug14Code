package com.ex.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@Column(name="U_ID")
	@SequenceGenerator(name="U_ID_SEQ",sequenceName="U_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="U_ID_SEQ")
	private Long id;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	private String username;
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
}
