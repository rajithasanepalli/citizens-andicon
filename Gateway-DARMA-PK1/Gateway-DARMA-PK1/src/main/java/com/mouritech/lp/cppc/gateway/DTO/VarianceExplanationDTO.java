package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class VarianceExplanationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private Integer month;

	private Integer year;

	private String locationId;

	private String glCode;

	private String description;

	private String varianceExplanation;

	private StatusEnum status;

	private String glDescSortOrder;
	
	private String glCodeFiscal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getGlCode() {
		return glCode;
	}

	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVarianceExplanation() {
		return varianceExplanation;
	}

	public void setVarianceExplanation(String varianceExplanation) {
		this.varianceExplanation = varianceExplanation;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getGlDescSortOrder() {
		return glDescSortOrder;
	}

	public void setGlDescSortOrder(String glDescSortOrder) {
		this.glDescSortOrder = glDescSortOrder;
	}

	public String getGlCodeFiscal() {
		return glCodeFiscal;
	}

	public void setGlCodeFiscal(String glCodeFiscal) {
		this.glCodeFiscal = glCodeFiscal;
	}

	@Override
	public String toString() {
		return "VarianceExplanationDTO [id=" + id + ", month=" + month + ", year=" + year + ", locationId=" + locationId
				+ ", glCode=" + glCode + ", description=" + description + ", varianceExplanation=" + varianceExplanation
				+ ", status=" + status + ", glDescSortOrder=" + glDescSortOrder + "]";
	}

}
