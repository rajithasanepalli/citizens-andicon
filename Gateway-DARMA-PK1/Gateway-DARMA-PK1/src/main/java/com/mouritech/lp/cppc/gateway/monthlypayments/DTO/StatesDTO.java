package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.views.TallySheetView;

public class StatesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(TallySheetView.DropdownGarages.class)
	private Integer ID;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String name;

	private String abbrevation;

	private CountriesDTO countriesDTO;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public CountriesDTO getCountriesDTO() {
		return countriesDTO;
	}

	public void setCountriesDTO(CountriesDTO countriesDTO) {
		this.countriesDTO = countriesDTO;
	}

	@Override
	public String toString() {
		return "StatesDTO [ID=" + ID + ", name=" + name + ", abbrevation="
				+ abbrevation + ", countriesDTO=" + countriesDTO + "]";
	}

	
	

}
