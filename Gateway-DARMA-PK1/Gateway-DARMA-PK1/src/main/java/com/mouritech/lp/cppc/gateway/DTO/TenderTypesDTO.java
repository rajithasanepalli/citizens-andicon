package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class TenderTypesDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String description;
	private Boolean isPCI;
	private StatusEnum status;
	private String GlCode;
	private Set<TenderTypesLocationLinkDTO> tenderTypesLnkDTO = new HashSet<>();
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

	public Boolean getIsPCI() {
		return isPCI;
	}

	public void setIsPCI(Boolean isPCI) {
		this.isPCI = isPCI;
	}
	
	

	public Set<TenderTypesLocationLinkDTO> getTenderTypesLnkDTO() {
		return tenderTypesLnkDTO;
	}

	public void setTenderTypesLnkDTO(
			Set<TenderTypesLocationLinkDTO> tenderTypesLnkDTO) {
		this.tenderTypesLnkDTO = tenderTypesLnkDTO;
	}

	public String getGlCode() {
		return GlCode;
	}

	public void setGlCode(String glCode) {
		GlCode = glCode;
	}

	@Override
	public String toString() {
		return "TenderTypesDTO [id=" + id + ", code=" + code + ", description=" + description + ", isPCI=" + isPCI
				+ ", status=" + status + ", GlCode=" + GlCode + ", tenderTypesLnkDTO=" + tenderTypesLnkDTO + "]";
	}



}
