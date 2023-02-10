package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class StatementViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String locationID;

	private Integer month;

	private Integer year;

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

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

	@Override
	public String toString() {
		return "StatementViewDTO [locationID=" + locationID + ", month="
				+ month + ", year=" + year + "]";
	}

}
