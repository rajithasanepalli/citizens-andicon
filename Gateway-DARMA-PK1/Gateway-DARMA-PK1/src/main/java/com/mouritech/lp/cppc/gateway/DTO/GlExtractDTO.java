package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * A GL_EXTRACT DTO.
 */

public class GlExtractDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5628376718793419699L;

	private String id;
	
	private String glExtractFile;

	private Date payDate;

	private String legalEntity;
	
	private String locationId;
	
	private String locationName;
	
	private String departmentCode;

	private String payrollCode;
	
	private String wageCategory;
	
	private String earningCode;
	
	private String earningCodeDesc;
	
	private Double totalHrs;
	
	private String totalHrsStr;

	private String billable;

	private String glMasterAccount;
	
	private String glCategory;

	private String glAccountDesc;
	
	private Double amount;
	
	private String amountStr;
	
	private char bOrG;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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

	public String getGlMasterAccount() {
		return glMasterAccount;
	}

	public void setGlMasterAccount(String glMasterAccount) {
		this.glMasterAccount = glMasterAccount;
	}

	public String getGlCategory() {
		return glCategory;
	}

	public void setGlCategory(String glCategory) {
		this.glCategory = glCategory;
	}

	public String getGlAccountDesc() {
		return glAccountDesc;
	}

	public void setGlAccountDesc(String glAccountDesc) {
		this.glAccountDesc = glAccountDesc;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Double getTotalHrs() {
		return totalHrs;
	}

	public void setTotalHrs(Double totalHrs) {
		this.totalHrs = totalHrs;
	}

	public String getBillable() {
		return billable;
	}

	public void setBillable(String billable) {
		this.billable = billable;
	}

	public char getbOrG() {
		return bOrG;
	}

	public void setbOrG(char bOrG) {
		this.bOrG = bOrG;
	}

	

	public String getTotalHrsStr() {
		return totalHrsStr;
	}

	public void setTotalHrsStr(String totalHrsStr) {
		this.totalHrsStr = totalHrsStr;
	}

	public String getAmountStr() {
		return amountStr;
	}

	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}

	public String getGlExtractFile() {
		return glExtractFile;
	}

	public void setGlExtractFile(String glExtractFile) {
		this.glExtractFile = glExtractFile;
	}

	@Override
	public String toString() {
		return "GlExtractDTO [id=" + id + ", glExtractFileId=" + glExtractFile + ", payDate=" + payDate
				+ ", legalEntity=" + legalEntity + ", locationId=" + locationId + ", locationName=" + locationName
				+ ", departmentCode=" + departmentCode + ", payrollCode=" + payrollCode + ", wageCategory="
				+ wageCategory + ", earningCode=" + earningCode + ", earningCodeDesc=" + earningCodeDesc + ", totalHrs="
				+ totalHrs + ", billable=" + billable + ", glMasterAccount=" + glMasterAccount + ", glCategory="
				+ glCategory + ", glAccountDesc=" + glAccountDesc + ", amount=" + amount + ", bOrG=" + bOrG + "]";
	}

}
