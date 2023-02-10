package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.util.List;

public class CloseMonthMessageDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	private List<GaragesDTO> garages;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<GaragesDTO> getGarages() {
		return garages;
	}

	public void setGarages(List<GaragesDTO> garages) {
		this.garages = garages;
	}

	@Override
	public String toString() {
		return "CloseMonthMessageDTO [message=" + message + ", garages="
				+ garages + "]";
	}

}
