package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class StatusLocationsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private String locationNumber;
	// private String locationName;
	private Integer month;
	private Integer year;
	// private String locationId;
	private String statementId;
	private LocationDTO location;

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getStatementId() {
		return statementId;
	}

	public void setStatementId(String statementId) {
		this.statementId = statementId;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

}
