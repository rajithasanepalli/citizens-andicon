package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class VehicleSizeDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;

	private String name;

	private Boolean defaultFlag;
	

	private Set<VehiclesDTO>vehiclesDTO  = new HashSet<VehiclesDTO>();
	

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

	public Boolean getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(Boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public Set<VehiclesDTO> getVehiclesDTO() {
		return vehiclesDTO;
	}

	public void setVehiclesDTO(Set<VehiclesDTO> vehiclesDTO) {
		this.vehiclesDTO = vehiclesDTO;
	}

	
	
	

	

}