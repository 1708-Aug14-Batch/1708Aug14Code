package com.ex.beans;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "STUDENT")
public class Student {
	
	@Id
	@Column(name = "STUDENTID")
	@SequenceGenerator(name = "STUDENTID_SEQ",sequenceName = "STUDENTID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTID_SEQ")
	private int id;
	


	@Column(nullable = false)
	private String fn;
	@Column(nullable = false)
	private String ln;
	@Column(nullable = false, unique = true)
	private String email;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "TRANSCRIPT_ID")
	private Transcript t;
	
	
	public Student() {}
	
	public Student(int id, String fn, String ln, String email,Transcript t) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.t = t;
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

	public Transcript getT() {
		return t;
	}

	public void setT(Transcript t) {
		this.t = t;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fn=" + fn + ", ln=" + ln + ", email=" + email + "]";
	}
	
	
	
	
	
}
