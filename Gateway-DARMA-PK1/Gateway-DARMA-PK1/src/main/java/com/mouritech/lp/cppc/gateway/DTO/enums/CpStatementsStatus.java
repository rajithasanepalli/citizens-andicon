package com.mouritech.lp.cppc.gateway.DTO.enums;

public enum CpStatementsStatus {

	APPROVED("Approved"), FINAL("Final"), DRAFT("Draft"), FINALIZED("Finalized"), PUBLISHED("Published"), ACCEPT("Accept"),REJECT("Reject");

	private final String value;

	private CpStatementsStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
