package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SecondaryMIDDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String secondaryMID;

	private Set<PrimarySecondaryMIDLinkDTO> primarySecondaryMIDLink = new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecondaryMID() {
		return secondaryMID;
	}

	public void setSecondaryMID(String secondaryMID) {
		this.secondaryMID = secondaryMID;
	}

	public Set<PrimarySecondaryMIDLinkDTO> getPrimarySecondaryMIDLink() {
		return primarySecondaryMIDLink;
	}

	public void setPrimarySecondaryMIDLink(Set<PrimarySecondaryMIDLinkDTO> primarySecondaryMIDLink) {
		this.primarySecondaryMIDLink = primarySecondaryMIDLink;
	}

}
