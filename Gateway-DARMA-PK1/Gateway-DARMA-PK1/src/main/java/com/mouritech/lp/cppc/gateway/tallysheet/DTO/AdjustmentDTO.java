package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdjustmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private BigDecimal originalValue;
	
	private BigDecimal adjustedFrom;
	
	private BigDecimal adjustedTo;
	
	private BigDecimal adjustedAmount;
	
	private String adjustedBy;
	
	private String ticketNumber;
	
	private Date adjustedOn;

	private String comment;
	
	private String adjustMentReason;
	
	
	
	public String getAdjustMentReason() {
		return adjustMentReason;
	}

	public void setAdjustMentReason(String adjustMentReason) {
		this.adjustMentReason = adjustMentReason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigDecimal getAdjustedAmount() {
		return adjustedAmount;
	}

	public void setAdjustedAmount(BigDecimal adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public BigDecimal getOriginalValue() {
		return originalValue;
	}

	public void setOriginalValue(BigDecimal originalValue) {
		this.originalValue = originalValue;
	}

	public BigDecimal getAdjustedFrom() {
		return adjustedFrom;
	}

	public void setAdjustedFrom(BigDecimal adjustedFrom) {
		this.adjustedFrom = adjustedFrom;
	}

	public BigDecimal getAdjustedTo() {
		return adjustedTo;
	}

	public void setAdjustedTo(BigDecimal adjustedTo) {
		this.adjustedTo = adjustedTo;
	}



	public String getAdjustedBy() {
		return adjustedBy;
	}

	public void setAdjustedBy(String adjustedBy) {
		this.adjustedBy = adjustedBy;
	}

	public Date getAdjustedOn() {
		return adjustedOn;
	}

	public void setAdjustedOn(Date adjustedOn) {
		this.adjustedOn = adjustedOn;
	}

	@Override
	public String toString() {
		return "AdjustmentDTO [originalValue=" + originalValue
				+ ", adjustedFrom=" + adjustedFrom + ", adjustedTo="
				+ adjustedTo + ", adjustedAmount=" + adjustedAmount
				+ ", adjustedBy=" + adjustedBy + ", ticketNumber="
				+ ticketNumber + ", adjustedOn=" + adjustedOn + ", comment="
				+ comment + ", adjustMentReason=" + adjustMentReason + "]";
	}

	
	
	
	

	

}
