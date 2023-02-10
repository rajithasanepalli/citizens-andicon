package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

public class VCRdetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String damageDetailDescription;

	private VehiclePositionDTO vehiclePositionDTO;

	private DamageTypeDTO damageTypeDTO;

	private VehicleConditionReportDTO vehicleConditionReportDTO;
	
	private String damageMarkDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDamageDetailDescription() {
		return damageDetailDescription;
	}

	public void setDamageDetailDescription(String damageDetailDescription) {
		this.damageDetailDescription = damageDetailDescription;
	}

	public VehiclePositionDTO getVehiclePositionDTO() {
		return vehiclePositionDTO;
	}

	public void setVehiclePositionDTO(VehiclePositionDTO vehiclePositionDTO) {
		this.vehiclePositionDTO = vehiclePositionDTO;
	}

	public DamageTypeDTO getDamageTypeDTO() {
		return damageTypeDTO;
	}

	public void setDamageTypeDTO(DamageTypeDTO damageTypeDTO) {
		this.damageTypeDTO = damageTypeDTO;
	}

	public VehicleConditionReportDTO getVehicleConditionReportDTO() {
		return vehicleConditionReportDTO;
	}

	public void setVehicleConditionReportDTO(
			VehicleConditionReportDTO vehicleConditionReportDTO) {
		this.vehicleConditionReportDTO = vehicleConditionReportDTO;
	}

	public String getDamageMarkDTO() {
		return damageMarkDTO;
	}

	public void setDamageMarkDTO(String damageMarkDTO) {
		this.damageMarkDTO = damageMarkDTO;
	}
	
	

	
	

}