package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class ParcsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String parcsName;

	private String notes;

	private boolean deleted;

	private Set<PARCsVendorLinkDTO> parcsVendorDTOLink = new HashSet<>();

	private StatusEnum status;

	private String lastUpdatedBy;

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

	public String getParcsName() {
		return parcsName;
	}

	public void setParcsName(String parcsName) {
		this.parcsName = parcsName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Set<PARCsVendorLinkDTO> getParsCsVendorDTOLink() {
		return parcsVendorDTOLink;
	}

	public void setParsCsVendorDTOLink(Set<PARCsVendorLinkDTO> parcsVendorDTOLink) {
		this.parcsVendorDTOLink = parcsVendorDTOLink;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Override
	public String toString() {
		return "PARCS [PARCSId=" + id + ", PARCSName=" + parcsName + ", Notes=" + notes + ",  Deleted=" + deleted
				+ ", PARCsVendorDTOLink=" + parcsVendorDTOLink + "]";
	}
}
