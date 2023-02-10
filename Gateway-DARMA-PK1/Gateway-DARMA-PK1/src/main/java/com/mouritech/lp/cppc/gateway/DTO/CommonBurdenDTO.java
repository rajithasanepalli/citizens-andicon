package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class CommonBurdenDTO implements Serializable {

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

	private Double includingTips;

	private BrandDTO brandDTO;
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

	public Double getdPercentage() {
		return dPercentage;
	}

	public void setdPercentage(Double dPercentage) {
		this.dPercentage = dPercentage;
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

	public Double getIncludingTips() {
		return includingTips;
	}

	public void setIncludingTips(Double includingTips) {
		this.includingTips = includingTips;
	}

	public BrandDTO getBrandDTO() {
		return brandDTO;
	}

	public void setBrandDTO(BrandDTO brandDTO) {
		this.brandDTO = brandDTO;
	}

	@Override
	public String toString() {
		return "CommonBurdenDTO [id=" + id + ", jobDescription=" + jobDescription + ", type=" + type + ", dPercentage="
				+ dPercentage + ", dGL=" + dGL + ", dEorC=" + dEorC + ", dOffsetEorC=" + dOffsetEorC + ", cPercentage="
				+ cPercentage + ", cGL=" + cGL + ", cEorC=" + cEorC + ", cOffsetEorC=" + cOffsetEorC
				+ ", offsettingAccount=" + offsettingAccount + ", includingTips=" + includingTips + ", brandDTO="
				+ brandDTO + "]";
	}

}
