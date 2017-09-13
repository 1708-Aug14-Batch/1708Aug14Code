package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="COURSES")
public class Course {
	
	@Id
	@Column(name="COURSE_ID")
	@SequenceGenerator(name="COURSE_ID_SEQ", sequenceName="COURSE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSE_ID_SEQ")
	private int id;
	
	@Column(name="COURSE_NAME", nullable=false)
	private String name;
	
	@Column
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn
	private Instructor instructor;
	
	public Course() {
		super();
	}
	
	public Course(int id, String name, Instructor instructor, String description) {
		super();
		this.id = id;
		this.name = name;
		this.instructor = instructor;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
