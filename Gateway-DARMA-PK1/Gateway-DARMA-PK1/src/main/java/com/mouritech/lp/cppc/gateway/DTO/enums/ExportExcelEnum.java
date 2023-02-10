package com.mouritech.lp.cppc.gateway.DTO.enums;

public enum ExportExcelEnum {

	HEADING("Heading"), TOTAL("Total"), NORMAL("Normal"), PANDL("PANDL"), YTD("YTD"), COMPARATIVE("COMPARATIVE"), ICR("ICR");

	private final String value;

	private ExportExcelEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
