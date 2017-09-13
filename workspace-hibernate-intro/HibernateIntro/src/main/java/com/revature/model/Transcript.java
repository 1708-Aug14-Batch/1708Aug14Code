package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="transcript")
public class Transcript {
	
	@Id
	@Column(name="transcript_id")
	@SequenceGenerator(name="transcript_id_seq", sequenceName="transcript_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transcript_id_seq")
	private int transcriptID;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="student_course", joinColumns=@JoinColumn(name="transcript_id"), inverseJoinColumns=@JoinColumn(name="course_id"))
	private Set<Course> courses;
	
	public Transcript(int transcriptID, Set<Course> courses) {
		super();
		this.transcriptID = transcriptID;
		this.courses = courses;
	}
	
	public Transcript() {
		// TODO Auto-generated constructor stub
	}

	public int getTranscriptID() {
		return transcriptID;
	}
	
	public void setTranscriptID(int transcriptID) {
		this.transcriptID = transcriptID;
	}
	
	public Set<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	

}
