package com.revature.andy.pojos;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Reimbursement {
			 
	private int reimID;
	private User submitterID;
	private User resolverID;
	private String submitDate;
	private String resolveDate;
	private ReimStatus statusID;
	private String description;
	private String notes;
	private double amount;
	
	public Reimbursement() {}

	public Reimbursement(int reimID, User submitterID, User resolverID, String submitDate, String resolveDate,
			ReimStatus statusID, String description, String notes, double amount) {
		super();
		this.reimID = reimID;
		this.submitterID = submitterID;
		this.resolverID = resolverID;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.statusID = statusID;
		this.description = description;
		this.notes = notes;
		this.amount = amount;
	}

	public Reimbursement(int reimID, User submitterID, User resolverID, Date submitDate, Date resolveDate,
			ReimStatus statusID, String description, String notes, double amount) {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		this.reimID = reimID;
		this.submitterID = submitterID;
		this.resolverID = resolverID;
		this.submitDate = sdf.format(submitDate);
		if(resolveDate != null) {
		this.resolveDate = sdf.format(resolveDate);
		}
		this.statusID = statusID;
		this.description = description;
		this.notes = notes;
		this.amount = amount;
	}

	public int getReimID() {
		return reimID;
	}

	public void setReimID(int reimID) {
		this.reimID = reimID;
	}

	public User getSubmitterID() {
		return submitterID;
	}

	public void setSubmitterID(User submitterID) {
		this.submitterID = submitterID;
	}

	public User getResolverID() {
		return resolverID;
	}

	public void setResolverID(User resolverID) {
		this.resolverID = resolverID;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}

	public ReimStatus getStatusID() {
		return statusID;
	}

	public void setStatusID(ReimStatus statusID) {
		this.statusID = statusID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimID=" + reimID + ", submitterID=" + submitterID.toString() + ", resolverID=" + resolverID.toString()
				+ ", submitDate=" + submitDate + ", resolveDate=" + resolveDate + ", statusID=" + statusID.toString()
				+ ", description=" + description + ", notes=" + notes + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + reimID;
		result = prime * result + ((resolveDate == null) ? 0 : resolveDate.hashCode());
		result = prime * result + ((resolverID == null) ? 0 : resolverID.hashCode());
		result = prime * result + ((statusID == null) ? 0 : statusID.hashCode());
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result + ((submitterID == null) ? 0 : submitterID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (reimID != other.reimID)
			return false;
		if (resolveDate == null) {
			if (other.resolveDate != null)
				return false;
		} else if (!resolveDate.equals(other.resolveDate))
			return false;
		if (resolverID == null) {
			if (other.resolverID != null)
				return false;
		} else if (!resolverID.equals(other.resolverID))
			return false;
		if (statusID == null) {
			if (other.statusID != null)
				return false;
		} else if (!statusID.equals(other.statusID))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (submitterID == null) {
			if (other.submitterID != null)
				return false;
		} else if (!submitterID.equals(other.submitterID))
			return false;
		return true;
	};
	
	
	
	
	
}
