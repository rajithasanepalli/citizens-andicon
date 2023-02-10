package com.mouritech.lp.cppc.gateway.DTO.enums;

public enum ContactTypesEnum {

	ADMINISTRATIVE_MANAGER("ADMINISTRATIVE_MANAGER"), ASSISTANT_GENERAL_MANAGER(
			"ASSISTANT_GENERAL_MANAGER"), ASSISTANT_PROPERTY_MANAGER(
			"ASSISTANT_PROPERTY_MANAGER"), GENERAL_MANAGER("GENERAL_MANAGER"), PROJECT_ACCOUNTANT(
			"PROJECT_ACCOUNTANT"), PROPERTY_MANAGER("PROPERTY_MANAGER"), SENIOR_PROPERTY_MANAGER(
			"SENIOR_PROPERTY_MANAGER");

	private final String value;

	private ContactTypesEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
