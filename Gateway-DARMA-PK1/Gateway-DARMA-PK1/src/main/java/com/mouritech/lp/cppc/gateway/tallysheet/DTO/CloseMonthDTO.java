package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;

public class CloseMonthDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer month;

	private Integer year;

	private Boolean close;

	private Integer garageId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}



	public Boolean getClose() {
		return close;
	}

	public void setClose(Boolean close) {
		this.close = close;
	}

	public Integer getGarageId() {
		return garageId;
	}

	public void setGarageId(Integer garageId) {
		this.garageId = garageId;
	}

}
