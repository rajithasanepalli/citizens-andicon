package com.mouritech.lp.cppc.gateway.DTO.enums;

public enum AuditActionEnum {
	C("Created"), U("Updated"), D("Deleted");
	private final String value;

	AuditActionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
