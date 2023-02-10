package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class PasswordChangeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String oldPassword;

	private String newPassword;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
}
