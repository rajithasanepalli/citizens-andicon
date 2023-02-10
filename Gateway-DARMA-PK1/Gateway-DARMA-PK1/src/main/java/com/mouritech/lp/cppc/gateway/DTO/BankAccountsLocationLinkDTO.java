package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

@Entity
@Table(name = "BANK_ACCOUNT")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BankAccountsLocationLinkDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private BankAccountsDTO bankAccountsDTO;

	private LocationDTO locationDTO;
	
	private StatusEnum status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BankAccountsDTO getBankAccountsDTO() {
		return bankAccountsDTO;
	}

	public void setBankAccountsDTO(BankAccountsDTO bankAccountsDTO) {
		this.bankAccountsDTO = bankAccountsDTO;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}
	
	

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankAccountsLocationLinkDTO [id=" + id + ", bankAccountsDTO=" + bankAccountsDTO + ", locationDTO="
				+ locationDTO + "]";
	}
	
	

}
