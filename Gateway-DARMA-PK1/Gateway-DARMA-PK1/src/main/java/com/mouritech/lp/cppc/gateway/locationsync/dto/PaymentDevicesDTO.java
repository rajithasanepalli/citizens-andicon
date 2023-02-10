package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class PaymentDevicesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String make;

	private String model;

	private boolean deleted;

	private String notes;

	private Set<LocationDeviceDTO> locationDeviceDTO = new HashSet<>();

	private StatusEnum status;

	private String lastUpdatedBy;

	private Set<PaymentDeviceGatewayLinkDTO> paymentDeviceGatewayLinkDTO = new HashSet<>();

	private String serialNumber;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<LocationDeviceDTO> getLocationDeviceDTO() {
		return locationDeviceDTO;
	}

	public void setLocationDeviceDTO(Set<LocationDeviceDTO> locationDeviceDTO) {
		this.locationDeviceDTO = locationDeviceDTO;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Set<PaymentDeviceGatewayLinkDTO> getPaymentDeviceGatewayLinkDTO() {
		return paymentDeviceGatewayLinkDTO;
	}

	public void setPaymentDeviceGatewayLinkDTO(Set<PaymentDeviceGatewayLinkDTO> paymentDeviceGatewayLinkDTO) {
		this.paymentDeviceGatewayLinkDTO = paymentDeviceGatewayLinkDTO;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "PaymentDevices [PaymentDeviceId=" + id + ", Make=" + make + ", Model=" + model + ", Deleted=" + deleted
				+ ", Notes=" + notes + "]";
	}
}
