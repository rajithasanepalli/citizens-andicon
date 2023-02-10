package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class PARCsVendorLinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String notes;

	private ParcsDTO parcsDTO;

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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public VendorDTO getVendorDTO() {
		return vendorDTO;
	}

	public void setVendorDTO(VendorDTO vendorDTO) {
		this.vendorDTO = vendorDTO;
	}

	public ParcsDTO getParcsDTO() {
		return parcsDTO;
	}

	public void setParcsDTO(ParcsDTO parcsDTO) {
		this.parcsDTO = parcsDTO;
	}

	@Override
	public String toString() {
		return "LocationVendorLink [id=" + id + ", Notes=" + notes + ", PARCsDTO=" + parcsDTO + ", VendorDTO="
				+ vendorDTO + "]";
	}
}
