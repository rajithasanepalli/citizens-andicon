package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class VendorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String vendorName;

	private boolean deleted;

	private String primaryContactId;

	private String notes;

	private AddressDTO address;

	private Set<LocationVendorLinkDTO> locationVendorLinkDTO = new HashSet<>();

	private Set<PARCsVendorLinkDTO> parcsVendorLinkDTO = new HashSet<>();

	private StatusEnum status;

	private String lastUpdatedBy;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getPrimaryContactId() {
		return primaryContactId;
	}

	public void setPrimaryContactId(String primaryContactId) {
		this.primaryContactId = primaryContactId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Set<LocationVendorLinkDTO> getLocationVendorLinkDTO() {
		return locationVendorLinkDTO;
	}

	public void setLocationVendorLinkDTO(Set<LocationVendorLinkDTO> locationVendorLinkDTO) {
		this.locationVendorLinkDTO = locationVendorLinkDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<PARCsVendorLinkDTO> getParcsVendorLinkDTO() {
		return parcsVendorLinkDTO;
	}

	public void setParcsVendorLinkDTO(Set<PARCsVendorLinkDTO> parcsVendorLinkDTO) {
		this.parcsVendorLinkDTO = parcsVendorLinkDTO;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

}
