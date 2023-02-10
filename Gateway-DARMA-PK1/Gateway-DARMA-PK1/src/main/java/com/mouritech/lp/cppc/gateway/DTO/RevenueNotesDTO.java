package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class RevenueNotesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String notes;

	private RevenueDTO revenueDTO;

	private StatusEnum status;
	
	private Date createdDate;

	private String createdBy;

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

	public RevenueDTO getRevenueDTO() {
		return revenueDTO;
	}

	public void setRevenueDTO(RevenueDTO revenueDTO) {
		this.revenueDTO = revenueDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RevenueNotesDTO notes = (RevenueNotesDTO) o;
		if (notes.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, notes.id);
	}

	@Override
	public String toString() {
		return "RevenueNotesDTO [id=" + id + ", notes=" + notes
				+ ", revenueDTO=" + revenueDTO + ", status=" + status
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ "]";
	}

	

}
