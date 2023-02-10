package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class VehiclePositionDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String positionShortCode;

	private String positionName;
	
	private Set<VCRdetailsDTO>vcrdetailsDTO  = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPositionShortCode() {
		return positionShortCode;
	}

	public void setPositionShortCode(String positionShortCode) {
		this.positionShortCode = positionShortCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Set<VCRdetailsDTO> getVcrdetailsDTO() {
		return vcrdetailsDTO;
	}

	public void setVcrdetailsDTO(Set<VCRdetailsDTO> vcrdetailsDTO) {
		this.vcrdetailsDTO = vcrdetailsDTO;
	}

	
	
	
}