package com.ers.pojos;

import java.sql.Timestamp;

public class Request {
	
	private int requestId;
	private int submitterId;
	private int resolverId;
	private Timestamp submitDate;
	private Timestamp resolveDate;
	private Status status;
	private String description;
	private String notes;
	private float amount;	

}
