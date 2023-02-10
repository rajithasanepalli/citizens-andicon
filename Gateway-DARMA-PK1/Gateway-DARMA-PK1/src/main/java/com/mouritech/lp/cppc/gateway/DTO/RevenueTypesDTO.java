package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class RevenueTypesDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String description;
	private String glNumber;
	private String oneGL;
	private String companyName;
	private Set<RevenueTypesLocationLinkDTO> revenueTypesLocationLinkDTO = new HashSet<>();

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGlNumber() {
		return glNumber;
	}

	public void setGlNumber(String glNumber) {
		this.glNumber = glNumber;
	}

	public Set<RevenueTypesLocationLinkDTO> getRevenueTypesLocationLinkDTO() {
		return revenueTypesLocationLinkDTO;
	}

	public void setRevenueTypesLocationLinkDTO(
			Set<RevenueTypesLocationLinkDTO> revenueTypesLocationLinkDTO) {
		this.revenueTypesLocationLinkDTO = revenueTypesLocationLinkDTO;
	}

	public String getOneGL() {
		return oneGL;
	}

	public void setOneGL(String oneGL) {
		this.oneGL = oneGL;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "RevenueTypesDTO [id=" + id + ", code=" + code
				+ ", description=" + description + ", glNumber=" + glNumber
				+ ", oneGL=" + oneGL + ", companyName=" + companyName
				+ ", revenueTypesLocationLinkDTO="
				+ revenueTypesLocationLinkDTO + ", status=" + status + "]";
	}

}
