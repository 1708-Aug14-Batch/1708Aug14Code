package com.bank.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class AccountLevel implements Serializable {

	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "levelSeq")
	@SequenceGenerator(allocationSize = 1, name = "levelSeq", sequenceName = "TYPE_SEQ")
	@Column(name = "TYPE_ID")
	private int id;

	@Column
	private String level;

	public AccountLevel() {
	}
	public AccountLevel(String level) {
		this.level = level;
	}

	public AccountLevel(int id, String level) {
		super();
		this.id = id;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "AccountLevel [id=" + id + ", level=" + level + "]";
	}

}