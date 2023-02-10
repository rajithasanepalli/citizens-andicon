package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VehicleConditionReportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private VehicleMakesDTO Vehicle_MakeDTO;

	private VehicleModelsDTO ModelDTO;
	
	private List<DamageMarkDTO> damageMarkListDto=new ArrayList<>();
	
	private Set<VCRdetailsDTO>vcrdetailsDTO  = new HashSet<>();
	
	private String signature;
	
	
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<DamageMarkDTO> getDamageMarkListDto() {
		return damageMarkListDto;
	}

	public void setDamageMarkListDto(List<DamageMarkDTO> damageMarkListDto) {
		this.damageMarkListDto = damageMarkListDto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VehicleMakesDTO getVehicle_MakeDTO() {
		return Vehicle_MakeDTO;
	}

	public void setVehicle_MakeDTO(VehicleMakesDTO vehicle_MakeDTO) {
		Vehicle_MakeDTO = vehicle_MakeDTO;
	}

	public VehicleModelsDTO getModelDTO() {
		return ModelDTO;
	}

	public void setModelDTO(VehicleModelsDTO modelDTO) {
		ModelDTO = modelDTO;
	}

	public Set<VCRdetailsDTO> getVcrdetailsDTO() {
		return vcrdetailsDTO;
	}

	public void setVcrdetailsDTO(Set<VCRdetailsDTO> vcrdetailsDTO) {
		this.vcrdetailsDTO = vcrdetailsDTO;
	}

	

}
