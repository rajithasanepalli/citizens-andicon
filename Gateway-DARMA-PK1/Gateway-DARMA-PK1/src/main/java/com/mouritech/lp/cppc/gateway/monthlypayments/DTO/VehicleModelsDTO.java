package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.views.TallySheetView;

public class VehicleModelsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(TallySheetView.DropdownGarages.class)
	private Integer ID;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String Model;

	private Integer vehicleTypeID;

	private Integer vehicleMakeID;

	// private
	// Set<AutoMonthlyRegistrationFormDTO>autoMonthlyRegistrationFormsDTO = new
	// HashSet<AutoMonthlyRegistrationFormDTO>();

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public Integer getVehicleTypeID() {
		return vehicleTypeID;
	}

	public void setVehicleTypeID(Integer vehicleTypeID) {
		this.vehicleTypeID = vehicleTypeID;
	}

	public Integer getVehicleMakeID() {
		return vehicleMakeID;
	}

	public void setVehicleMakeID(Integer vehicleMakeID) {
		this.vehicleMakeID = vehicleMakeID;
	}

	@Override
	public String toString() {
		return "VehicleModelsDTO [ID=" + ID + ", Model=" + Model
				+ ", vehicleTypeID=" + vehicleTypeID + ", vehicleMakeID="
				+ vehicleMakeID + "]";
	}



}