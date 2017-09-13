package com.bank.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@Column(name="USERID")
	@SequenceGenerator(name="USERID_SEQ", sequenceName="USERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERID_SEQ")
	private int USERID; //Primary Key
	
	@Column(name="FIRSTNAME", nullable=false)
	private String FIRSTNAME; //not null
	
	@Column(name="LASTNAME", nullable=false)
	private String LASTNAME; //not null
	
	@Column(name="EMAIL", nullable=false, unique=true)
	private String EMAIL; //not null && unique
	
	@Column(name="PASSWORD", nullable=false)
	private String PASSWORD; //not null
	
	public User() {}

	public User(int uSERID, String fIRSTNAME, String lASTNAME, String eMAIL, String pASSWORD) {
		super();
		USERID = uSERID;
		FIRSTNAME = fIRSTNAME;
		LASTNAME = lASTNAME;
		EMAIL = eMAIL;
		PASSWORD = pASSWORD;
	}

	public int getUSERID() {
		return USERID;
	}

	public void setUSERID(int uSERID) {
		USERID = uSERID;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	@Override
	public String toString() {
		return "User [USERID=" + USERID + ", FIRSTNAME=" + FIRSTNAME + ", LASTNAME=" + LASTNAME + ", EMAIL=" + EMAIL
				+ ", PASSWORD=" + PASSWORD + "]";
	}
	
}
