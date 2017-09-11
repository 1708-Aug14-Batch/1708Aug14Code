package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
	
	@Id
	@Column(name = "STUDENTID")
	@SequenceGenerator(name = "STUDENTID_SEQ",sequenceName = "STUDENTID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTID_SEQ")
	private int id;
	
	@Column
	private String fn;
	@Column
	private String ln;
	@Column
	private String email;
	
	public Student() {}
	
	public Student(int id, String fn, String ln, String email) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fn=" + fn + ", ln=" + ln + ", email=" + email + "]";
	}
	
	
	
	
	
}
