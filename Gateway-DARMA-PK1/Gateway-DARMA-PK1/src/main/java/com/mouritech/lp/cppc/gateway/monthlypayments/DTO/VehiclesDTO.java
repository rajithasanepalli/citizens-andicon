package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

public class VehiclesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;

	private String Driver_Name;

	private String Identification_No;

	private String Color;

	private Integer VYear;

	private String License;

	private Boolean Active_Flag;

	private StatesDTO StateDTO;

	private VehicleSizeDTO VSizeDTO;

	private VehicleModelsDTO ModelDTO;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getDriver_Name() {
		return Driver_Name;
	}

	public void setDriver_Name(String driver_Name) {
		Driver_Name = driver_Name;
	}

	public String getIdentification_No() {
		return Identification_No;
	}

	public void setIdentification_No(String identification_No) {
		Identification_No = identification_No;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public Integer getVYear() {
		return VYear;
	}

	public void setVYear(Integer vYear) {
		VYear = vYear;
	}

	public String getLicense() {
		return License;
	}

	public void setLicense(String license) {
		License = license;
	}

	public Boolean getActive_Flag() {
		return Active_Flag;
	}

	public void setActive_Flag(Boolean active_Flag) {
		Active_Flag = active_Flag;
	}

	public StatesDTO getStateDTO() {
		return StateDTO;
	}

	public void setStateDTO(StatesDTO stateDTO) {
		StateDTO = stateDTO;
	}

	public VehicleSizeDTO getVSizeDTO() {
		return VSizeDTO;
	}

	public void setVSizeDTO(VehicleSizeDTO vSizeDTO) {
		VSizeDTO = vSizeDTO;
	}

	public VehicleModelsDTO getModelDTO() {
		return ModelDTO;
	}

	public void setModelDTO(VehicleModelsDTO modelDTO) {
		ModelDTO = modelDTO;
	}

}