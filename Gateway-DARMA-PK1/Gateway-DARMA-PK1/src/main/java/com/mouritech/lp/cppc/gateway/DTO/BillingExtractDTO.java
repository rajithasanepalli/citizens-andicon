package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * A BILLING_EXTRACT DTO.
 */

public class BillingExtractDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1552462442148162536L;

	private String id;

	private String billingExtractFile;
	
	private String payPeriod;

	private Date payDate;

	private String brandCode;
	
	private String locationName;

	private String glString;
	
	private String parentOrgUnitCode;

	private String onsiteDeptName;
	
	private String onsiteDeptDesc;
	
	private String wasOrgCode;
	
	private String wasDeptCode;
	
	private String wasJobCode;

	private String jobName;

	private String billable;

	private String positionCode;

	private String territoryCode;
	
	private Double regularHrs;

	private Double otHolidayHrs;

	private Double totalHrs;
	
	private String dateTime;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getBillingExtractFile() {
		return billingExtractFile;
	}


	public void setBillingExtractFile(String billingExtractFile) {
		this.billingExtractFile = billingExtractFile;
	}

	public String getPayPeriod() {
		return payPeriod;
	}


	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}


	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}


	public String getBrandCode() {
		return brandCode;
	}


	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public String getGlString() {
		return glString;
	}


	public void setGlString(String glString) {
		this.glString = glString;
	}


	public String getParentOrgUnitCode() {
		return parentOrgUnitCode;
	}


	public void setParentOrgUnitCode(String parentOrgUnitCode) {
		this.parentOrgUnitCode = parentOrgUnitCode;
	}


	public String getOnsiteDeptName() {
		return onsiteDeptName;
	}


	public void setOnsiteDeptName(String onsiteDeptName) {
		this.onsiteDeptName = onsiteDeptName;
	}


	public String getOnsiteDeptDesc() {
		return onsiteDeptDesc;
	}


	public void setOnsiteDeptDesc(String onsiteDeptDesc) {
		this.onsiteDeptDesc = onsiteDeptDesc;
	}


	public String getWasOrgCode() {
		return wasOrgCode;
	}


	public void setWasOrgCode(String wasOrgCode) {
		this.wasOrgCode = wasOrgCode;
	}


	public String getWasDeptCode() {
		return wasDeptCode;
	}


	public void setWasDeptCode(String wasDeptCode) {
		this.wasDeptCode = wasDeptCode;
	}


	public String getWasJobCode() {
		return wasJobCode;
	}


	public void setWasJobCode(String wasJobCode) {
		this.wasJobCode = wasJobCode;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getBillable() {
		return billable;
	}


	public void setBillable(String billable) {
		this.billable = billable;
	}


	public String getPositionCode() {
		return positionCode;
	}


	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}


	public String getTerritoryCode() {
		return territoryCode;
	}


	public void setTerritoryCode(String territoryCode) {
		this.territoryCode = territoryCode;
	}


	public Double getRegularHrs() {
		return regularHrs;
	}


	public void setRegularHrs(Double regularHrs) {
		this.regularHrs = regularHrs;
	}


	public Double getOtHolidayHrs() {
		return otHolidayHrs;
	}


	public void setOtHolidayHrs(Double otHolidayHrs) {
		this.otHolidayHrs = otHolidayHrs;
	}


	public Double getTotalHrs() {
		return totalHrs;
	}


	public void setTotalHrs(Double totalHrs) {
		this.totalHrs = totalHrs;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "BillingExtractDTO [id=" + id + ", billingExtractFile=" + billingExtractFile + ", payPeriod=" + payPeriod
				+ ", payDate=" + payDate + ", brandCode=" + brandCode + ", locationName=" + locationName + ", glString="
				+ glString + ", parentOrgUnitCode=" + parentOrgUnitCode + ", onsiteDeptName=" + onsiteDeptName
				+ ", onsiteDeptDesc=" + onsiteDeptDesc + ", wasOrgCode=" + wasOrgCode + ", wasDeptCode=" + wasDeptCode
				+ ", wasJobCode=" + wasJobCode + ", jobName=" + jobName + ", billable=" + billable + ", positionCode="
				+ positionCode + ", territoryCode=" + territoryCode + ", regularHrs=" + regularHrs + ", otHolidayHrs="
				+ otHolidayHrs + ", totalHrs=" + totalHrs + ", dateTime=" + dateTime + "]";
	}

}
