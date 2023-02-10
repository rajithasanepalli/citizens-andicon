package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Size;

public class FinancialYearDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private Integer year;

	private Float yearPercent;

	private BigDecimal yearAmount;

	private Float overallPercent;

	@Size(max = 4000)
	private String notes;

	private FinancialServicesDTO financialServicesDTO;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Float getYearPercent() {
		return yearPercent;
	}

	public void setYearPercent(Float yearPercent) {
		this.yearPercent = yearPercent;
	}

	public BigDecimal getYearAmount() {
		return yearAmount;
	}

	public void setYearAmount(BigDecimal yearAmount) {
		this.yearAmount = yearAmount;
	}

	public Float getOverallPercent() {
		return overallPercent;
	}

	public void setOverallPercent(Float overallPercent) {
		this.overallPercent = overallPercent;
	}


	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public FinancialServicesDTO getFinancialServicesDTO() {
		return financialServicesDTO;
	}

	public void setFinancialServicesDTO(FinancialServicesDTO financialServicesDTO) {
		this.financialServicesDTO = financialServicesDTO;
	}
	
	
}
