package com.hibernate.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRANSCRIPTS")
public class Transcript {

	@Id
	@Column(name="TRANSCRIPTID")
	@SequenceGenerator(name="TRANSCRIPTID_SEQ", sequenceName="TRANSCRIPTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSCRIPTID_SEQ")
	private int id;
	
	// Many-to-Many
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="STUDENT_COURSES",
		joinColumns=@JoinColumn(name="TRANSCRIPTID"),
		inverseJoinColumns=@JoinColumn(name="COURSEID"))
	private Set<Course> courses;

	public Transcript() {
		super();
	}

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

	@Override
	public String toString() {
		return "Transcript [id=" + id + ", courses=" + courses + "]";
	}
}
