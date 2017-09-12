package com.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INSTRUCTORS")
public class Instructor {
	
	@Id
	@Column(name="INSTRUCTORID")
	@SequenceGenerator(name="INSTRUCTORID_SEQ", sequenceName="INSTRUCTORID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUCTORID_SEQ")
	private int id;
	
	@Column
	private String name;

	public Instructor() {
		super();
	}

	public Instructor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + "]";
	}
}
