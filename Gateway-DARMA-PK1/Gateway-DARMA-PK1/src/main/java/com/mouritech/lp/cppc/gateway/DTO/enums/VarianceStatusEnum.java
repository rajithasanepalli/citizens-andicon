package com.mouritech.lp.cppc.gateway.DTO.enums;

public enum VarianceStatusEnum {

	REJECT("Reject"),APPROVED("Approved");

	private final String value;

	private VarianceStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
