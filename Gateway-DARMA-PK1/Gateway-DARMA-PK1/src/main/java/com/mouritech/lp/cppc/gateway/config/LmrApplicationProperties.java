package com.mouritech.lp.cppc.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to LmrApplication.
 *
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@Configuration
@ConfigurationProperties(prefix = "lmr", ignoreUnknownFields = false)
public class LmrApplicationProperties {

	private String ldapAccessTokenUri;
	private String ldapLogout;
	private String positionsUri;
	private String contactTypesUri;
	private String tenderTypesUri;
	private String revenueTypesUri;
	private String regionUri;
	private String locationMoreInfosUri;
	private String locationContactsUri;
	private String burdensUri;
	private String positionsAndBillingRatesUri;
	private String bankAccountsUri;
	private String locationnotesUri;
	private String locationsUri;
	private String tenderTypesLocationLinkUri;
	private String bankAccountsLocationLinkUri;
	private String locationSearchUri;
	private String apiKey;
	private String brandUri;
	private String burdenInfoUri;
	private String revenueLocationLinkUri;
	private String userUri;
	private String roleUri;
	private String userLoctionLinkUri;
	private String dbankAccountsLocationLink;
	private String dtenderTypesLocationLink;
	private String drevenueTypesLocationLink;
	private String regionLoctionLinkUri;
	private String billingConvUri;
	private String financialServicesUri;
	private String financialYearUri;
	private String allocationBurdenUri;
	private String exclusionBurdenUri;
	private String onlyLocationsUri;
	private String locationLnkUri;
	private String jodDetails;

	private String uploadUri;
	private String getListUri;
	private String downloadUri;
	private String billingNotes;
	private String glNotes;
	private String glcodesUri;
	
	private String ldsUri;
	private String ddueToLocation;
	
	
	public String getLdsUri() {
		return ldsUri;
	}

	public void setLdsUri(String ldsUri) {
		this.ldsUri = ldsUri;
	}

	public String getGlcodesUri() {
		return glcodesUri;
	}

	public void setGlcodesUri(String glcodesUri) {
		this.glcodesUri = glcodesUri;
	}



	public String getBillingNotes() {
		return billingNotes;
	}

	public void setBillingNotes(String billingNotes) {
		this.billingNotes = billingNotes;
	}

	public String getGlNotes() {
		return glNotes;
	}

	public void setGlNotes(String glNotes) {
		this.glNotes = glNotes;
	}

	public String getUploadUri() {
		return uploadUri;
	}

	public void setUploadUri(String uploadUri) {
		this.uploadUri = uploadUri;
	}

	public String getGetListUri() {
		return getListUri;
	}

	public void setGetListUri(String getListUri) {
		this.getListUri = getListUri;
	}

	public String getDownloadUri() {
		return downloadUri;
	}

	public void setDownloadUri(String downloadUri) {
		this.downloadUri = downloadUri;
	}

	public String getLocationLnkUri() {
		return locationLnkUri;
	}

	public void setLocationLnkUri(String locationLnkUri) {
		this.locationLnkUri = locationLnkUri;
	}

	public String getOnlyLocationsUri() {
		return onlyLocationsUri;
	}

	public void setOnlyLocationsUri(String onlyLocationsUri) {
		this.onlyLocationsUri = onlyLocationsUri;
	}

	public String getLdapAccessTokenUri() {
		return ldapAccessTokenUri;
	}

	public void setLdapAccessTokenUri(String ldapAccessTokenUri) {
		this.ldapAccessTokenUri = ldapAccessTokenUri;
	}

	public String getPositionsUri() {
		return positionsUri;
	}

	public void setPositionsUri(String positionsUri) {
		this.positionsUri = positionsUri;
	}

	public String getContactTypesUri() {
		return contactTypesUri;
	}

	public void setContactTypesUri(String contactTypesUri) {
		this.contactTypesUri = contactTypesUri;
	}

	public String getTenderTypesUri() {
		return tenderTypesUri;
	}

	public void setTenderTypesUri(String tenderTypesUri) {
		this.tenderTypesUri = tenderTypesUri;
	}

	public String getRevenueTypesUri() {
		return revenueTypesUri;
	}

	public void setRevenueTypesUri(String revenueTypesUri) {
		this.revenueTypesUri = revenueTypesUri;
	}

	public String getRegionUri() {
		return regionUri;
	}

	public void setRegionUri(String regionUri) {
		this.regionUri = regionUri;
	}

	public String getLocationMoreInfosUri() {
		return locationMoreInfosUri;
	}

	public void setLocationMoreInfosUri(String locationMoreInfosUri) {
		this.locationMoreInfosUri = locationMoreInfosUri;
	}

	public String getLocationContactsUri() {
		return locationContactsUri;
	}

	public void setLocationContactsUri(String locationContactsUri) {
		this.locationContactsUri = locationContactsUri;
	}

	public String getBurdensUri() {
		return burdensUri;
	}

	public void setBurdensUri(String burdensUri) {
		this.burdensUri = burdensUri;
	}

	public String getPositionsAndBillingRatesUri() {
		return positionsAndBillingRatesUri;
	}

	public void setPositionsAndBillingRatesUri(
			String positionsAndBillingRatesUri) {
		this.positionsAndBillingRatesUri = positionsAndBillingRatesUri;
	}

	public String getBankAccountsUri() {
		return bankAccountsUri;
	}

	public void setBankAccountsUri(String bankAccountsUri) {
		this.bankAccountsUri = bankAccountsUri;
	}

	public String getLocationnotesUri() {
		return locationnotesUri;
	}

	public void setLocationnotesUri(String locationnotesUri) {
		this.locationnotesUri = locationnotesUri;
	}

	public String getLocationsUri() {
		return locationsUri;
	}

	public void setLocationsUri(String locationsUri) {
		this.locationsUri = locationsUri;
	}

	public String getTenderTypesLocationLinkUri() {
		return tenderTypesLocationLinkUri;
	}

	public void setTenderTypesLocationLinkUri(String tenderTypesLocationLinkUri) {
		this.tenderTypesLocationLinkUri = tenderTypesLocationLinkUri;
	}

	public String getBankAccountsLocationLinkUri() {
		return bankAccountsLocationLinkUri;
	}

	public void setBankAccountsLocationLinkUri(
			String bankAccountsLocationLinkUri) {
		this.bankAccountsLocationLinkUri = bankAccountsLocationLinkUri;
	}

	public String getLocationSearchUri() {
		return locationSearchUri;
	}

	public void setLocationSearchUri(String locationSearchUri) {
		this.locationSearchUri = locationSearchUri;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getBrandUri() {
		return brandUri;
	}

	public void setBrandUri(String brandUri) {
		this.brandUri = brandUri;
	}

	public String getBurdenInfoUri() {
		return burdenInfoUri;
	}

	public void setBurdenInfoUri(String burdenInfoUri) {
		this.burdenInfoUri = burdenInfoUri;
	}

	public String getRevenueLocationLinkUri() {
		return revenueLocationLinkUri;
	}

	public void setRevenueLocationLinkUri(String revenueLocationLinkUri) {
		this.revenueLocationLinkUri = revenueLocationLinkUri;
	}

	public String getUserUri() {
		return userUri;
	}

	public void setUserUri(String userUri) {
		this.userUri = userUri;
	}

	public String getUserLoctionLinkUri() {
		return userLoctionLinkUri;
	}

	public void setUserLoctionLinkUri(String userLoctionLinkUri) {
		this.userLoctionLinkUri = userLoctionLinkUri;
	}

	public String getDbankAccountsLocationLink() {
		return dbankAccountsLocationLink;
	}

	public void setDbankAccountsLocationLink(String dbankAccountsLocationLink) {
		this.dbankAccountsLocationLink = dbankAccountsLocationLink;
	}

	public String getDtenderTypesLocationLink() {
		return dtenderTypesLocationLink;
	}

	public void setDtenderTypesLocationLink(String dtenderTypesLocationLink) {
		this.dtenderTypesLocationLink = dtenderTypesLocationLink;
	}

	public String getDrevenueTypesLocationLink() {
		return drevenueTypesLocationLink;
	}

	public void setDrevenueTypesLocationLink(String drevenueTypesLocationLink) {
		this.drevenueTypesLocationLink = drevenueTypesLocationLink;
	}

	public String getRegionLoctionLinkUri() {
		return regionLoctionLinkUri;
	}

	public void setRegionLoctionLinkUri(String regionLoctionLinkUri) {
		this.regionLoctionLinkUri = regionLoctionLinkUri;
	}

	public String getLdapLogout() {
		return ldapLogout;
	}

	public void setLdapLogout(String ldapLogout) {
		this.ldapLogout = ldapLogout;
	}

	public String getRoleUri() {
		return roleUri;
	}

	public void setRoleUri(String roleUri) {
		this.roleUri = roleUri;
	}

	public String getBillingConvUri() {
		return billingConvUri;
	}

	public void setBillingConvUri(String billingConvUri) {
		this.billingConvUri = billingConvUri;
	}

	public String getFinancialServicesUri() {
		return financialServicesUri;
	}

	public void setFinancialServicesUri(String financialServicesUri) {
		this.financialServicesUri = financialServicesUri;
	}

	public String getFinancialYearUri() {
		return financialYearUri;
	}

	public void setFinancialYearUri(String financialYearUri) {
		this.financialYearUri = financialYearUri;
	}

	public String getAllocationBurdenUri() {
		return allocationBurdenUri;
	}

	public void setAllocationBurdenUri(String allocationBurdenUri) {
		this.allocationBurdenUri = allocationBurdenUri;
	}

	public String getExclusionBurdenUri() {
		return exclusionBurdenUri;
	}

	public void setExclusionBurdenUri(String exclusionBurdenUri) {
		this.exclusionBurdenUri = exclusionBurdenUri;
	}

	public String getJodDetails() {
		return jodDetails;
	}

	public void setJodDetails(String jodDetails) {
		this.jodDetails = jodDetails;
	}

	public String getDdueToLocation() {
		return ddueToLocation;
	}

	public void setDdueToLocation(String ddueToLocation) {
		this.ddueToLocation = ddueToLocation;
	}

}
