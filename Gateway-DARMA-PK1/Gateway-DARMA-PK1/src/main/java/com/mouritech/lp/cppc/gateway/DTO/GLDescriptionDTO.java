package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class GLDescriptionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer glCode;

	private String description;

	private BigDecimal actual;

	private BigDecimal budget;

	private BigDecimal currentVariance;

	private BigDecimal varinacePercent;
	
	private Integer descriptionSortOrder;
	
	private String glCodeFiscal;
	
	private String varianceExplanation;

	public Integer getGlCode() {
		return glCode;
	}

	public void setGlCode(Integer glCode) {
		this.glCode = glCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getActual() {
		return actual;
	}

	public void setActual(BigDecimal actual) {
		this.actual = actual;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public BigDecimal getCurrentVariance() {
		return currentVariance;
	}

	public void setCurrentVariance(BigDecimal currentVariance) {
		this.currentVariance = currentVariance;
	}

	public BigDecimal getVarinacePercent() {
		return varinacePercent;
	}

	public void setVarinacePercent(BigDecimal varinacePercent) {
		this.varinacePercent = varinacePercent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getDescriptionSortOrder() {
		return descriptionSortOrder;
	}

	public void setDescriptionSortOrder(Integer descriptionSortOrder) {
		this.descriptionSortOrder = descriptionSortOrder;
	}

	public String getGlCodeFiscal() {
		return glCodeFiscal;
	}

	public void setGlCodeFiscal(String glCodeFiscal) {
		this.glCodeFiscal = glCodeFiscal;
	}

	public String getVarianceExplanation() {
		return varianceExplanation;
	}

	public void setVarianceExplanation(String varianceExplanation) {
		this.varianceExplanation = varianceExplanation;
	}
}
