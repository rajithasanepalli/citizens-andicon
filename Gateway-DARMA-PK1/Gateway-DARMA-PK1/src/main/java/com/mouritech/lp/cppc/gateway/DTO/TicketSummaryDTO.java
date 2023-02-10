package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TicketSummaryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String locations;

	private String locationId;

	private List<PerDate> perDate = new ArrayList<PerDate>();

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public List<PerDate> getPerDate() {
		return perDate;
	}

	public void setPerDate(List<PerDate> perDate) {
		this.perDate = perDate;
	}

}
