package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

public enum SendBillToEnum {
	HOME("Home"),BUSINESS("Office");
	
	private final String value;

	SendBillToEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
