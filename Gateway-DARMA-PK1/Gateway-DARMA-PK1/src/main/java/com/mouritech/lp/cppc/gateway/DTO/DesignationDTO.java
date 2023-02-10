package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;


public class DesignationDTO implements
		Serializable {

	private static final long serialVersionUID = 1L;

	
	
	private String id;

	
	private String code;

	
	private String description;


	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Designation [id=" + id + ", code=" + code + ", description="
				+ description + "]";
	}


}
