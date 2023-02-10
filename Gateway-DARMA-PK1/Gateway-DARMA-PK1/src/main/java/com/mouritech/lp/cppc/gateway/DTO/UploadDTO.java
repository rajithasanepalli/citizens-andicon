package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class UploadDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String brandCode;
	
	private String payGroup;
	
	private String payDate;

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getPayGroup() {
		return payGroup;
	}

	public void setPayGroup(String payGroup) {
		this.payGroup = payGroup;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	@Override
	public String toString() {
		return "UploadDTO [brandCode=" + brandCode + ", payGroup=" + payGroup
				+ ", payDate=" + payDate + "]";
	}
	


	
	



}
