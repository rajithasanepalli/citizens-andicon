package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class FilterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;

	private String operation;
	
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FilterDTO [key=" + key + ", operation=" + operation
				+ ", value=" + value + "]";
	}


	


}
