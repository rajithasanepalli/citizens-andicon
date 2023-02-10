package com.mouritech.lp.cppc.gateway.DTO.enums;

public enum UserDesignationEnum {

	ASSISTANT_MANAGER("ASSISTANT_MANAGER"), OPERATIONS_MANAGER(
			"OPERATIONS_MANAGER"), REGIONAL_MANAGER("REGIONAL_MANAGER"), REGIONAL_VICE_PRESIDENT(
			"REGIONAL_VICE_PRESIDENT"), SENIOR_OPERATION_MANAGER(
			"SENIOR_OPERATION_MANAGER"), TERRITORY_MANAGER("TERRITORY_MANAGER");

	private final String value;

	private UserDesignationEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
