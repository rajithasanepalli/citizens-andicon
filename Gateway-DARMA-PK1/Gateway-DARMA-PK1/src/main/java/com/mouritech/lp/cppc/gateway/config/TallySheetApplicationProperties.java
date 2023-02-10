package com.mouritech.lp.cppc.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to TallySheetApplication.
 *
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@Configuration
@ConfigurationProperties(prefix = "ts", ignoreUnknownFields = false)
public class TallySheetApplicationProperties {

	private String openOrClosedMonthUri;

	private String garagesUri;

	private String transientUri;

	private String apiKey;

	private String missingDatesAndTotalsUri;

	private String transientSearchUri;

	private String paymentTypesUri;

	private String creditCardsUri;

	private String transientBanksDepositUri;
	
	private String iparkCompanyName;
	
	private String iparkBrandCode;
	
	private String tallyLDAPAccesTokenUri;

	private String tallyLDAPLogOut;
	private String tallyRoleUri;
	private String tallyUserUri;
	
	//MONTHLY PAYMENTS GARAGE USE
	private String fileMaker;
	private String customer;
	private String vehiclemakes;
	private String vehiclemodels;
	
	private String cities;
	private String states;
	private String timepark;
	private String resident;
	private String zipCodes;
	private String garageRoster;
	//MONTHLY PAYMENTS GARAGE USE
	
	
	
	public String getTallyUserUri() {
		return tallyUserUri;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getGarageRoster() {
		return garageRoster;
	}

	public void setGarageRoster(String garageRoster) {
		this.garageRoster = garageRoster;
	}

	public String getFileMaker() {
		return fileMaker;
	}

	public void setFileMaker(String fileMaker) {
		this.fileMaker = fileMaker;
	}

	public String getZipCodes() {
		return zipCodes;
	}

	public void setZipCodes(String zipCodes) {
		this.zipCodes = zipCodes;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getTimepark() {
		return timepark;
	}

	public void setTimepark(String timepark) {
		this.timepark = timepark;
	}

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getVehiclemodels() {
		return vehiclemodels;
	}

	public void setVehiclemodels(String vehiclemodels) {
		this.vehiclemodels = vehiclemodels;
	}

	public String getVehiclemakes() {
		return vehiclemakes;
	}

	public void setVehiclemakes(String vehiclemakes) {
		this.vehiclemakes = vehiclemakes;
	}

	public void setTallyUserUri(String tallyUserUri) {
		this.tallyUserUri = tallyUserUri;
	}

	public String getTallyRoleUri() {
		return tallyRoleUri;
	}

	public void setTallyRoleUri(String tallyRoleUri) {
		this.tallyRoleUri = tallyRoleUri;
	}

	public String getTallyLDAPLogOut() {
		return tallyLDAPLogOut;
	}

	public void setTallyLDAPLogOut(String tallyLDAPLogOut) {
		this.tallyLDAPLogOut = tallyLDAPLogOut;
	}

	public String getTallyLDAPAccesTokenUri() {
		return tallyLDAPAccesTokenUri;
	}

	public void setTallyLDAPAccesTokenUri(String tallyLDAPAccesTokenUri) {
		this.tallyLDAPAccesTokenUri = tallyLDAPAccesTokenUri;
	}

	public String getIparkBrandCode() {
		return iparkBrandCode;
	}

	public void setIparkBrandCode(String iparkBrandCode) {
		this.iparkBrandCode = iparkBrandCode;
	}

	public String getIparkCompanyName() {
		return iparkCompanyName;
	}

	public void setIparkCompanyName(String iparkCompanyName) {
		this.iparkCompanyName = iparkCompanyName;
	}

	public String getOpenOrClosedMonthUri() {
		return openOrClosedMonthUri;
	}

	public void setOpenOrClosedMonthUri(String openOrClosedMonthUri) {
		this.openOrClosedMonthUri = openOrClosedMonthUri;
	}

	public String getGaragesUri() {
		return garagesUri;
	}

	public void setGaragesUri(String garagesUri) {
		this.garagesUri = garagesUri;
	}

	public String getTransientUri() {
		return transientUri;
	}

	public void setTransientUri(String transientUri) {
		this.transientUri = transientUri;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getMissingDatesAndTotalsUri() {
		return missingDatesAndTotalsUri;
	}

	public void setMissingDatesAndTotalsUri(String missingDatesAndTotalsUri) {
		this.missingDatesAndTotalsUri = missingDatesAndTotalsUri;
	}

	public String getTransientSearchUri() {
		return transientSearchUri;
	}

	public void setTransientSearchUri(String transientSearchUri) {
		this.transientSearchUri = transientSearchUri;
	}

	public String getPaymentTypesUri() {
		return paymentTypesUri;
	}

	public void setPaymentTypesUri(String paymentTypesUri) {
		this.paymentTypesUri = paymentTypesUri;
	}

	public String getCreditCardsUri() {
		return creditCardsUri;
	}

	public void setCreditCardsUri(String creditCardsUri) {
		this.creditCardsUri = creditCardsUri;
	}

	public String getTransientBanksDepositUri() {
		return transientBanksDepositUri;
	}

	public void setTransientBanksDepositUri(String transientBanksDepositUri) {
		this.transientBanksDepositUri = transientBanksDepositUri;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	
	
}
