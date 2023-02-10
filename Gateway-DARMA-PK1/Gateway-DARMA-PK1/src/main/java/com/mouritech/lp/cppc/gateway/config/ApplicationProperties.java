package com.mouritech.lp.cppc.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to Application.
 *
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@Configuration
@ConfigurationProperties(prefix = "lp", ignoreUnknownFields = false)
public class ApplicationProperties {
	private String accessTokenUri;
	private String ttkMetaAPIUri;
	private String apiKey;
	private String employeesBasedOnLocationIdAndPayweekUri;

	private String ldapAccessTokenUri;

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

	private String revenueAndsourceUri;
	private String tenderTypesLocationLinkUri;
	private String bankAccountsLocationLinkUri;
	private String sourceUri;
	private String revenueUri;
	private String sourceReconcileUri;
	private String locationSearchUri;
	private String revenueSearchUri;
	private String sourceSearchUri;
	
	

	public String getLocationSearchUri() {
		return locationSearchUri;
	}

	public void setLocationSearchUri(String locationSearchUri) {
		this.locationSearchUri = locationSearchUri;
	}

	public String getRevenueSearchUri() {
		return revenueSearchUri;
	}

	public void setRevenueSearchUri(String revenueSearchUri) {
		this.revenueSearchUri = revenueSearchUri;
	}

	public String getSourceSearchUri() {
		return sourceSearchUri;
	}

	public void setSourceSearchUri(String sourceSearchUri) {
		this.sourceSearchUri = sourceSearchUri;
	}

	public String getRevenueUri() {
		return revenueUri;
	}

	public void setRevenueUri(String revenueUri) {
		this.revenueUri = revenueUri;
	}

	public String getAccessTokenUri() {
		return accessTokenUri;
	}

	public void setAccessTokenUri(String accessTokenUri) {
		this.accessTokenUri = accessTokenUri;
	}

	public String getTtkMetaAPIUri() {
		return ttkMetaAPIUri;
	}

	public void setTtkMetaAPIUri(String ttkMetaAPIUri) {
		this.ttkMetaAPIUri = ttkMetaAPIUri;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getEmployeesBasedOnLocationIdAndPayweekUri() {
		return employeesBasedOnLocationIdAndPayweekUri;
	}

	public void setEmployeesBasedOnLocationIdAndPayweekUri(String employeesBasedOnLocationIdAndPayweekUri) {
		this.employeesBasedOnLocationIdAndPayweekUri = employeesBasedOnLocationIdAndPayweekUri;
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

	public void setPositionsAndBillingRatesUri(String positionsAndBillingRatesUri) {
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

	public String getRevenueAndsourceUri() {
		return revenueAndsourceUri;
	}

	public void setRevenueAndsourceUri(String revenueAndsourceUri) {
		this.revenueAndsourceUri = revenueAndsourceUri;
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

	public void setBankAccountsLocationLinkUri(String bankAccountsLocationLinkUri) {
		this.bankAccountsLocationLinkUri = bankAccountsLocationLinkUri;
	}

	public String getSourceUri() {
		return sourceUri;
	}

	public void setSourceUri(String sourceUri) {
		this.sourceUri = sourceUri;
	}

	public String getSourceReconcileUri() {
		return sourceReconcileUri;
	}

	public void setSourceReconcileUri(String sourceReconcileUri) {
		this.sourceReconcileUri = sourceReconcileUri;
	}

	
	
}
