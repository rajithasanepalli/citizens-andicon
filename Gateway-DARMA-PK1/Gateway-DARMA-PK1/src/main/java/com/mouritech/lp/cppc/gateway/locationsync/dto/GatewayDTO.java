package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class GatewayDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String gatewayName;

	private String primaryContactID;

	private String notes;

	private boolean deleted;

	private StatusEnum status;

	private String lastUpdatedBy;

	private Set<PaymentDeviceGatewayLinkDTO> paymentDeviceGatewayLinkDTO = new HashSet<>();

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

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public String getPrimaryContactID() {
		return primaryContactID;
	}

	public void setPrimaryContactID(String primaryContactID) {
		this.primaryContactID = primaryContactID;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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

}
