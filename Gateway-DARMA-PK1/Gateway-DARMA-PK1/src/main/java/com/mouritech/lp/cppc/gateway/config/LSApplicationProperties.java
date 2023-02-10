package com.mouritech.lp.cppc.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to LocationsyncApplication.
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@Configuration
@ConfigurationProperties(prefix = "locationsync", ignoreUnknownFields = false)
public class LSApplicationProperties {

	private String apiKey;

	private String addressUri;

	private String contactUri;

	private String entityUri;

	private String gatewayProcessorLinkUri;

	private String gatewayUri;

	private String locationDeviceUri;

	private String locationMidLinkUri;

	private String locationVendorLinkUri;

	private String midUri;

	private String parcsUri;

	private String parcsVendorLinkUri;

	private String paymentDeviceUri;

	private String processorUri;

	private String stateUri;

	private String vendorUri;
	
	private String secondaryMidUri;
	
	private String locationpci;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getAddressUri() {
		return addressUri;
	}

	public void setAddressUri(String addressUri) {
		this.addressUri = addressUri;
	}

	public String getContactUri() {
		return contactUri;
	}

	public void setContactUri(String contactUri) {
		this.contactUri = contactUri;
	}

	public String getEntityUri() {
		return entityUri;
	}

	public void setEntityUri(String entityUri) {
		this.entityUri = entityUri;
	}

	public String getGatewayProcessorLinkUri() {
		return gatewayProcessorLinkUri;
	}

	public void setGatewayProcessorLinkUri(String gatewayProcessorLinkUri) {
		this.gatewayProcessorLinkUri = gatewayProcessorLinkUri;
	}

	public String getGatewayUri() {
		return gatewayUri;
	}

	public void setGatewayUri(String gatewayUri) {
		this.gatewayUri = gatewayUri;
	}

	public String getLocationDeviceUri() {
		return locationDeviceUri;
	}

	public void setLocationDeviceUri(String locationDeviceUri) {
		this.locationDeviceUri = locationDeviceUri;
	}

	public String getLocationMidLinkUri() {
		return locationMidLinkUri;
	}

	public void setLocationMidLinkUri(String locationMidLinkUri) {
		this.locationMidLinkUri = locationMidLinkUri;
	}

	public String getLocationVendorLinkUri() {
		return locationVendorLinkUri;
	}

	public void setLocationVendorLinkUri(String locationVendorLinkUri) {
		this.locationVendorLinkUri = locationVendorLinkUri;
	}

	public String getMidUri() {
		return midUri;
	}

	public void setMidUri(String midUri) {
		this.midUri = midUri;
	}

	public String getParcsUri() {
		return parcsUri;
	}

	public void setParcsUri(String parcsUri) {
		this.parcsUri = parcsUri;
	}

	public String getParcsVendorLinkUri() {
		return parcsVendorLinkUri;
	}

	public void setParcsVendorLinkUri(String parcsVendorLinkUri) {
		this.parcsVendorLinkUri = parcsVendorLinkUri;
	}

	public String getPaymentDeviceUri() {
		return paymentDeviceUri;
	}

	public void setPaymentDeviceUri(String paymentDeviceUri) {
		this.paymentDeviceUri = paymentDeviceUri;
	}

	public String getProcessorUri() {
		return processorUri;
	}

	public void setProcessorUri(String processorUri) {
		this.processorUri = processorUri;
	}

	public String getStateUri() {
		return stateUri;
	}

	public void setStateUri(String stateUri) {
		this.stateUri = stateUri;
	}

	public String getVendorUri() {
		return vendorUri;
	}

	public void setVendorUri(String vendorUri) {
		this.vendorUri = vendorUri;
	}

	public String getSecondaryMidUri() {
		return secondaryMidUri;
	}

	public void setSecondaryMidUri(String secondaryMidUri) {
		this.secondaryMidUri = secondaryMidUri;
	}

	public String getLocationpci() {
		return locationpci;
	}

	public void setLocationpci(String locationpci) {
		this.locationpci = locationpci;
	}
	
	
}
