package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.LocalDateTime;

public class TransientBankDepositsAuditDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	private Integer garageBankId;

	private BigDecimal monthlyAmount;

	private BigDecimal transientAmount;

	private LocalDateTime depositDate;

	private String comment;

	private PaymentTypesDTO paymentTypesDTO;

	private CreditCardsDTO creditCardsDTO;

	private TransientsDTO transientDTO;

	private String createdBy;

	private String lastModifiedBy;

	private Date createdDate;

	private Date lastModifiedDate;

	private String auditAction;

	private String updatedBy;

	private LocalDateTime updatedOn;

	private BigDecimal adjustMent;

	public BigDecimal getAdjustMent() {
		return adjustMent;
	}

	public void setAdjustMent(BigDecimal adjustMent) {
		this.adjustMent = adjustMent;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGarageBankId() {
		return garageBankId;
	}

	public void setGarageBankId(Integer garageBankId) {
		this.garageBankId = garageBankId;
	}

	public BigDecimal getMonthlyAmount() {
		return monthlyAmount;
	}

	public void setMonthlyAmount(BigDecimal monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}

	public BigDecimal getTransientAmount() {
		return transientAmount;
	}

	public void setTransientAmount(BigDecimal transientAmount) {
		this.transientAmount = transientAmount;
	}

	public LocalDateTime getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(LocalDateTime depositDate) {
		this.depositDate = depositDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PaymentTypesDTO getPaymentTypesDTO() {
		return paymentTypesDTO;
	}

	public void setPaymentTypesDTO(PaymentTypesDTO paymentTypesDTO) {
		this.paymentTypesDTO = paymentTypesDTO;
	}

	public CreditCardsDTO getCreditCardsDTO() {
		return creditCardsDTO;
	}

	public void setCreditCardsDTO(CreditCardsDTO creditCardsDTO) {
		this.creditCardsDTO = creditCardsDTO;
	}

	public TransientsDTO getTransientDTO() {
		return transientDTO;
	}

	public void setTransientDTO(TransientsDTO transientDTO) {
		this.transientDTO = transientDTO;
	}

	public String getAuditAction() {
		return auditAction;
	}

	public void setAuditAction(String auditAction) {
		this.auditAction = auditAction;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Transient_Bank_Deposits_AuditDTO [id=" + id + ", garageBankId="
				+ garageBankId + ", monthlyAmount=" + monthlyAmount
				+ ", transientAmount=" + transientAmount + ", depositDate="
				+ depositDate + ", comment=" + comment + ", paymentTypesDTO="
				+ paymentTypesDTO + ", creditCardsDTO=" + creditCardsDTO
				+ ", transientDTO=" + transientDTO + ", createdBy=" + createdBy
				+ ", lastModifiedBy=" + lastModifiedBy + ", createdDate="
				+ createdDate + ", lastModifiedDate=" + lastModifiedDate
				+ ", auditAction=" + auditAction + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + "]";
	}

	// @Override
	// public String toString() {
	// return "TransientBankDepositDTO [id=" + id + ", garageBankId="
	// + garageBankId + ", monthlyAmount=" + monthlyAmount
	// + ", transientAmount=" + transientAmount + ", depositDate="
	// + depositDate + ", comment=" + comment + ", paymentTypesDTO="
	// + paymentTypesDTO + ", treditCardsDTO=" + creditCardsDTO
	// + ", transientDTO=" + transientDTO + "]";
	//
	// }

}