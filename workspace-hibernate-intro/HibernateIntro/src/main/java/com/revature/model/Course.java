package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@Column(name="course_id")
	@SequenceGenerator(name="course_id_seq", sequenceName="course_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_id_seq")
	private int courseID;
	
	@Column(name="course_name")
	private String courseName;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="instructor")
	private Instructor instructor;
	
	@Column(name="description")
	private String description;
	
	public Course(int courseID, String courseName, Instructor instructor, String description) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.instructor = instructor;
		this.description = description;
	}
	
	public int getCourseID() {
		return courseID;
	}
	
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	

}
