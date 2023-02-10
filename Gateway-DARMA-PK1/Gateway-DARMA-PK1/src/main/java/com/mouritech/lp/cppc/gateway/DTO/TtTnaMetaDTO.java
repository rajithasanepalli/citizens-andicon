package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mouritech.lp.cppc.gateway.util.CustomDateTimeSerializer;

/**
 * A TT_TNA_META DTO.
 */
public class TtTnaMetaDTO implements Serializable {

	private static final long serialVersionUID = 4662545482775601787L;
	@JsonIgnore
	private String id;

	@Size(max = 36)
	@JsonIgnore
	private String sessionId;

	@Size(max = 36)
	@NotNull(message = "locationId is required")
	@NotBlank(message = "locationId should not be Blank or Null")
	private String locationId;

	@Size(max = 36)
	private String approverId;

	@NotNull(message = "dateRecievedOn is required")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime dateRecievedOn;

	@NotNull(message = "payWeek is required")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime payWeek;

	@Valid
	@NotNull
	@NotEmpty
	private List<TtTnaEmpDTO> tttnaemp = new ArrayList<TtTnaEmpDTO>();

	@JsonIgnore
	private Date createdDate;
	@JsonIgnore
	private String createdBy;
	@JsonIgnore
	private Date lastUpdatedDate;
	@JsonIgnore
	private String lastUpdatedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public LocalDateTime getDateRecievedOn() {
		return dateRecievedOn;
	}

	public void setDateRecievedOn(LocalDateTime dateRecievedOn) {
		this.dateRecievedOn = dateRecievedOn;
	}

	public LocalDateTime getPayWeek() {
		return payWeek;
	}

	public void setPayWeek(LocalDateTime payWeek) {
		this.payWeek = payWeek;
	}

	public List<TtTnaEmpDTO> getTttnaemp() {
		return tttnaemp;
	}

	public void setTttnaemp(List<TtTnaEmpDTO> tttnaemp) {
		this.tttnaemp = tttnaemp;
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

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TtTnaMetaDTO tttnameta = (TtTnaMetaDTO) o;

		if (!Objects.equals(id, tttnameta.id))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "TtTnaMetaDTO [id=" + id + ", sessionId=" + sessionId + ", locationId=" + locationId + ", approverId="
				+ approverId + ", dateRecievedOn=" + dateRecievedOn + ", payWeek=" + payWeek + ", tttnaemp=" + tttnaemp
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

}
