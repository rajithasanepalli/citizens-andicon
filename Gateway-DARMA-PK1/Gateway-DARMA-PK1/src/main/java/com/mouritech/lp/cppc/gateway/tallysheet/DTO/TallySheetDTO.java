package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

public class TallySheetDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	// tallySheetDate
	private LocalDateTime tallySheetDate;

	// unitsBefore10AM
	private Integer carsInBy10AM;
	// unitsBefore10AM
	private Integer carsIn10AMand6PM;
	// unitsAfter6PM
	private Integer carsAfter6PM;
	// totalUnits
	private Integer totalCars;
	// DB missing
	private Integer totalHours;// not in search
	// bicycleUnits
	private Integer bikesParked;// not in search

	// netDepositAmount
	private BigDecimal totalReciepts;
	// transChargeAmount
	private BigDecimal dailyAndOorNCharges;
	// paidOut
	private BigDecimal paidOut;
	// overUnder
	private BigDecimal overOrUnder;// not in search
	// dailyMonthlyAmount
	private BigDecimal monthlyPayments;// not in search
	// bicycleAmount
	private BigDecimal bicycleRevenue;// not in search

	// totalNumberDeposits
	private BigDecimal totalNumberDeposits;// not in search
	// depositDate in TBD
	private LocalDateTime cashDepositDate;
	// totalCashDeposit
	private BigDecimal totalCashDeposit;
	// processingFee
	private BigDecimal processingFee;// not in search
	// totalAmexAmount
	private BigDecimal totalAmexAmount;
	// totalVisOrMasterAmount
	private BigDecimal totalVisaOrMasterAmount;// not in search
	// totalDiscoverAmount
	private BigDecimal totalDiscoverAmount;

	// netDepositAmount
	private BigDecimal totalRevenue;// not in search
	// must be zero
	private BigDecimal receiptsBalance;// not in search
	// garagesDTO
	private GaragesDTO garagesDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getTallySheetDate() {
		return tallySheetDate;
	}

	public void setTallySheetDate(LocalDateTime tallySheetDate) {
		this.tallySheetDate = tallySheetDate;
	}

	public Integer getCarsInBy10AM() {
		return carsInBy10AM;
	}

	public void setCarsInBy10AM(Integer carsInBy10AM) {
		this.carsInBy10AM = carsInBy10AM;
	}

	public Integer getCarsIn10AMand6PM() {
		return carsIn10AMand6PM;
	}

	public void setCarsIn10AMand6PM(Integer carsIn10AMand6PM) {
		this.carsIn10AMand6PM = carsIn10AMand6PM;
	}

	public Integer getCarsAfter6PM() {
		return carsAfter6PM;
	}

	public void setCarsAfter6PM(Integer carsAfter6PM) {
		this.carsAfter6PM = carsAfter6PM;
	}

	public Integer getTotalCars() {
		return totalCars;
	}

	public void setTotalCars(Integer totalCars) {
		this.totalCars = totalCars;
	}

	public Integer getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}

	public Integer getBikesParked() {
		return bikesParked;
	}

	public void setBikesParked(Integer bikesParked) {
		this.bikesParked = bikesParked;
	}

	public BigDecimal getTotalReciepts() {
		return totalReciepts;
	}

	public void setTotalReciepts(BigDecimal totalReciepts) {
		this.totalReciepts = totalReciepts;
	}

	public BigDecimal getDailyAndOorNCharges() {
		return dailyAndOorNCharges;
	}

	public void setDailyAndOorNCharges(BigDecimal dailyAndOorNCharges) {
		this.dailyAndOorNCharges = dailyAndOorNCharges;
	}

	public BigDecimal getPaidOut() {
		return paidOut;
	}

	public void setPaidOut(BigDecimal paidOut) {
		this.paidOut = paidOut;
	}

	public BigDecimal getOverOrUnder() {
		return overOrUnder;
	}

	public void setOverOrUnder(BigDecimal overOrUnder) {
		this.overOrUnder = overOrUnder;
	}

	public BigDecimal getMonthlyPayments() {
		return monthlyPayments;
	}

	public void setMonthlyPayments(BigDecimal monthlyPayments) {
		this.monthlyPayments = monthlyPayments;
	}

	public BigDecimal getBicycleRevenue() {
		return bicycleRevenue;
	}

	public void setBicycleRevenue(BigDecimal bicycleRevenue) {
		this.bicycleRevenue = bicycleRevenue;
	}

	public BigDecimal getTotalNumberDeposits() {
		return totalNumberDeposits;
	}

	public void setTotalNumberDeposits(BigDecimal totalNumberDeposits) {
		this.totalNumberDeposits = totalNumberDeposits;
	}

	public BigDecimal getTotalCashDeposit() {
		return totalCashDeposit;
	}

	public void setTotalCashDeposit(BigDecimal totalCashDeposit) {
		this.totalCashDeposit = totalCashDeposit;
	}

	public BigDecimal getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(BigDecimal processingFee) {
		this.processingFee = processingFee;
	}

	public BigDecimal getTotalAmexAmount() {
		return totalAmexAmount;
	}

	public void setTotalAmexAmount(BigDecimal totalAmexAmount) {
		this.totalAmexAmount = totalAmexAmount;
	}

	public BigDecimal getTotalVisaOrMasterAmount() {
		return totalVisaOrMasterAmount;
	}

	public void setTotalVisaOrMasterAmount(BigDecimal totalVisaOrMasterAmount) {
		this.totalVisaOrMasterAmount = totalVisaOrMasterAmount;
	}

	public BigDecimal getTotalDiscoverAmount() {
		return totalDiscoverAmount;
	}

	public void setTotalDiscoverAmount(BigDecimal totalDiscoverAmount) {
		this.totalDiscoverAmount = totalDiscoverAmount;
	}

	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public BigDecimal getReceiptsBalance() {
		return receiptsBalance;
	}

	public void setReceiptsBalance(BigDecimal receiptsBalance) {
		this.receiptsBalance = receiptsBalance;
	}

	public GaragesDTO getGaragesDTO() {
		return garagesDTO;
	}

	public void setGaragesDTO(GaragesDTO garagesDTO) {
		this.garagesDTO = garagesDTO;
	}

	public LocalDateTime getCashDepositDate() {
		return cashDepositDate;
	}

	public void setCashDepositDate(LocalDateTime cashDepositDate) {
		this.cashDepositDate = cashDepositDate;
	}

	@Override
	public String toString() {
		return "TallySheetDTO [id=" + id + ", tallySheetDate=" + tallySheetDate
				+ ", carsInBy10AM=" + carsInBy10AM + ", carsIn10AMand6PM="
				+ carsIn10AMand6PM + ", carsAfter6PM=" + carsAfter6PM
				+ ", totalCars=" + totalCars + ", totalHours=" + totalHours
				+ ", bikesParked=" + bikesParked + ", totalReciepts="
				+ totalReciepts + ", dailyAndOorNCharges="
				+ dailyAndOorNCharges + ", paidOut=" + paidOut
				+ ", overOrUnder=" + overOrUnder + ", monthlyPayments="
				+ monthlyPayments + ", bicycleRevenue=" + bicycleRevenue
				+ ", totalNumberDeposits=" + totalNumberDeposits
				+ ", cashDepositDate=" + cashDepositDate
				+ ", totalCashDeposit=" + totalCashDeposit + ", processingFee="
				+ processingFee + ", totalAmexAmount=" + totalAmexAmount
				+ ", totalVisaOrMasterAmount=" + totalVisaOrMasterAmount
				+ ", totalDiscoverAmount=" + totalDiscoverAmount
				+ ", totalRevenue=" + totalRevenue + ", receiptsBalance="
				+ receiptsBalance + ", garagesDTO=" + garagesDTO + "]";
	}

}
