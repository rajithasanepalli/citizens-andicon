package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class BankAccountsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private ContactTypesDTO contactTypesID;

	private String bankName;

	private String description;

	private String accountType;

	private String accountNumber;

	private String routingNumber;

	private String glNumber;

	private String oneGL;

	private StatusEnum status;

	private Set<BankAccountsLocationLinkDTO> bankAccountsLocationLinkDTO = new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ContactTypesDTO getContactTypesID() {
		return contactTypesID;
	}

	public void setContactTypesID(ContactTypesDTO contactTypesID) {
		this.contactTypesID = contactTypesID;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getGlNumber() {
		return glNumber;
	}

	public void setGlNumber(String glNumber) {
		this.glNumber = glNumber;
	}

	public Set<BankAccountsLocationLinkDTO> getBankAccountsLocationLinkDTO() {
		return bankAccountsLocationLinkDTO;
	}

	public void setBankAccountsLocationLinkDTO(
			Set<BankAccountsLocationLinkDTO> bankAccountsLocationLinkDTO) {
		this.bankAccountsLocationLinkDTO = bankAccountsLocationLinkDTO;
	}

	public String getOneGL() {
		return oneGL;
	}

	public void setOneGL(String oneGL) {
		this.oneGL = oneGL;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankAccountsDTO [id=" + id + ", contactTypesID="
				+ contactTypesID + ", bankName=" + bankName + ", description="
				+ description + ", accountType=" + accountType
				+ ", accountNumber=" + accountNumber + ", routingNumber="
				+ routingNumber + ", glNumber=" + glNumber + ", oneGL=" + oneGL
				+ ", status=" + status + ", bankAccountsLocationLinkDTO="
				+ bankAccountsLocationLinkDTO + "]";
	}

}
