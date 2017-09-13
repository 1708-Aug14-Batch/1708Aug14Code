package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="TRANSCRIPTS")
public class Transcript {

	@Id
	@Column(name="TRANSCRIPT_ID")
	@SequenceGenerator(name="TRANSCRIPT_ID_SEQ", sequenceName="TRANSCRIPT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSCRIPT_ID_SEQ")
	private int id;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="STUDENT_COURSES",
			   joinColumns=@JoinColumn(name="TRANSCRIPT_ID"),
			   inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private Set<Course> courses;

	public Transcript(int id, Set<Course> courses) {
		super();
		this.id = id;
		this.courses = courses;
	}

	public Transcript() {
		super();
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
