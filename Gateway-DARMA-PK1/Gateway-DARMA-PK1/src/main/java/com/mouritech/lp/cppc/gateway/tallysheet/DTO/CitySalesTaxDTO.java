package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

public class CitySalesTaxDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;

	private BigDecimal percentage;

	private LocalDateTime effectiveDate;

	private LocalDateTime expireDate;

	private Integer taxType;

	private CitiesDTO CityDTO;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public LocalDateTime getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDateTime effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public LocalDateTime getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDateTime expireDate) {
		this.expireDate = expireDate;
	}

	public Integer getTaxType() {
		return taxType;
	}

	public void setTaxType(Integer taxType) {
		this.taxType = taxType;
	}

	public CitiesDTO getCityDTO() {
		return CityDTO;
	}

	public void setCityDTO(CitiesDTO cityDTO) {
		CityDTO = cityDTO;
	}

	@Override
	public String toString() {
		return "CitySalesTaxDTO [ID=" + ID + ", percentage=" + percentage
				+ ", effectiveDate=" + effectiveDate + ", expireDate="
				+ expireDate + ", taxType=" + taxType + ", CityDTO=" + CityDTO
				+ "]";
	}

}
