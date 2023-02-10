package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class MissingTallySheetAndTotalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<MissingDatesDTO> missingDatesDTO;
	
	private List<MissingCashDepositsDTO> missingCashDeposits;

	private Integer totalCars;

	private BigDecimal totalReceipts;

	private BigDecimal dailyAndOorNCharges;

	private List<CardPaymentsAndTotal> cardPaymentsAndTotal;
	
	private boolean isMonthClosed;
	
	private BigDecimal cardPaymentsTotal;

	private BigDecimal paidOutTotal;
	
	private BigDecimal overOrUnderTotal;
	
	private Integer totalBicycleUnits;
	
	private BigDecimal totalBicycleRevenue;

	private BigDecimal totalMonthlyPayments;
	
	private BigDecimal grandTotal;
	

	

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<MissingCashDepositsDTO> getMissingCashDeposits() {
		return missingCashDeposits;
	}

	public void setMissingCashDeposits(
			List<MissingCashDepositsDTO> missingCashDeposits) {
		this.missingCashDeposits = missingCashDeposits;
	}

	public BigDecimal getPaidOutTotal() {
		return paidOutTotal;
	}

	public void setPaidOutTotal(BigDecimal paidOutTotal) {
		this.paidOutTotal = paidOutTotal;
	}

	public BigDecimal getOverOrUnderTotal() {
		return overOrUnderTotal;
	}

	public void setOverOrUnderTotal(BigDecimal overOrUnderTotal) {
		this.overOrUnderTotal = overOrUnderTotal;
	}

	public Integer getTotalBicycleUnits() {
		return totalBicycleUnits;
	}

	public void setTotalBicycleUnits(Integer totalBicycleUnits) {
		this.totalBicycleUnits = totalBicycleUnits;
	}

	public BigDecimal getTotalBicycleRevenue() {
		return totalBicycleRevenue;
	}

	public void setTotalBicycleRevenue(BigDecimal totalBicycleRevenue) {
		this.totalBicycleRevenue = totalBicycleRevenue;
	}

	public BigDecimal getTotalMonthlyPayments() {
		return totalMonthlyPayments;
	}

	public void setTotalMonthlyPayments(BigDecimal totalMonthlyPayments) {
		this.totalMonthlyPayments = totalMonthlyPayments;
	}

	public BigDecimal getCardPaymentsTotal() {
		return cardPaymentsTotal;
	}

	public void setCardPaymentsTotal(BigDecimal cardPaymentsTotal) {
		this.cardPaymentsTotal = cardPaymentsTotal;
	}

	public boolean isMonthClosed() {
		return isMonthClosed;
	}

	public void setMonthClosed(boolean isMonthClosed) {
		this.isMonthClosed = isMonthClosed;
	}

	

	public List<MissingDatesDTO> getMissingDatesDTO() {
		return missingDatesDTO;
	}

	public void setMissingDatesDTO(List<MissingDatesDTO> missingDatesDTO) {
		this.missingDatesDTO = missingDatesDTO;
	}

	public Integer getTotalCars() {
		return totalCars;
	}

	public void setTotalCars(Integer totalCars) {
		this.totalCars = totalCars;
	}

	public BigDecimal getTotalReceipts() {
		return totalReceipts;
	}

	public void setTotalReceipts(BigDecimal totalReceipts) {
		this.totalReceipts = totalReceipts;
	}

	public BigDecimal getDailyAndOorNCharges() {
		return dailyAndOorNCharges;
	}

	public void setDailyAndOorNCharges(BigDecimal dailyAndOorNCharges) {
		this.dailyAndOorNCharges = dailyAndOorNCharges;
	}

	public List<CardPaymentsAndTotal> getCardPaymentsAndTotal() {
		return cardPaymentsAndTotal;
	}

	public void setCardPaymentsAndTotal(
			List<CardPaymentsAndTotal> cardPaymentsAndTotal) {
		this.cardPaymentsAndTotal = cardPaymentsAndTotal;
	}

}
