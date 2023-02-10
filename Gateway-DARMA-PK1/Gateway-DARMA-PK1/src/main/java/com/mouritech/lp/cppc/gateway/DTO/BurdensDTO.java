package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class BurdensDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String jobDescription;

	private String type;

	private Double dPercentage;

	private String dGL;

	private String dEorC;

	private String dOffsetEorC;

	private Double cPercentage;

	private String cGL;

	private String cEorC;

	private String cOffsetEorC;

	private String offsettingAccount;

	private String includingTips;
	private LocationDTO locationDTO;

	private StatusEnum status;
	private String locId;

	private String intracoGLClode;

	private String lSIChargeOut;
	
	private String revPercentage;

	private String rateNew;

	private String locChargeOut;

	private String revGl;

	private String segmentCode;
	
	private Boolean debitAndCreditEqual;
	

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

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getdPercentage() {
		return dPercentage;
	}

	public void setdPercentage(Double dPercentage) {
		this.dPercentage = dPercentage;
	}

	public String getdGL() {
		return dGL;
	}

	public void setdGL(String dGL) {
		this.dGL = dGL;
	}

	public String getdEorC() {
		return dEorC;
	}

	public void setdEorC(String dEorC) {
		this.dEorC = dEorC;
	}

	public String getdOffsetEorC() {
		return dOffsetEorC;
	}

	public void setdOffsetEorC(String dOffsetEorC) {
		this.dOffsetEorC = dOffsetEorC;
	}

	public Double getcPercentage() {
		return cPercentage;
	}

	public void setcPercentage(Double cPercentage) {
		this.cPercentage = cPercentage;
	}

	public String getcGL() {
		return cGL;
	}

	public void setcGL(String cGL) {
		this.cGL = cGL;
	}

	public String getcEorC() {
		return cEorC;
	}

	public void setcEorC(String cEorC) {
		this.cEorC = cEorC;
	}

	public String getcOffsetEorC() {
		return cOffsetEorC;
	}

	public void setcOffsetEorC(String cOffsetEorC) {
		this.cOffsetEorC = cOffsetEorC;
	}

	public String getOffsettingAccount() {
		return offsettingAccount;
	}

	public void setOffsettingAccount(String offsettingAccount) {
		this.offsettingAccount = offsettingAccount;
	}

	public String getIncludingTips() {
		return includingTips;
	}

	public void setIncludingTips(String includingTips) {
		this.includingTips = includingTips;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public String getLocId() {
		return locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	public String getIntracoGLClode() {
		return intracoGLClode;
	}

	public void setIntracoGLClode(String intracoGLClode) {
		this.intracoGLClode = intracoGLClode;
	}

	public String getlSIChargeOut() {
		return lSIChargeOut;
	}

	public void setlSIChargeOut(String lSIChargeOut) {
		this.lSIChargeOut = lSIChargeOut;
	}

	public String getRateNew() {
		return rateNew;
	}

	public void setRateNew(String rateNew) {
		this.rateNew = rateNew;
	}

	public String getLocChargeOut() {
		return locChargeOut;
	}

	public void setLocChargeOut(String locChargeOut) {
		this.locChargeOut = locChargeOut;
	}

	public String getRevGl() {
		return revGl;
	}

	public void setRevGl(String revGl) {
		this.revGl = revGl;
	}

	public String getSegmentCode() {
		return segmentCode;
	}

	public void setSegmentCode(String segmentCode) {
		this.segmentCode = segmentCode;
	}

	public String getRevPercentage() {
		return revPercentage;
	}

	public void setRevPercentage(String revPercentage) {
		this.revPercentage = revPercentage;
	}

	public Boolean getDebitAndCreditEqual() {
		return debitAndCreditEqual;
	}

	public void setDebitAndCreditEqual(Boolean debitAndCreditEqual) {
		this.debitAndCreditEqual = debitAndCreditEqual;
	}

	@Override
	public String toString() {
		return "BurdensDTO [id=" + id + ", jobDescription=" + jobDescription + ", type=" + type + ", dPercentage="
				+ dPercentage + ", dGL=" + dGL + ", dEorC=" + dEorC + ", dOffsetEorC=" + dOffsetEorC + ", cPercentage="
				+ cPercentage + ", cGL=" + cGL + ", cEorC=" + cEorC + ", cOffsetEorC=" + cOffsetEorC
				+ ", offsettingAccount=" + offsettingAccount + ", includingTips=" + includingTips + ", locationDTO="
				+ locationDTO + ", status=" + status + ", locId=" + locId + ", intracoGLClode=" + intracoGLClode
				+ ", lSIChargeOut=" + lSIChargeOut + ", revPercentage=" + revPercentage + ", rateNew=" + rateNew
				+ ", locChargeOut=" + locChargeOut + ", revGl=" + revGl + ", segmentCode=" + segmentCode
				+ ", debitAndCreditEqual=" + debitAndCreditEqual + "]";
	}





}
