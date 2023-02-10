package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class RegionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String code;
	private String description;
	private String logo;
	private BrandDTO brand;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public BrandDTO getBrand() {
		return brand;
	}
	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "RegionDTO [id=" + id + ", code=" + code + ", description="
				+ description + ", logo=" + logo + ", brand=" + brand + "]";
	}
	
	
	

}
