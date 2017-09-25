package com.ex.beans;

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
	@Column(name="COURSE_ID")
	@SequenceGenerator(name="C_ID_SEQ", sequenceName="C_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="C_ID_SEQ")
	private int id;
	
	@Column(name="COURSE_NAME", nullable = false)
	private String name;
	
	/*
	 * The cascade keyword often appears on the collection mapping 
	 * to manage the state of the collection of dependencies 
	 * automatically. For more info, see: http://www.mkyong.com/hibernate/hibernate-cascade-example-save-update-delete-and-delete-orphan/
	 */
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn
	private Instructor instructor;
	/*
	 * A fetching strategy (LAZY or EAGER) is the strategy that
	 * Hibernate will use for retrieving associated objects if the 
	 * app needs to navigate the association. Fetch strategies may 
	 * be declared in the ORM metadata, or overridden by an HQL or 
	 * Criteria query
	 */
	
	
	@Column
	private String description;
	
	public Course(){}

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