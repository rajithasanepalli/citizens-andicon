package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.LocationDTO;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class LocationMIDLinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String notes;

	private LocationDTO locationDTO;

	private MidDTO midDTO;

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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public MidDTO getMidDTO() {
		return midDTO;
	}

	public void setMidDTO(MidDTO midDTO) {
		this.midDTO = midDTO;
	}

	@Override
	public String toString() {
		return "LocationMidDTOLink [id=" + id + ", Notes=" + notes + ", LocationDTO=" + locationDTO + ", MidDTO="
				+ midDTO + "]";
	}
}
