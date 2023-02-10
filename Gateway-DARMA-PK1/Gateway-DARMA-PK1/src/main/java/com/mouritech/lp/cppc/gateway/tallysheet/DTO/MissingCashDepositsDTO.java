package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

public class MissingCashDepositsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer transientID;

	private LocalDateTime missingDate;

	public Integer getTransientID() {
		return transientID;
	}

	public void setTransientID(Integer transientID) {
		this.transientID = transientID;
	}

	public LocalDateTime getMissingDate() {
		return missingDate;
	}

	public void setMissingDate(LocalDateTime missingDate) {
		this.missingDate = missingDate;
	}

	@Override
	public String toString() {
		return "MissingCashDepositsDTO [transientID=" + transientID
				+ ", missingDate=" + missingDate + "]";
	}

	
}
