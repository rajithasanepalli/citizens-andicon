package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

@Entity
@Table(name = "NOTES")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LocationNotesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String noteHeading;

	private String notes;

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

	public String getNoteHeading() {
		return noteHeading;
	}

	public void setNoteHeading(String noteHeading) {
		this.noteHeading = noteHeading;
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

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LocationNotesDTO notes = (LocationNotesDTO) o;
		if (notes.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, notes.id);
	}

	@Override
	public String toString() {
		return "LocationNotesDTO [id=" + id + ", noteHeading=" + noteHeading
				+ ", notes=" + notes + ", locationDTO=" + locationDTO + "]";
	}

}
