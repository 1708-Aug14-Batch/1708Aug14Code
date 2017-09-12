package com.ex.bean;

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
	@Column
	@SequenceGenerator(name="T_SEQ_ID", sequenceName="T_SEQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_SEQ_ID")
	private int id;
	
	//n-n
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="TRANSCRIPTS_COURSES",
				joinColumns=@JoinColumn(name="T_ID"),
				inverseJoinColumns=@JoinColumn(name="C_ID"))
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
