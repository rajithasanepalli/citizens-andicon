package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.ContactTypesEnum;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class CpContactTypesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private ContactTypesEnum code;

	private String description;

	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ContactTypesEnum getCode() {
		return code;
	}

	public void setCode(ContactTypesEnum code) {
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
		return "ContactTypesDTO [id=" + id + ", code=" + code
				+ ", description=" + description + "]";
	}

}
