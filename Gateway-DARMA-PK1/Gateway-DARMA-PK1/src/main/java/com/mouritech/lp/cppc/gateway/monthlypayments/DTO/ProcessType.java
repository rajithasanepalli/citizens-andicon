package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

public enum ProcessType {
	MARKETINGFLOW("MARKETING-FLOW"),GARAGEUSE("GARAGE-USE");
	
	private final String value;

	ProcessType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
