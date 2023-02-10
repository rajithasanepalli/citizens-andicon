package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class PositionsAndBillingRatesDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Double billingRate;
	private LocationDTO locationDTO;
	private PositionsDTO positionsDTO;

	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getBillingRate() {
		return billingRate;
	}

	public void setBillingRate(Double billingRate) {
		this.billingRate = billingRate;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public PositionsDTO getPositionsDTO() {
		return positionsDTO;
	}

	public void setPositionsDTO(PositionsDTO positionsDTO) {
		this.positionsDTO = positionsDTO;
	}

}
