package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class GlCategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String glCategory;

	private List<GlGroupDTO> glGroup;

	private BigDecimal totalGLCategoryActual;

	private BigDecimal totalGLCategoryBudget;

	private BigDecimal totalGLCategoryCurrentVariance;

	private BigDecimal totalGLCategoryVariancePercent;

	public String getGlCategory() {
		return glCategory;
	}

	public void setGlCategory(String glCategory) {
		this.glCategory = glCategory;
	}

	public List<GlGroupDTO> getGlGroup() {
		return glGroup;
	}

	public void setGlGroup(List<GlGroupDTO> glGroup) {
		this.glGroup = glGroup;
	}

	public BigDecimal getTotalGLCategoryActual() {
		return totalGLCategoryActual;
	}

	public void setTotalGLCategoryActual(BigDecimal totalGLCategoryActual) {
		this.totalGLCategoryActual = totalGLCategoryActual;
	}

	public BigDecimal getTotalGLCategoryBudget() {
		return totalGLCategoryBudget;
	}

	public void setTotalGLCategoryBudget(BigDecimal totalGLCategoryBudget) {
		this.totalGLCategoryBudget = totalGLCategoryBudget;
	}

	public BigDecimal getTotalGLCategoryCurrentVariance() {
		return totalGLCategoryCurrentVariance;
	}

	public void setTotalGLCategoryCurrentVariance(BigDecimal totalGLCategoryCurrentVariance) {
		this.totalGLCategoryCurrentVariance = totalGLCategoryCurrentVariance;
	}

	public BigDecimal getTotalGLCategoryVariancePercent() {
		return totalGLCategoryVariancePercent;
	}

	public void setTotalGLCategoryVariancePercent(BigDecimal totalGLCategoryVariancePercent) {
		this.totalGLCategoryVariancePercent = totalGLCategoryVariancePercent;
	}

}
