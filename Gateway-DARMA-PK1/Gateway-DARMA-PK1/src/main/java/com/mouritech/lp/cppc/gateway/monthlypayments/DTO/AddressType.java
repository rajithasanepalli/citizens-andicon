package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

public enum AddressType {
	HOMEADDRESS("HOMEADDRESS"),BUSINESSADDRESS("BUSINESSADDRESS");
	
	private final String value;

	AddressType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
