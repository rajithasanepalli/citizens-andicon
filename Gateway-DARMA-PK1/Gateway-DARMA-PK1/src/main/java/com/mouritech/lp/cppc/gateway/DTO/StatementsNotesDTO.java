package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.Date;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class StatementsNotesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String notes;

	private StatementsDTO statementsDTO;

	private StatusEnum status;

	private Date createdDate;

	private String createdBy;

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

	public StatementsDTO getStatements() {
		return statementsDTO;
	}

	public void setStatements(StatementsDTO statements) {
		this.statementsDTO = statements;
	}

	public StatementsDTO getStatementsDTO() {
		return statementsDTO;
	}

	public void setStatementsDTO(StatementsDTO statementsDTO) {
		this.statementsDTO = statementsDTO;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
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
	public String toString() {
		return "StatementsNotesDTO [id=" + id + ", notes=" + notes
				+ ", statementsDTO=" + statementsDTO + ", status=" + status
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ "]";
	}

}
