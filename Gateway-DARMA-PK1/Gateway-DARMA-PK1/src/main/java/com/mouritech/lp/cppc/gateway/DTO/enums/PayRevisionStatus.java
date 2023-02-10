package com.mouritech.lp.cppc.gateway.DTO.enums;

public enum PayRevisionStatus {

	A("Approve"), R("Rejected"), P("Pending"), G("Generated") ,C("Correction");

	private final String value;

	private PayRevisionStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
