package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class LocationLnkDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	
	private Set<BankAccountsLocationLinkDTO> bankAccountsLocationLinks = new HashSet<>();
	private Set<TenderTypesLocationLinkDTO> tenderTypesLocationLinks= new HashSet<>();
	private Set<RevenueTypesLocationLinkDTO> revenueTypesLocationLinks= new HashSet<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public Set<BankAccountsLocationLinkDTO> getBankAccountsLocationLinks() {
		return bankAccountsLocationLinks;
	}
	public void setBankAccountsLocationLinks(
			Set<BankAccountsLocationLinkDTO> bankAccountsLocationLinks) {
		this.bankAccountsLocationLinks = bankAccountsLocationLinks;
	}
	public Set<TenderTypesLocationLinkDTO> getTenderTypesLocationLinks() {
		return tenderTypesLocationLinks;
	}
	public void setTenderTypesLocationLinks(
			Set<TenderTypesLocationLinkDTO> tenderTypesLocationLinks) {
		this.tenderTypesLocationLinks = tenderTypesLocationLinks;
	}
	public Set<RevenueTypesLocationLinkDTO> getRevenueTypesLocationLinks() {
		return revenueTypesLocationLinks;
	}
	public void setRevenueTypesLocationLinks(
			Set<RevenueTypesLocationLinkDTO> revenueTypesLocationLinks) {
		this.revenueTypesLocationLinks = revenueTypesLocationLinks;
	}
	@Override
	public String toString() {
		return "LocationLnkDTO [id=" + id + ", bankAccountsLocationLinks="
				+ bankAccountsLocationLinks + ", tenderTypesLocationLinks="
				+ tenderTypesLocationLinks + ", revenueTypesLocationLinks="
				+ revenueTypesLocationLinks + "]";
	}
	
	
	

	

	

}
