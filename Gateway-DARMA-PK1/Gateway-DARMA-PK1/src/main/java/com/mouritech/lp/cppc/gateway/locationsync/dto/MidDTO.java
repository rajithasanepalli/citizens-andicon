package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class MidDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String primaryMID;

	private String notes;

	private boolean deleted;

	private boolean active;

	private ProcessorDTO processorDTO;

	private Set<LocationMIDLinkDTO> locationMIDLinkDTO = new HashSet<>();

	private StatusEnum status;

	private String lastUpdatedBy;

	private Set<PrimarySecondaryMIDLinkDTO> primarySecondaryMIDLinkDTO = new HashSet<>();

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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ProcessorDTO getProcessorDTO() {
		return processorDTO;
	}

	public void setProcessorDTO(ProcessorDTO processorDTO) {
		this.processorDTO = processorDTO;
	}

	public Set<LocationMIDLinkDTO> getLocationMIDLinkDTO() {
		return locationMIDLinkDTO;
	}

	public void setLocationMIDLinkDTO(Set<LocationMIDLinkDTO> locationMIDLinkDTO) {
		this.locationMIDLinkDTO = locationMIDLinkDTO;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Set<PrimarySecondaryMIDLinkDTO> getPrimarySecondaryMIDLinkDTO() {
		return primarySecondaryMIDLinkDTO;
	}

	public void setPrimarySecondaryMIDLinkDTO(Set<PrimarySecondaryMIDLinkDTO> primarySecondaryMIDLinkDTO) {
		this.primarySecondaryMIDLinkDTO = primarySecondaryMIDLinkDTO;
	}

	public String getPrimaryMID() {
		return primaryMID;
	}

	public void setPrimaryMID(String primaryMID) {
		this.primaryMID = primaryMID;
	}

	@Override
	public String toString() {
		return "MidDTO [id=" + id + ", primaryMID=" + primaryMID + ", notes=" + notes + ", deleted=" + deleted
				+ ", active=" + active + ", processorDTO=" + processorDTO + ", locationMIDLinkDTO=" + locationMIDLinkDTO
				+ ", status=" + status + ", lastUpdatedBy=" + lastUpdatedBy + ", primarySecondaryMIDLinkDTO="
				+ primarySecondaryMIDLinkDTO + "]";
	}

}
