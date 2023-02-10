package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedFormDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String damageDescription;
	
	private List<DamageTypes> applicableDamageTypes = new ArrayList<>(); 
	
	private List<PedDamageMarkDTO> damageMarkListDto = new ArrayList<>();
	
	private String signature;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getDamageDescription() {
		return damageDescription;
	}

	public void setDamageDescription(String damageDescription) {
		this.damageDescription = damageDescription;
	}


	public List<DamageTypes> getApplicableDamageTypes() {
		return applicableDamageTypes;
	}

	public void setApplicableDamageTypes(List<DamageTypes> applicableDamageTypes) {
		this.applicableDamageTypes = applicableDamageTypes;
	}

	public List<PedDamageMarkDTO> getDamageMarkListDto() {
		return damageMarkListDto;
	}

	public void setDamageMarkListDto(List<PedDamageMarkDTO> damageMarkListDto) {
		this.damageMarkListDto = damageMarkListDto;
	}

}
