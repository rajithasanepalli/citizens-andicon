package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

public enum BillingPreferenceEnum {
	EMAIL("Auto-EMail"),MAIL("Auto-Mail");
	
	private final String value;

	BillingPreferenceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
