package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

public enum CustomerStatus {
	PENDING("PENDING"),COMPLETED("COMPLETED");
	
	private final String value;

	CustomerStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
