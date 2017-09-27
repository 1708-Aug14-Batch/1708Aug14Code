package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="IMAGE")
public class Image {

	@Id
	@Column(name="I_ID")
	@SequenceGenerator(name="I_ID_SEQ", sequenceName="I_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="I_ID_SEQ")
	private int id;
	
	@Column(name="FILEPATH", nullable=false)
	private String FilePath;
	
	public Image() {}

	public Image(int id, String filePath) {
		super();
		this.id = id;
		FilePath = filePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilePath() {
		return FilePath;
	}

	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	
}
