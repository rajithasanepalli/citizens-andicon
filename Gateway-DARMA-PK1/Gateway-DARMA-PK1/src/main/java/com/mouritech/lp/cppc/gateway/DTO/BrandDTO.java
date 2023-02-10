package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class BrandDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String code;

	private StatusEnum status;
	
	private String logo;

	private String description;
	private Set<RegionDTO> regionsDTO = new HashSet<>();
	private Set<GLCodesDTO> gLCodesDTO = new HashSet<>();
	private Set<UserDTO> userDTO = new HashSet<>();

	public Set<RegionDTO> getRegionsDTO() {
		return regionsDTO;
	}

	public void setRegionsDTO(Set<RegionDTO> regionsDTO) {
		this.regionsDTO = regionsDTO;
	}

	public Set<UserDTO> getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(Set<UserDTO> userDTO) {
		this.userDTO = userDTO;
	}

	public Set<GLCodesDTO> getgLCodesDTO() {
		return gLCodesDTO;
	}

	public void setgLCodesDTO(Set<GLCodesDTO> gLCodesDTO) {
		this.gLCodesDTO = gLCodesDTO;
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

	
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "BrandDTO [id=" + id + ", code=" + code + ", status=" + status
				+ ", description=" + description + ", regionsDTO=" + regionsDTO
				+ ", gLCodesDTO=" + gLCodesDTO + ", userDTO=" + userDTO + "]";
	}



}
