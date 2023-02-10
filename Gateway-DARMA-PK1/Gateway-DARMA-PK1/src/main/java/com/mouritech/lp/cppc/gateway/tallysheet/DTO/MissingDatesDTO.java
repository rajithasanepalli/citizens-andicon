package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

public class MissingDatesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean flag;

	private LocalDateTime missingDate;

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public LocalDateTime getMissingDate() {
		return missingDate;
	}

	public void setMissingDate(LocalDateTime missingDate) {
		this.missingDate = missingDate;
	}

	@Override
	public String toString() {
		return "MissingDatesDTO [flag=" + flag + ", missingDate=" + missingDate
				+ "]";
	}

	

	
}
