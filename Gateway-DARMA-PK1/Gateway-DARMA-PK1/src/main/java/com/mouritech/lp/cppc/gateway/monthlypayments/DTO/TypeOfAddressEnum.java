package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

public enum TypeOfAddressEnum {
	BILLING_ADDRESS("BILLING_ADDRESS"),ADDITIONAL_ADDRESS("ADDITIONAL_ADDRESS");
	
	private final String value;

	TypeOfAddressEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
