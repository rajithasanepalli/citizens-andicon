package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class GatewayProcessorLinkDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String notes;

	private ProcessorDTO processorDTO;

	private GatewayDTO gatewayDTO;

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

	public ProcessorDTO getProcessorDTO() {
		return processorDTO;
	}

	public void setProcessorDTO(ProcessorDTO processorDTO) {
		this.processorDTO = processorDTO;
	}

	public GatewayDTO getGatewayDTO() {
		return gatewayDTO;
	}

	public void setGatewayDTO(GatewayDTO gatewayDTO) {
		this.gatewayDTO = gatewayDTO;
	}

	@Override
	public String toString() {
		return "GatewayProcessorLinkDTO [id=" + id + ", Notes=" + notes + ", ProcessorDTO=" + processorDTO
				+ ", GatwayDTO=" + gatewayDTO + "]";
	}
}
