package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

public enum DamageTypes {
	NO_DAMAGE("No Damage"),DENTS("Dents"), DOOR_KNICKS("Door Knicks"), PAINT_DAMAGE("Paint Damage"),
	LICENSE_PLATE_DAMAGE("License Plate damage"), WHEEL_DAMAGE("Wheel Damage"), GLASS_CRACKED_OR_DAMAGE("Glass Cracked or Damage");
	private final String value;

	DamageTypes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
}
