package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

public class CountriesDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;

	private String name;

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

	

}
