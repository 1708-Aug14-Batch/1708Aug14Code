package com.revature.andy.pojos;

public class ReimStatus {
	
	private int statusID;
	private String statusName;
	
	public ReimStatus() {}

	public ReimStatus(int statusID, String statusName) {
		super();
		this.statusID = statusID;
		this.statusName = statusName;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "ReimStatus [statusID=" + statusID + ", statusName=" + statusName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + statusID;
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
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
		ReimStatus other = (ReimStatus) obj;
		if (statusID != other.statusID)
			return false;
		if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
		return true;
	};
	
	
	
}
