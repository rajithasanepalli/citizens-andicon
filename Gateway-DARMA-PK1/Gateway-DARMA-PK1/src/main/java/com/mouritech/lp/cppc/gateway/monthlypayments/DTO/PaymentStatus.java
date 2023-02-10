package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

public enum PaymentStatus {
	PENDING("PENDING"),COMPLETED("COMPLETED");
	
	private final String value;

	PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
