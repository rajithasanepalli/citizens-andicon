package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class vwAllocationsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String jobDescription;

	private String companyName;

	private String locationId;

	private String type;

	private Double dPercentage;

	private String dGL;

	private String dEorC;

	private String dOffsetEorC;

	private Double cPercentage;

	private String cGL;

	private String cEorC;

	private String cOffsetEorC;

	private Integer year;

	private String managed;

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getManaged() {
		return managed;
	}

	public void setManaged(String managed) {
		this.managed = managed;
	}

	@Override
	public String toString() {
		return "vwAllocationsDTO [id=" + id + ", jobDescription="
				+ jobDescription + ", companyName=" + companyName
				+ ", locationId=" + locationId + ", type=" + type
				+ ", dPercentage=" + dPercentage + ", dGL=" + dGL + ", dEorC="
				+ dEorC + ", dOffsetEorC=" + dOffsetEorC + ", cPercentage="
				+ cPercentage + ", cGL=" + cGL + ", cEorC=" + cEorC
				+ ", cOffsetEorC=" + cOffsetEorC + ", year=" + year
				+ ", managed=" + managed + "]";
	}

}
