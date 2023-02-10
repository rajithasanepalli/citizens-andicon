package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CitiesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;

	private String name;

	private String aliasName;

	private String countyName;

	private Integer stateID;

	private Set<ZipCodesDTO> zipCodesDTO = new HashSet<ZipCodesDTO>();

	private Set<CitySalesTaxDTO> citySalesTaxDTO = new HashSet<CitySalesTaxDTO>();

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public Set<ZipCodesDTO> getZipCodesDTO() {
		return zipCodesDTO;
	}

	public void setZipCodesDTO(Set<ZipCodesDTO> zipCodesDTO) {
		this.zipCodesDTO = zipCodesDTO;
	}

	public Set<CitySalesTaxDTO> getCitySalesTaxDTO() {
		return citySalesTaxDTO;
	}

	public void setCitySalesTaxDTO(Set<CitySalesTaxDTO> citySalesTaxDTO) {
		this.citySalesTaxDTO = citySalesTaxDTO;
	}

	@Override
	public String toString() {
		return "CitiesDTO [ID=" + ID + ", name=" + name + ", aliasName="
				+ aliasName + ", countyName=" + countyName + ", stateID="
				+ stateID + ", zipCodesDTO=" + zipCodesDTO
				+ ", citySalesTaxDTO=" + citySalesTaxDTO + "]";
	}

}
