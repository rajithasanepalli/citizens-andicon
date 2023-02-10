package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class DamageTypeDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String damageTypeShortCode;

	private String damageTypeName;
	
	private Set<VCRdetailsDTO>vcrdetailsDTO = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDamageTypeShortCode() {
		return damageTypeShortCode;
	}

	public void setDamageTypeShortCode(String damageTypeShortCode) {
		this.damageTypeShortCode = damageTypeShortCode;
	}

	public String getDamageTypeName() {
		return damageTypeName;
	}

	public void setDamageTypeName(String damageTypeName) {
		this.damageTypeName = damageTypeName;
	}

	public Set<VCRdetailsDTO> getVcrdetailsDTO() {
		return vcrdetailsDTO;
	}

	public void setVcrdetailsDTO(Set<VCRdetailsDTO> vcrdetailsDTO) {
		this.vcrdetailsDTO = vcrdetailsDTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	



	
	
	
}