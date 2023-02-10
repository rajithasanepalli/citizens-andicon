package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

import com.mouritech.lp.cppc.gateway.DTO.enums.PayRevisionStatus;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class PayrollRevisionDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private BigDecimal amount;
	private char billable;
	private String earningCode;
	private String earningCodeDesc;
	private String glAccountDesc;
	private String glAccountCode;
	private String legalEntity;
	private String locationId;
	private LocalDateTime payDate;
	private String payrollCode;
	private String wageCategory;
	private String payRevisionIdentifier;
	private String expenseType;
	private String earningsType;
	private PayRevisionStatus payRevisionStatus;
	private UserDTO approvedBy;
	private LocalDateTime approvedDate;
	private StatusEnum status;
	private String comments;
	private String createdBy;
	
	
	
	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public char getBillable() {
		return billable;
	}

	public void setBillable(char billable) {
		this.billable = billable;
	}

	public String getEarningCode() {
		return earningCode;
	}

	public void setEarningCode(String earningCode) {
		this.earningCode = earningCode;
	}

	public String getEarningCodeDesc() {
		return earningCodeDesc;
	}

	public void setEarningCodeDesc(String earningCodeDesc) {
		this.earningCodeDesc = earningCodeDesc;
	}

	public String getGlAccountDesc() {
		return glAccountDesc;
	}

	public void setGlAccountDesc(String glAccountDesc) {
		this.glAccountDesc = glAccountDesc;
	}


	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public LocalDateTime getPayDate() {
		return payDate;
	}

	public void setPayDate(LocalDateTime payDate) {
		this.payDate = payDate;
	}

	public String getPayrollCode() {
		return payrollCode;
	}

	public void setPayrollCode(String payrollCode) {
		this.payrollCode = payrollCode;
	}

	public String getWageCategory() {
		return wageCategory;
	}

	public void setWageCategory(String wageCategory) {
		this.wageCategory = wageCategory;
	}

	public String getPayRevisionIdentifier() {
		return payRevisionIdentifier;
	}

	public void setPayRevisionIdentifier(String payRevisionIdentifier) {
		this.payRevisionIdentifier = payRevisionIdentifier;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getEarningsType() {
		return earningsType;
	}

	public void setEarningsType(String earningsType) {
		this.earningsType = earningsType;
	}

	public PayRevisionStatus getPayRevisionStatus() {
		return payRevisionStatus;
	}

	public void setPayRevisionStatus(PayRevisionStatus payRevisionStatus) {
		this.payRevisionStatus = payRevisionStatus;
	}

	public UserDTO getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(UserDTO approvedBy) {
		this.approvedBy = approvedBy;
	}

	public LocalDateTime getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDateTime approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getGlAccountCode() {
		return glAccountCode;
	}

	public void setGlAccountCode(String glAccountCode) {
		this.glAccountCode = glAccountCode;
	}

	@Override
	public String toString() {
		return "PayrollRevisionDTO [id=" + id + ", amount=" + amount
				+ ", billable=" + billable + ", earningCode=" + earningCode
				+ ", earningCodeDesc=" + earningCodeDesc + ", glAccountDesc="
				+ glAccountDesc + ", glAccountCode=" + glAccountCode
				+ ", legalEntity=" + legalEntity + ", locationId=" + locationId
				+ ", payDate=" + payDate + ", payrollCode=" + payrollCode
				+ ", wageCategory=" + wageCategory + ", payRevisionIdentifier="
				+ payRevisionIdentifier + ", expenseType=" + expenseType
				+ ", earningsType=" + earningsType + ", payRevisionStatus="
				+ payRevisionStatus + ", approvedBy=" + approvedBy
				+ ", approvedDate=" + approvedDate + ", status=" + status + "]";
	}


	

}
