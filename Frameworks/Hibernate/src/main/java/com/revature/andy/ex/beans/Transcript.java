package com.revature.andy.ex.beans;

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
	@Column(name="TRANSCRIPT_ID")
	@SequenceGenerator(name="TRANSCRIPTID_SEQ", sequenceName="TRANSCRIPTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSCRIPTID_SEQ")
	private int id;
	
	//joinColumns=@JoinColumn(name="TRANSCRIPT_ID"),
	//inverseJoinColumns=@JoinColumn(name="COURSE_ID")
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="STUDENT_COURSES",
    joinColumns=@JoinColumn(name="T_ID"),
    inverseJoinColumns=@JoinColumn(name="C_ID"))
	private Set<Course> Course;

	public Transcript() {
		
	}
	
	public Transcript(int id, Set<com.revature.andy.ex.beans.Course> course) {
		super();
		this.id = id;
		Course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Course> getCourse() {
		return Course;
	}

	public void setCourse(Set<Course> course) {
		Course = course;
	}
	
	
	
}
