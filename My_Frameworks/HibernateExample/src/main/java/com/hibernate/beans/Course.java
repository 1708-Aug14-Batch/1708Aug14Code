package com.hibernate.beans;

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
@Table(name="COURSES")
public class Course {
	
	@Id
	@Column(name="COURSEID")
	@SequenceGenerator(name="COURSEID_SEQ", sequenceName="COURSEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSEID_SEQ")
	private int id;
	
	@Column(name="COURSENAME")
	private String name;
	
	// One-to-Many
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn
	private Instructor instructor;
	
	@Column
	private String description;

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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instructor=" + instructor + ", description=" + description
				+ "]";
	}
}
