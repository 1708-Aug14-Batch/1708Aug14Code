package com.revature.model;

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
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="student_id")
	@SequenceGenerator(name="student_id_seq", sequenceName="student_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_id_seq")
	private int studentID;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email", nullable = false, unique = true)
	private String email;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transcript_id")
	private Transcript transcript;
	
	public Student() {}
	
	public Student(int studentID, String firstName, String lastName, String email, Transcript transcript) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.transcript = transcript;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
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

	public Transcript getTranscript() {
		return transcript;
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

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	
}
