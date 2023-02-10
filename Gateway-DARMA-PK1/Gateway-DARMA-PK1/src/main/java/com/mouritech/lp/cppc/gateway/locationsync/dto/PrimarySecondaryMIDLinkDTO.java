package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;

public class PrimarySecondaryMIDLinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private MidDTO midDTO;

	private SecondaryMIDDTO secondaryMIDDTO;

	private String secondaryMIDNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MidDTO getMidDTO() {
		return midDTO;
	}

	public void setMidDTO(MidDTO midDTO) {
		this.midDTO = midDTO;
	}

	public SecondaryMIDDTO getSecondaryMIDDTO() {
		return secondaryMIDDTO;
	}

	public void setSecondaryMIDDTO(SecondaryMIDDTO secondaryMIDDTO) {
		this.secondaryMIDDTO = secondaryMIDDTO;
	}

	public String getSecondaryMIDNumber() {
		return secondaryMIDNumber;
	}

	public void setSecondaryMIDNumber(String secondaryMIDNumber) {
		this.secondaryMIDNumber = secondaryMIDNumber;
	}

	@Override
	public String toString() {
		return "PrimarySecondaryMIDLinkDTO [id=" + id + ", midDTO=" + midDTO + ", secondaryMIDDTO=" + secondaryMIDDTO
				+ ", secondaryMIDNumber=" + secondaryMIDNumber + "]";
	}

}
