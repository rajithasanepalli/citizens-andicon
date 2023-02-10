package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;

public class GarageBanksDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;

	private Boolean defaultFlag;

	private Boolean inActiveFlag;

	private Boolean transFlag;

	private GaragesDTO GarageDTO;

	private BanksDTO BankDTO;

	private PaymentTypesDTO PaymenttypeDTO;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Boolean getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(Boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public Boolean getInActiveFlag() {
		return inActiveFlag;
	}

	public void setInActiveFlag(Boolean inActiveFlag) {
		this.inActiveFlag = inActiveFlag;
	}

	public Boolean getTransFlag() {
		return transFlag;
	}

	public void setTransFlag(Boolean transFlag) {
		this.transFlag = transFlag;
	}

	public GaragesDTO getGarageDTO() {
		return GarageDTO;
	}

	public void setGarageDTO(GaragesDTO garageDTO) {
		GarageDTO = garageDTO;
	}

	public BanksDTO getBankDTO() {
		return BankDTO;
	}

	public void setBankDTO(BanksDTO bankDTO) {
		BankDTO = bankDTO;
	}

	public PaymentTypesDTO getPaymenttypeDTO() {
		return PaymenttypeDTO;
	}

	public void setPaymenttypeDTO(PaymentTypesDTO paymenttypeDTO) {
		PaymenttypeDTO = paymenttypeDTO;
	}

	@Override
	public String toString() {
		return "GarageBanksDTO [ID=" + ID + ", defaultFlag=" + defaultFlag
				+ ", inActiveFlag=" + inActiveFlag + ", transFlag=" + transFlag
				+ ", GarageDTO=" + GarageDTO + ", BankDTO=" + BankDTO
				+ ", PaymenttypeDTO=" + PaymenttypeDTO + "]";
	}

}
