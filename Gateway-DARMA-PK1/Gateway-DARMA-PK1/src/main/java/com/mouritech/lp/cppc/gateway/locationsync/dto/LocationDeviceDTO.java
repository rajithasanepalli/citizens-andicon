package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.LocationDTO;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class LocationDeviceDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String notes;

	private boolean rented;

	private String serialNumber;

	private LocationDTO locationDTO;

	private PaymentDevicesDTO paymentDevicesDTO;

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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public PaymentDevicesDTO getPaymentDevicesDTO() {
		return paymentDevicesDTO;
	}

	public void setPaymentDevicesDTO(PaymentDevicesDTO paymentDevicesDTO) {
		this.paymentDevicesDTO = paymentDevicesDTO;
	}
}
