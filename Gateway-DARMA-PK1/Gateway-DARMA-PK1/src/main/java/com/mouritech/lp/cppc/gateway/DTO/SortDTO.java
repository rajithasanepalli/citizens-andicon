package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.SortDirectionEnum;

public class SortDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String field;
	
	private SortDirectionEnum direction;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public SortDirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(SortDirectionEnum direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "SortDTO [field=" + field + ", direction=" + direction + "]";
	}

}
