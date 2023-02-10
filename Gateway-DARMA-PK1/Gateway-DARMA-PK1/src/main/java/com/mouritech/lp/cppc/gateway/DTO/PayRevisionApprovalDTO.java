package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.List;

import com.mouritech.lp.cppc.gateway.DTO.enums.PayRevisionStatus;

public class PayRevisionApprovalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PayRevisionStatus payRevisionStatus;

	private List<String> payRevisionIdentifier;

	public PayRevisionStatus getPayRevisionStatus() {
		return payRevisionStatus;
	}

	public void setPayRevisionStatus(PayRevisionStatus payRevisionStatus) {
		this.payRevisionStatus = payRevisionStatus;
	}

	public List<String> getPayRevisionIdentifier() {
		return payRevisionIdentifier;
	}

	public void setPayRevisionIdentifier(List<String> payRevisionIdentifier) {
		this.payRevisionIdentifier = payRevisionIdentifier;
	}

	@Override
	public String toString() {
		return "PayRevisionApprovalDTO [payRevisionStatus=" + payRevisionStatus
				+ ", payRevisionIdentifier=" + payRevisionIdentifier + "]";
	}

}
