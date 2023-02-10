package com.mouritech.lp.cppc.gateway.fp.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransactionStageDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String lotNo;

	private String location;

	private String tranType;

	private String entryDeviceName;

	private Integer entryDeviceNo;

	private String exitDeviceName;

	private Integer exitDeviceNo;

	private Integer ticketNumber;

	private String transEntryDate;

	private String transExitDate;

	private BigDecimal grossRate;

	private BigDecimal validationAmt;

	private String validationID;

	private BigDecimal netRate;

	private String rateTable;

	private BigDecimal cashAmt;

	private BigDecimal nonCashAmt;

	private String paymentType;

	private String ccAuthCode;

	private String monthlyCredID;

	private String accessResult;

	private String direction;

	private Integer totalActiveCards;

	private String debitValuePass;

	private String voidCancel;

	private String eReservation;

	private BigDecimal eReservationAmt;
	
	private String uniqueTicketId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getEntryDeviceName() {
		return entryDeviceName;
	}

	public void setEntryDeviceName(String entryDeviceName) {
		this.entryDeviceName = entryDeviceName;
	}

	public Integer getEntryDeviceNo() {
		return entryDeviceNo;
	}

	public void setEntryDeviceNo(Integer entryDeviceNo) {
		this.entryDeviceNo = entryDeviceNo;
	}

	public String getExitDeviceName() {
		return exitDeviceName;
	}

	public void setExitDeviceName(String exitDeviceName) {
		this.exitDeviceName = exitDeviceName;
	}

	public Integer getExitDeviceNo() {
		return exitDeviceNo;
	}

	public void setExitDeviceNo(Integer exitDeviceNo) {
		this.exitDeviceNo = exitDeviceNo;
	}

	public Integer getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTransEntryDate() {
		return transEntryDate;
	}

	public void setTransEntryDate(String transEntryDate) {
		this.transEntryDate = transEntryDate;
	}

	public String getTransExitDate() {
		return transExitDate;
	}

	public void setTransExitDate(String transExitDate) {
		this.transExitDate = transExitDate;
	}

	public BigDecimal getGrossRate() {
		return grossRate;
	}

	public void setGrossRate(BigDecimal grossRate) {
		this.grossRate = grossRate;
	}

	public BigDecimal getValidationAmt() {
		return validationAmt;
	}

	public void setValidationAmt(BigDecimal validationAmt) {
		this.validationAmt = validationAmt;
	}

	public String getValidationID() {
		return validationID;
	}

	public void setValidationID(String validationID) {
		this.validationID = validationID;
	}

	public BigDecimal getNetRate() {
		return netRate;
	}

	public void setNetRate(BigDecimal netRate) {
		this.netRate = netRate;
	}

	public String getRateTable() {
		return rateTable;
	}

	public void setRateTable(String rateTable) {
		this.rateTable = rateTable;
	}

	public BigDecimal getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(BigDecimal cashAmt) {
		this.cashAmt = cashAmt;
	}

	public BigDecimal getNonCashAmt() {
		return nonCashAmt;
	}

	public void setNonCashAmt(BigDecimal nonCashAmt) {
		this.nonCashAmt = nonCashAmt;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCcAuthCode() {
		return ccAuthCode;
	}

	public void setCcAuthCode(String ccAuthCode) {
		this.ccAuthCode = ccAuthCode;
	}

	public String getMonthlyCredID() {
		return monthlyCredID;
	}

	public void setMonthlyCredID(String monthlyCredID) {
		this.monthlyCredID = monthlyCredID;
	}

	public String getAccessResult() {
		return accessResult;
	}

	public void setAccessResult(String accessResult) {
		this.accessResult = accessResult;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getTotalActiveCards() {
		return totalActiveCards;
	}

	public void setTotalActiveCards(Integer totalActiveCards) {
		this.totalActiveCards = totalActiveCards;
	}

	public String getDebitValuePass() {
		return debitValuePass;
	}

	public void setDebitValuePass(String debitValuePass) {
		this.debitValuePass = debitValuePass;
	}

	public String getVoidCancel() {
		return voidCancel;
	}

	public void setVoidCancel(String voidCancel) {
		this.voidCancel = voidCancel;
	}

	public String geteReservation() {
		return eReservation;
	}

	public void seteReservation(String eReservation) {
		this.eReservation = eReservation;
	}

	public BigDecimal geteReservationAmt() {
		return eReservationAmt;
	}

	public void seteReservationAmt(BigDecimal eReservationAmt) {
		this.eReservationAmt = eReservationAmt;
	}

	public String getUniqueTicketId() {
		return uniqueTicketId;
	}

	public void setUniqueTicketId(String uniqueTicketId) {
		this.uniqueTicketId = uniqueTicketId;
	}

}
