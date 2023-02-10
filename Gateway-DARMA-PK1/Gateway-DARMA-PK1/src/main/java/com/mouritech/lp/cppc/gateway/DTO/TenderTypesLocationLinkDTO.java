package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class TenderTypesLocationLinkDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private TenderTypesDTO tenderTypesDTO;
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

	public TenderTypesDTO getTenderTypesDTO() {
		return tenderTypesDTO;
	}

	public void setTenderTypesDTO(TenderTypesDTO tenderTypesDTO) {
		this.tenderTypesDTO = tenderTypesDTO;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	@Override
	public String toString() {
		return "TenderTypesLocationLinkDTO [id=" + id + ", tenderTypesDTO="
				+ tenderTypesDTO + ", locationDTO=" + locationDTO + "]";
	}

}
