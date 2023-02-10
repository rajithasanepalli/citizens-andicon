package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;


public class DamageMarkDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer positionId;
	
	private String damageMark;
	
	private VehicleConditionReportDTO vehicleConditionReportdto;
	
	

	public VehicleConditionReportDTO getVehicleConditionReportdto() {
		return vehicleConditionReportdto;
	}

	public void setVehicleConditionReportdto(VehicleConditionReportDTO vehicleConditionReportdto) {
		this.vehicleConditionReportdto = vehicleConditionReportdto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getDamageMark() {
		return damageMark;
	}

	public void setDamageMark(String damageMark) {
		this.damageMark = damageMark;
	}


	
	
	
}