package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.views.TallySheetView;

public class VehicleMakesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(TallySheetView.DropdownGarages.class)
	private Integer ID;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String Name;

	private Boolean defaultFlag;

	// private
	// Set<AutoMonthlyRegistrationFormDTO>autoMonthlyRegistrationFormsDTO = new
	// HashSet<AutoMonthlyRegistrationFormDTO>();

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Boolean getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(Boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

}