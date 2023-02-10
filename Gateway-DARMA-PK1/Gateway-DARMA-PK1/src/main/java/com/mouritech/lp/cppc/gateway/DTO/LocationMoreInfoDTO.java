package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class LocationMoreInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String contractHours;

	private String managementGroup;

	private String expires;

	private LocalDateTime revisionDate;

	private LocalDateTime actionDate;

	private LocalDateTime contractPeriodFrom;

	private LocalDateTime contractPeriodTo;

	private LocalDateTime lastDateContractRevised;

	private Double contractedAnnualHours;

	private String vertical;

	private String oldLocationID;

	private String sVP;

	private String rVP;

	private String SubsidyMonthlyRate;

	private String pONumber;
	private LocalDateTime openDate;
	private LocalDateTime closeDate;
	
	private StatusEnum status;

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

	public String getContractHours() {
		return contractHours;
	}

	public void setContractHours(String contractHours) {
		this.contractHours = contractHours;
	}

	public String getManagementGroup() {
		return managementGroup;
	}

	public void setManagementGroup(String managementGroup) {
		this.managementGroup = managementGroup;
	}

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		this.expires = expires;
	}

	public LocalDateTime getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(LocalDateTime revisionDate) {
		this.revisionDate = revisionDate;
	}

	public LocalDateTime getActionDate() {
		return actionDate;
	}

	public void setActionDate(LocalDateTime actionDate) {
		this.actionDate = actionDate;
	}

	public LocalDateTime getContractPeriodFrom() {
		return contractPeriodFrom;
	}

	public void setContractPeriodFrom(LocalDateTime contractPeriodFrom) {
		this.contractPeriodFrom = contractPeriodFrom;
	}

	public LocalDateTime getContractPeriodTo() {
		return contractPeriodTo;
	}

	public void setContractPeriodTo(LocalDateTime contractPeriodTo) {
		this.contractPeriodTo = contractPeriodTo;
	}

	public LocalDateTime getLastDateContractRevised() {
		return lastDateContractRevised;
	}

	public void setLastDateContractRevised(LocalDateTime lastDateContractRevised) {
		this.lastDateContractRevised = lastDateContractRevised;
	}

	public Double getContractedAnnualHours() {
		return contractedAnnualHours;
	}

	public void setContractedAnnualHours(Double contractedAnnualHours) {
		this.contractedAnnualHours = contractedAnnualHours;
	}

	public String getVertical() {
		return vertical;
	}

	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	public String getOldLocationID() {
		return oldLocationID;
	}

	public void setOldLocationID(String oldLocationID) {
		this.oldLocationID = oldLocationID;
	}

	public String getsVP() {
		return sVP;
	}

	public void setsVP(String sVP) {
		this.sVP = sVP;
	}

	public String getrVP() {
		return rVP;
	}

	public void setrVP(String rVP) {
		this.rVP = rVP;
	}

	public String getSubsidyMonthlyRate() {
		return SubsidyMonthlyRate;
	}

	public void setSubsidyMonthlyRate(String subsidyMonthlyRate) {
		SubsidyMonthlyRate = subsidyMonthlyRate;
	}

	public String getpONumber() {
		return pONumber;
	}

	public void setpONumber(String pONumber) {
		this.pONumber = pONumber;
	}

	public LocalDateTime getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDateTime openDate) {
		this.openDate = openDate;
	}

	public LocalDateTime getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	@Override
	public String toString() {
		return "LocationMoreInfoDTO [id=" + id + ", contractHours=" + contractHours + ", managementGroup="
				+ managementGroup + ", expires=" + expires + ", revisionDate=" + revisionDate + ", actionDate="
				+ actionDate + ", contractPeriodFrom=" + contractPeriodFrom + ", contractPeriodTo=" + contractPeriodTo
				+ ", lastDateContractRevised=" + lastDateContractRevised + ", contractedAnnualHours="
				+ contractedAnnualHours + ", vertical=" + vertical + ", oldLocationID=" + oldLocationID + ", sVP=" + sVP
				+ ", rVP=" + rVP + ", SubsidyMonthlyRate=" + SubsidyMonthlyRate + ", pONumber=" + pONumber
				+ ", openDate=" + openDate + ", closeDate=" + closeDate + "]";
	}



}
