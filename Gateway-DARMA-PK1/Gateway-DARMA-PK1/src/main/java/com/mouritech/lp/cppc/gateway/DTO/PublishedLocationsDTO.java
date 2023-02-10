package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;


/**
 * Specific for multiple location search in External portal
 */
public class PublishedLocationsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String locationNumber;
	
	private String locationID;

	private Boolean published;

	private Integer month;

	private Integer year;

	public String getLocationNumber() {
		return locationNumber;
	}

	public void setLocationNumber(String locationNumber) {
		this.locationNumber = locationNumber;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
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
		return "PublishedLocationsDTO [locationNumber=" + locationNumber
				+ ", locationID=" + locationID + ", published=" + published
				+ ", month=" + month + ", year=" + year + "]";
	}
}
