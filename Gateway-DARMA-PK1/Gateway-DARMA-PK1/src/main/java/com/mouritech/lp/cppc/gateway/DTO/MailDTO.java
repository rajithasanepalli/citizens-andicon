package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class MailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "MailDTO [emailId=" + emailId + "]";
	}

}
