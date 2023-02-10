package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PaymentTypesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String isDebit;

	private Set<GarageBanksDTO> garageBanksDTO = new HashSet<GarageBanksDTO>();

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsDebit() {
		return isDebit;
	}

	public void setIsDebit(String isDebit) {
		this.isDebit = isDebit;
	}

	public Set<GarageBanksDTO> getGarageBanksDTO() {
		return garageBanksDTO;
	}

	public void setGarageBanksDTO(Set<GarageBanksDTO> garageBanksDTO) {
		this.garageBanksDTO = garageBanksDTO;
	}

	@Override
	public String toString() {
		return "PaymentTypesDTO [id=" + id + ", name=" + name + ", isDebit="
				+ isDebit + ", garageBanksDTO=" + garageBanksDTO + "]";
	}

	

}
