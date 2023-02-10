package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class FinancialServicesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String type;

	private String description;

	private String ancillaryBucket;

	private String cGlMnaCode;

	private String cGlNmnaCode;

	private String dGLCode;

	private Set<FinancialYearDTO> financialYearDTO = new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAncillaryBucket() {
		return ancillaryBucket;
	}

	public void setAncillaryBucket(String ancillaryBucket) {
		this.ancillaryBucket = ancillaryBucket;
	}

	public String getcGlMnaCode() {
		return cGlMnaCode;
	}

	public void setcGlMnaCode(String cGlMnaCode) {
		this.cGlMnaCode = cGlMnaCode;
	}

	public String getcGlNmnaCode() {
		return cGlNmnaCode;
	}

	public void setcGlNmnaCode(String cGlNmnaCode) {
		this.cGlNmnaCode = cGlNmnaCode;
	}

	public String getdGLCode() {
		return dGLCode;
	}

	public void setdGLCode(String dGLCode) {
		this.dGLCode = dGLCode;
	}

	public Set<FinancialYearDTO> getFinancialYearDTO() {
		return financialYearDTO;
	}

	public void setFinancialYearDTO(Set<FinancialYearDTO> financialYearDTO) {
		this.financialYearDTO = financialYearDTO;
	}

	@Override
	public String toString() {
		return "FinancialServicesDTO [id=" + id + ", type=" + type
				+ ", description=" + description + ", ancillaryBucket="
				+ ancillaryBucket + ", cGlMnaCode=" + cGlMnaCode
				+ ", cGlNmnaCode=" + cGlNmnaCode + ", dGLCode=" + dGLCode
				+ ", financialYearDTO=" + financialYearDTO + "]";
	}
	
	

}
