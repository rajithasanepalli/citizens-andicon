package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mouritech.lp.cppc.gateway.DTO.LocationDTO;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class EntitiesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String entityName;

	private boolean deleted;

	private String primaryContactId;

	private String notes;

	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	private List<LocationDTO> locationDTO = new ArrayList<>();

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<LocationDTO> getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(List<LocationDTO> locationDTO) {
		this.locationDTO = locationDTO;
	}

	@Override
	public String toString() {
		return "Entities [EntityId=" + id + ", EntityName=" + entityName + ", Deleted=" + deleted
				+ ", PrimaryContactID=" + primaryContactId + ", Notes=" + notes + "]";
	}
}
