package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GlGroupDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String glGroup;

	private List<GLDescriptionDTO> glDescriptionDTO = new ArrayList<>();

	private BigDecimal totalActual;

	private BigDecimal totalBudget;

	private BigDecimal totalCurrentVariance;

	private BigDecimal totalVariancePercent;
	
	private Integer glGroupSortOrder;

	public String getGlGroup() {
		return glGroup;
	}

	public void setGlGroup(String glGroup) {
		this.glGroup = glGroup;
	}

	public List<GLDescriptionDTO> getGlDescriptionDTO() {
		return glDescriptionDTO;
	}

	public void setGlDescriptionDTO(List<GLDescriptionDTO> glDescriptionDTO) {
		this.glDescriptionDTO = glDescriptionDTO;
	}

	public BigDecimal getTotalActual() {
		return totalActual;
	}

	public void setTotalActual(BigDecimal totalActual) {
		this.totalActual = totalActual;
	}

	public BigDecimal getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(BigDecimal totalBudget) {
		this.totalBudget = totalBudget;
	}

	public BigDecimal getTotalCurrentVariance() {
		return totalCurrentVariance;
	}

	public void setTotalCurrentVariance(BigDecimal totalCurrentVariance) {
		this.totalCurrentVariance = totalCurrentVariance;
	}

	public BigDecimal getTotalVariancePercent() {
		return totalVariancePercent;
	}

	public void setTotalVariancePercent(BigDecimal totalVariancePercent) {
		this.totalVariancePercent = totalVariancePercent;
	}

	public Integer getGlGroupSortOrder() {
		return glGroupSortOrder;
	}

	public void setGlGroupSortOrder(Integer glGroupSortOrder) {
		this.glGroupSortOrder = glGroupSortOrder;
	}

}
