package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;

public class PaymentDeviceGatewayLinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String notes;

	private PaymentDevicesDTO paymentDevicesDTO;

	private GatewayDTO gatewayDTO;

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

	public PaymentDevicesDTO getPaymentDevicesDTO() {
		return paymentDevicesDTO;
	}

	public void setPaymentDevicesDTO(PaymentDevicesDTO paymentDevicesDTO) {
		this.paymentDevicesDTO = paymentDevicesDTO;
	}

	public GatewayDTO getGatewayDTO() {
		return gatewayDTO;
	}

	public void setGatewayDTO(GatewayDTO gatewayDTO) {
		this.gatewayDTO = gatewayDTO;
	}

	@Override
	public String toString() {
		return "PaymentDeviceGatewayLinkDTO [id=" + id + ", notes=" + notes + ", paymentDevicesDTO=" + paymentDevicesDTO
				+ ", gatewayDTO=" + gatewayDTO + "]";
	}

}
