package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ZipCodesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;

	private String zipCode;

	private CitiesDTO CityDTO;

	private Set<GaragesDTO> garagesDTO = new HashSet<GaragesDTO>();

	private Set<BanksDTO> banksDTO = new HashSet<BanksDTO>();

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public CitiesDTO getCityDTO() {
		return CityDTO;
	}

	public void setCityDTO(CitiesDTO cityDTO) {
		CityDTO = cityDTO;
	}

	public Set<GaragesDTO> getGaragesDTO() {
		return garagesDTO;
	}

	public void setGaragesDTO(Set<GaragesDTO> garagesDTO) {
		this.garagesDTO = garagesDTO;
	}

	public Set<BanksDTO> getBanksDTO() {
		return banksDTO;
	}

	public void setBanksDTO(Set<BanksDTO> banksDTO) {
		this.banksDTO = banksDTO;
	}

	@Override
	public String toString() {
		return "ZipCodesDTO [ID=" + ID + ", zipCode=" + zipCode + ", CityDTO="
				+ CityDTO + ", garagesDTO=" + garagesDTO + ", banksDTO="
				+ banksDTO + "]";
	}

}
