package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@Column(name="instructor_id")
	@SequenceGenerator(name="instructor_id_seq", sequenceName="instructor_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instructor_id_seq")
	private int instructorID;
	
	@Column(name="instructor_name")
	private String instructorName;
	
	public Instructor(int instructorID, String instructorName) {
		super();
		this.instructorID = instructorID;
		this.instructorName = instructorName;
	}
	
	public Instructor() {
		// TODO Auto-generated constructor stub
	}

	public int getInstructorID() {
		return instructorID;
	}
	
	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}
	
	public String getInstructorName() {
		return instructorName;
	}
	
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	

}
