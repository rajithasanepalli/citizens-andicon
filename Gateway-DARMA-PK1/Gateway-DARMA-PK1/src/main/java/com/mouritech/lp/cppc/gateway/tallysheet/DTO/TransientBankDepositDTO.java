package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.LocalDateTime;

import com.mouritech.lp.cppc.gateway.DTO.enums.AuditActionEnum;

public class TransientBankDepositDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	private Integer garageBankId;

	private BigDecimal monthlyAmount;

	private BigDecimal transientAmount;
	
	private BigDecimal originalTransientAmount;

	private LocalDateTime depositDate;

	private String comment;

	private PaymentTypesDTO paymentTypesDTO;

	private CreditCardsDTO creditCardsDTO;

	private TransientsDTO transientDTO;
	
	private String createdBy;

	private String lastModifiedBy;

	private Date createdDate;

	private Date lastModifiedDate;
	private String ticketNumber;
	private AuditActionEnum auditAction;
	
	private BigDecimal adjustMent;
	
	

	public BigDecimal getAdjustMent() {
		return adjustMent;
	}

	public void setAdjustMent(BigDecimal adjustMent) {
		this.adjustMent = adjustMent;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public AuditActionEnum getAuditAction() {
		return auditAction;
	}

	public void setAuditAction(AuditActionEnum auditAction) {
		this.auditAction = auditAction;
	}

	public BigDecimal getOriginalTransientAmount() {
		return originalTransientAmount;
	}

	public void setOriginalTransientAmount(BigDecimal originalTransientAmount) {
		this.originalTransientAmount = originalTransientAmount;
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

	@Override
	public String toString() {
		return "TransientBankDepositDTO [id=" + id + ", garageBankId="
				+ garageBankId + ", monthlyAmount=" + monthlyAmount
				+ ", transientAmount=" + transientAmount + ", depositDate="
				+ depositDate + ", comment=" + comment + ", paymentTypesDTO="
				+ paymentTypesDTO + ", treditCardsDTO=" + creditCardsDTO
				+ ", transientDTO=" + transientDTO + "]";
	}

}