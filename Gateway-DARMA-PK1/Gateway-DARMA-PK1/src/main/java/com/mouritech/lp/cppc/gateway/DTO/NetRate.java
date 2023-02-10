package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class NetRate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal netRate;

	private String car;

	public BigDecimal getNetRate() {
		return netRate;
	}

	public void setNetRate(BigDecimal netRate) {
		this.netRate = netRate;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

}
