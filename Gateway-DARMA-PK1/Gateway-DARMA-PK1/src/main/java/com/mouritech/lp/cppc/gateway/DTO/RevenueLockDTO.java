package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class RevenueLockDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private Integer month;

	private Integer year;

	private Boolean lock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Boolean getLock() {
		return lock;
	}

	public void setLock(Boolean lock) {
		this.lock = lock;
	}

	@Override
	public String toString() {
		return "TestDTO [id=" + id + ", month=" + month + ", year=" + year
				+ ", lock=" + lock + "]";
	}

}
