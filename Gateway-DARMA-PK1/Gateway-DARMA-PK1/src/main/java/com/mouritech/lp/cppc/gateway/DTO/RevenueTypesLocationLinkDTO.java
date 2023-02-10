package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class RevenueTypesLocationLinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private RevenueTypesDTO revenueTypesDTO;
	private LocationDTO locationDTO;
	
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

	public RevenueTypesDTO getRevenueTypesDTO() {
		return revenueTypesDTO;
	}

	public void setRevenueTypesDTO(RevenueTypesDTO revenueTypesDTO) {
		this.revenueTypesDTO = revenueTypesDTO;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}



}
