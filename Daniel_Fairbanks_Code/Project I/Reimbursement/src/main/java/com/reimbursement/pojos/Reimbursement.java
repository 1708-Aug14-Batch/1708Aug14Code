package com.reimbursement.pojos;

import java.math.BigDecimal;
import java.util.Date;

public class Reimbursement {
	
	private User submitted_by;
	private User resolved_by;
	private ReimbursementStatus status;
	private String description;
	private String resolve_notes;
	private BigDecimal amount;
	private Date submit_date;
	private Date resolve_date;
	

}
