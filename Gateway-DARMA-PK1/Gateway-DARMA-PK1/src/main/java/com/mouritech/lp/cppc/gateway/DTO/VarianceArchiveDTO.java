package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class VarianceArchiveDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String locationId;

	private String glCategory;

	private Integer glCode;

	private String glGroup;

	private Integer month;

	private Integer year;

	private String description;

	private BigDecimal actual;

	private BigDecimal budget;

	private BigDecimal currentvariance;

	private BigDecimal varinacePercent;

	private String glGroupSortOrder;

	private String descSortOrder;

	private String varianceExplanation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getGlCategory() {
		return glCategory;
	}

	public void setGlCategory(String glCategory) {
		this.glCategory = glCategory;
	}

	public Integer getGlCode() {
		return glCode;
	}

	public void setGlCode(Integer glCode) {
		this.glCode = glCode;
	}

	public String getGlGroup() {
		return glGroup;
	}

	public void setGlGroup(String glGroup) {
		this.glGroup = glGroup;
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

	public BigDecimal getCurrentvariance() {
		return currentvariance;
	}

	public void setCurrentvariance(BigDecimal currentvariance) {
		this.currentvariance = currentvariance;
	}

	public String getGlGroupSortOrder() {
		return glGroupSortOrder;
	}

	public void setGlGroupSortOrder(String glGroupSortOrder) {
		this.glGroupSortOrder = glGroupSortOrder;
	}

	public String getDescSortOrder() {
		return descSortOrder;
	}

	public void setDescSortOrder(String descSortOrder) {
		this.descSortOrder = descSortOrder;
	}

	public BigDecimal getVarinacePercent() {
		if (varinacePercent != null) {

			return varinacePercent.multiply(new BigDecimal(100));
		} else {
			return BigDecimal.ZERO;
		}
	}

	public void setVarinacePercent(BigDecimal varinacePercent) {
		this.varinacePercent = varinacePercent;
	}

	public String getVarianceExplanation() {
		return varianceExplanation;
	}

	public void setVarianceExplanation(String varianceExplanation) {
		this.varianceExplanation = varianceExplanation;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		VarianceArchiveDTO other = (VarianceArchiveDTO) obj;

		if (!Objects.equals(id, other.id))
			return false;

		return true;
	}

}
