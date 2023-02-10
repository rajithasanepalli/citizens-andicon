package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.mouritech.lp.cppc.gateway.DTO.enums.AuditActionEnum;

public class TransientsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer unitsBefore10AM;

	private Integer unitsAfter10AM;

	private Integer unitsAfter6PM;

	private Integer totalUnits;
	
	private Integer closedTickets;
	// missing in ui
	private BigDecimal normalGrossAmount;
	
	private BigDecimal originalNormalGrossAmount;
	// cal
	private BigDecimal normalSalesTaxPerc;
	// cal
	private BigDecimal normalSalesTaxAmount;

	private BigDecimal paidOut;

	private BigDecimal overUnder;

	private BigDecimal netDepositAmount;
	// missing ui
	private BigDecimal employeesStraightHours;
	// missing ui
	private BigDecimal employeesOvertimeHours;
	// missing ui
	private Integer dailyMonthlyUnits;

	private BigDecimal dailyMonthlyAmount;
	// missing ui
	private BigDecimal eventSalesTaxAmount;
	// missing ui
	private BigDecimal eventSalesTaxPerc;
	// cal
	private Long tallySheetNo;

	private LocalDateTime tallySheetDate;
	// missing ui
	private BigDecimal eventGrossAmount;
	// missing ui
	private String depositComment;
	// missing ui
	private Integer focusGLID;

	private Integer bicycleUnits;

	private BigDecimal bicycleAmount;
	// missing ui
	private Integer transCashUnits;
	// missing ui
	private BigDecimal transCashAmount;
	// missing ui
	private Integer transCredCdUnits;
	// missing ui
	private BigDecimal transCredCdAmount;
	// missing ui
	private Integer transChargeUnits;

	private BigDecimal transChargeAmount;
	// cal
	private BigDecimal bicycleSalesTaxPct;
	// cal
	private BigDecimal bicycleSalesTaxAmt;
	// cal
	private Boolean weekend;

	private BigDecimal processingFee;

	private BigDecimal totalNumberDeposits;

	private GaragesDTO garagesDTO;

	
	private List<TransientBankDepositDTO> transientBankDeposits = new ArrayList<TransientBankDepositDTO>();
	
	
	
	private String createdBy;

	private String lastModifiedBy;

	private Date createdDate;

	private Date lastModifiedDate;
	
	private String reasonForUpdate;
	
	private Boolean locationClosed;
	
	private String reasonForLocClose;
	
	private AuditActionEnum auditAction;
	
	private Boolean isAudited;
	
	private Boolean ttechErrorOrManualTicket;
	
	private String prepaidReservation;
	
	private Boolean isCorrected;
	
	private BigDecimal originalTransChargeAmount;
	
	private Boolean isChargeAudited;
	
	
	
	public Boolean getIsChargeAudited() {
		return isChargeAudited;
	}
	public void setIsChargeAudited(Boolean isChargeAudited) {
		this.isChargeAudited = isChargeAudited;
	}
	public BigDecimal getOriginalTransChargeAmount() {
		return originalTransChargeAmount;
	}
	public void setOriginalTransChargeAmount(BigDecimal originalTransChargeAmount) {
		this.originalTransChargeAmount = originalTransChargeAmount;
	}
	
	public Boolean getIsCorrected() {
		return isCorrected;
	}
	public void setIsCorrected(Boolean isCorrected) {
		this.isCorrected = isCorrected;
	}
	public String getPrepaidReservation() {
		return prepaidReservation;
	}
	public void setPrepaidReservation(String prepaidReservation) {
		this.prepaidReservation = prepaidReservation;
	}
	public Integer getClosedTickets() {
		return closedTickets;
	}
	public void setClosedTickets(Integer closedTickets) {
		this.closedTickets = closedTickets;
	}
	
	public Boolean getTtechErrorOrManualTicket() {
		return ttechErrorOrManualTicket;
	}
	public void setTtechErrorOrManualTicket(Boolean ttechErrorOrManualTicket) {
		this.ttechErrorOrManualTicket = ttechErrorOrManualTicket;
	}
	public Boolean getIsAudited() {
		return isAudited;
	}
	public void setIsAudited(Boolean isAudited) {
		this.isAudited = isAudited;
	}
	public AuditActionEnum getAuditAction() {
		return auditAction;
	}
	public void setAuditAction(AuditActionEnum auditAction) {
		this.auditAction = auditAction;
	}
	public BigDecimal getOriginalNormalGrossAmount() {
		return originalNormalGrossAmount;
	}
	public void setOriginalNormalGrossAmount(BigDecimal originalNormalGrossAmount) {
		this.originalNormalGrossAmount = originalNormalGrossAmount;
	}
	public String getReasonForLocClose() {
		return reasonForLocClose;
	}
	public void setReasonForLocClose(String reasonForLocClose) {
		this.reasonForLocClose = reasonForLocClose;
	}
	public Boolean getLocationClosed() {
		return locationClosed;
	}
	public void setLocationClosed(Boolean locationClosed) {
		this.locationClosed = locationClosed;
	}
	public String getReasonForUpdate() {
		return reasonForUpdate;
	}
	public void setReasonForUpdate(String reasonForUpdate) {
		this.reasonForUpdate = reasonForUpdate;
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
	public Integer getUnitsBefore10AM() {
		return unitsBefore10AM;
	}
	public void setUnitsBefore10AM(Integer unitsBefore10AM) {
		this.unitsBefore10AM = unitsBefore10AM;
	}
	public Integer getUnitsAfter10AM() {
		return unitsAfter10AM;
	}
	public void setUnitsAfter10AM(Integer unitsAfter10AM) {
		this.unitsAfter10AM = unitsAfter10AM;
	}
	public Integer getUnitsAfter6PM() {
		return unitsAfter6PM;
	}
	public void setUnitsAfter6PM(Integer unitsAfter6PM) {
		this.unitsAfter6PM = unitsAfter6PM;
	}
	public Integer getTotalUnits() {
		return totalUnits;
	}
	public void setTotalUnits(Integer totalUnits) {
		this.totalUnits = totalUnits;
	}
	public BigDecimal getNormalGrossAmount() {
		return normalGrossAmount;
	}
	public void setNormalGrossAmount(BigDecimal normalGrossAmount) {
		this.normalGrossAmount = normalGrossAmount;
	}
	public BigDecimal getNormalSalesTaxPerc() {
		return normalSalesTaxPerc;
	}
	public void setNormalSalesTaxPerc(BigDecimal normalSalesTaxPerc) {
		this.normalSalesTaxPerc = normalSalesTaxPerc;
	}
	public BigDecimal getNormalSalesTaxAmount() {
		return normalSalesTaxAmount;
	}
	public void setNormalSalesTaxAmount(BigDecimal normalSalesTaxAmount) {
		this.normalSalesTaxAmount = normalSalesTaxAmount;
	}
	public BigDecimal getPaidOut() {
		return paidOut;
	}
	public void setPaidOut(BigDecimal paidOut) {
		this.paidOut = paidOut;
	}
	public BigDecimal getOverUnder() {
		return overUnder;
	}
	public void setOverUnder(BigDecimal overUnder) {
		this.overUnder = overUnder;
	}
	public BigDecimal getNetDepositAmount() {
		return netDepositAmount;
	}
	public void setNetDepositAmount(BigDecimal netDepositAmount) {
		this.netDepositAmount = netDepositAmount;
	}
	public BigDecimal getEmployeesStraightHours() {
		return employeesStraightHours;
	}
	public void setEmployeesStraightHours(BigDecimal employeesStraightHours) {
		this.employeesStraightHours = employeesStraightHours;
	}
	public BigDecimal getEmployeesOvertimeHours() {
		return employeesOvertimeHours;
	}
	public void setEmployeesOvertimeHours(BigDecimal employeesOvertimeHours) {
		this.employeesOvertimeHours = employeesOvertimeHours;
	}
	public Integer getDailyMonthlyUnits() {
		return dailyMonthlyUnits;
	}
	public void setDailyMonthlyUnits(Integer dailyMonthlyUnits) {
		this.dailyMonthlyUnits = dailyMonthlyUnits;
	}
	public BigDecimal getDailyMonthlyAmount() {
		return dailyMonthlyAmount;
	}
	public void setDailyMonthlyAmount(BigDecimal dailyMonthlyAmount) {
		this.dailyMonthlyAmount = dailyMonthlyAmount;
	}
	public BigDecimal getEventSalesTaxAmount() {
		return eventSalesTaxAmount;
	}
	public void setEventSalesTaxAmount(BigDecimal eventSalesTaxAmount) {
		this.eventSalesTaxAmount = eventSalesTaxAmount;
	}
	public BigDecimal getEventSalesTaxPerc() {
		return eventSalesTaxPerc;
	}
	public void setEventSalesTaxPerc(BigDecimal eventSalesTaxPerc) {
		this.eventSalesTaxPerc = eventSalesTaxPerc;
	}
	public Long getTallySheetNo() {
		return tallySheetNo;
	}
	public void setTallySheetNo(Long tallySheetNo) {
		this.tallySheetNo = tallySheetNo;
	}
	public LocalDateTime getTallySheetDate() {
		return tallySheetDate;
	}
	public void setTallySheetDate(LocalDateTime tallySheetDate) {
		this.tallySheetDate = tallySheetDate;
	}
	public BigDecimal getEventGrossAmount() {
		return eventGrossAmount;
	}
	public void setEventGrossAmount(BigDecimal eventGrossAmount) {
		this.eventGrossAmount = eventGrossAmount;
	}
	public String getDepositComment() {
		return depositComment;
	}
	public void setDepositComment(String depositComment) {
		this.depositComment = depositComment;
	}
	public Integer getFocusGLID() {
		return focusGLID;
	}
	public void setFocusGLID(Integer focusGLID) {
		this.focusGLID = focusGLID;
	}
	public Integer getBicycleUnits() {
		return bicycleUnits;
	}
	public void setBicycleUnits(Integer bicycleUnits) {
		this.bicycleUnits = bicycleUnits;
	}
	public BigDecimal getBicycleAmount() {
		return bicycleAmount;
	}
	public void setBicycleAmount(BigDecimal bicycleAmount) {
		this.bicycleAmount = bicycleAmount;
	}
	public Integer getTransCashUnits() {
		return transCashUnits;
	}
	public void setTransCashUnits(Integer transCashUnits) {
		this.transCashUnits = transCashUnits;
	}
	public BigDecimal getTransCashAmount() {
		return transCashAmount;
	}
	public void setTransCashAmount(BigDecimal transCashAmount) {
		this.transCashAmount = transCashAmount;
	}
	public Integer getTransCredCdUnits() {
		return transCredCdUnits;
	}
	public void setTransCredCdUnits(Integer transCredCdUnits) {
		this.transCredCdUnits = transCredCdUnits;
	}
	public BigDecimal getTransCredCdAmount() {
		return transCredCdAmount;
	}
	public void setTransCredCdAmount(BigDecimal transCredCdAmount) {
		this.transCredCdAmount = transCredCdAmount;
	}
	public Integer getTransChargeUnits() {
		return transChargeUnits;
	}
	public void setTransChargeUnits(Integer transChargeUnits) {
		this.transChargeUnits = transChargeUnits;
	}
	public BigDecimal getTransChargeAmount() {
		return transChargeAmount;
	}
	public void setTransChargeAmount(BigDecimal transChargeAmount) {
		this.transChargeAmount = transChargeAmount;
	}
	public BigDecimal getBicycleSalesTaxPct() {
		return bicycleSalesTaxPct;
	}
	public void setBicycleSalesTaxPct(BigDecimal bicycleSalesTaxPct) {
		this.bicycleSalesTaxPct = bicycleSalesTaxPct;
	}
	public BigDecimal getBicycleSalesTaxAmt() {
		return bicycleSalesTaxAmt;
	}
	public void setBicycleSalesTaxAmt(BigDecimal bicycleSalesTaxAmt) {
		this.bicycleSalesTaxAmt = bicycleSalesTaxAmt;
	}
	public Boolean getWeekend() {
		return weekend;
	}
	public void setWeekend(Boolean weekend) {
		this.weekend = weekend;
	}
	public BigDecimal getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(BigDecimal processingFee) {
		this.processingFee = processingFee;
	}
	public BigDecimal getTotalNumberDeposits() {
		return totalNumberDeposits;
	}
	public void setTotalNumberDeposits(BigDecimal totalNumberDeposits) {
		this.totalNumberDeposits = totalNumberDeposits;
	}
	public GaragesDTO getGaragesDTO() {
		return garagesDTO;
	}
	public void setGaragesDTO(GaragesDTO garagesDTO) {
		this.garagesDTO = garagesDTO;
	}

	public List<TransientBankDepositDTO> getTransientBankDeposits() {
		return transientBankDeposits;
	}
	public void setTransientBankDeposits(
			List<TransientBankDepositDTO> transientBankDeposits) {
		this.transientBankDeposits = transientBankDeposits;
	}
	@Override
	public String toString() {
		return "TransientsDTO [id=" + id + ", unitsBefore10AM="
				+ unitsBefore10AM + ", unitsAfter10AM=" + unitsAfter10AM
				+ ", unitsAfter6PM=" + unitsAfter6PM + ", totalUnits="
				+ totalUnits + ", closedTickets=" + closedTickets
				+ ", normalGrossAmount=" + normalGrossAmount
				+ ", originalNormalGrossAmount=" + originalNormalGrossAmount
				+ ", normalSalesTaxPerc=" + normalSalesTaxPerc
				+ ", normalSalesTaxAmount=" + normalSalesTaxAmount
				+ ", paidOut=" + paidOut + ", overUnder=" + overUnder
				+ ", netDepositAmount=" + netDepositAmount
				+ ", employeesStraightHours=" + employeesStraightHours
				+ ", employeesOvertimeHours=" + employeesOvertimeHours
				+ ", dailyMonthlyUnits=" + dailyMonthlyUnits
				+ ", dailyMonthlyAmount=" + dailyMonthlyAmount
				+ ", eventSalesTaxAmount=" + eventSalesTaxAmount
				+ ", eventSalesTaxPerc=" + eventSalesTaxPerc
				+ ", tallySheetNo=" + tallySheetNo + ", tallySheetDate="
				+ tallySheetDate + ", eventGrossAmount=" + eventGrossAmount
				+ ", depositComment=" + depositComment + ", focusGLID="
				+ focusGLID + ", bicycleUnits=" + bicycleUnits
				+ ", bicycleAmount=" + bicycleAmount + ", transCashUnits="
				+ transCashUnits + ", transCashAmount=" + transCashAmount
				+ ", transCredCdUnits=" + transCredCdUnits
				+ ", transCredCdAmount=" + transCredCdAmount
				+ ", transChargeUnits=" + transChargeUnits
				+ ", transChargeAmount=" + transChargeAmount
				+ ", bicycleSalesTaxPct=" + bicycleSalesTaxPct
				+ ", bicycleSalesTaxAmt=" + bicycleSalesTaxAmt + ", weekend="
				+ weekend + ", processingFee=" + processingFee
				+ ", totalNumberDeposits=" + totalNumberDeposits
				+ ", garagesDTO=" + garagesDTO + ", transientBankDeposits="
				+ transientBankDeposits + ", createdBy=" + createdBy
				+ ", lastModifiedBy=" + lastModifiedBy + ", createdDate="
				+ createdDate + ", lastModifiedDate=" + lastModifiedDate
				+ ", reasonForUpdate=" + reasonForUpdate + ", locationClosed="
				+ locationClosed + ", reasonForLocClose=" + reasonForLocClose
				+ ", auditAction=" + auditAction + ", isAudited=" + isAudited
				+ ", ttechErrorOrManualTicket=" + ttechErrorOrManualTicket
				+ ", prepaidReservation=" + prepaidReservation
				+ ", isCorrected=" + isCorrected + "]";
	}
	
	
}
