package com.mouritech.lp.cppc.gateway.DTO;

import java.util.List;

public class PdfVarianceExplanation {

	private PdfVariance[] variances;

	private String monthYear;

	private PdfLocation location;

	private List<GlCategoryDTO> glCategoryDTO;

	public PdfVariance[] getVariances() {
		return variances;
	}

	public void setVariances(PdfVariance[] variances) {
		this.variances = variances;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public PdfLocation getLocation() {
		return location;
	}

	public void setLocation(PdfLocation location) {
		this.location = location;
	}

	public List<GlCategoryDTO> getGlCategoryDTO() {
		return glCategoryDTO;
	}

	public void setGlCategoryDTO(List<GlCategoryDTO> glCategoryDTO) {
		this.glCategoryDTO = glCategoryDTO;
	}

	@Override
	public String toString() {
		return "ClassPojo [variances = " + variances + ", monthYear = " + monthYear + ", location = " + location + "]";
	}
}
