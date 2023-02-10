package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class PositionsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String description;
	private Set<PositionsAndBillingRatesDTO> positionsAndBillingRatesDTO = new HashSet<>();
	
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

	
	public Set<PositionsAndBillingRatesDTO> getRolesAndBillingRatesDTO() {
		return positionsAndBillingRatesDTO;
	}

	public void setRolesAndBillingRatesDTO(Set<PositionsAndBillingRatesDTO> rolesAndBillingRatesDTO) {
		this.positionsAndBillingRatesDTO = rolesAndBillingRatesDTO;
	}

	@Override
	public String toString() {
		return "PositionsDTO [id=" + id + ", code=" + code + ", description=" + description + "]";
	}

}
