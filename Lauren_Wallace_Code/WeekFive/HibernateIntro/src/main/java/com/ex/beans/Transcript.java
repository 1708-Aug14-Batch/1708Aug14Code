package com.ex.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="TRANSCRIPTS")
public class Transcript {
	
	@Id
	@Column(name="T_ID")
	@SequenceGenerator(name="T_ID_SEQ", sequenceName="T_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_ID_SEQ")
	private int id;
	
	//MANY TO MANY
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="STUDENT_COURSES", 
	joinColumns=@JoinColumn(name="T_ID"),
	inverseJoinColumns=@JoinColumn(name="C_ID"))
	private Set<Course> courses;
	
	public Transcript() {}

	public Transcript(int id, Set<Course> courses) {
		super();
		this.id = id;
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
