package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.LocationDTO;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class LocationVendorLinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private LocationDTO locationDTO;

	private VendorDTO vendorDTO;

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

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public VendorDTO getVendorDTO() {
		return vendorDTO;
	}

	public void setVendorDTO(VendorDTO vendorDTO) {
		this.vendorDTO = vendorDTO;
	}

	@Override
	public String toString() {
		return "LocationVendorLink [id=" + id + ", LocationDTO=" + locationDTO + ", VendorDTO=" + vendorDTO + "]";
	}
}
