package com.mouritech.lp.cppc.gateway.DTO.enums;

public enum LocationStatusEnum {
	INACTIVE("Inactive"), ACTIVE("Active");

	private final String value;

	LocationStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
