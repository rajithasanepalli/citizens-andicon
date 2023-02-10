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
@ConfigurationProperties(prefix = "locsync", ignoreUnknownFields = false)
public class LocSyncApplicationProperties {
	private String accessTokenUri;
	private String apiKey;
	private String locationUri;

	public String getAccessTokenUri() {
		return accessTokenUri;
	}

	public void setAccessTokenUri(String accessTokenUri) {
		this.accessTokenUri = accessTokenUri;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getLocationUri() {
		return locationUri;
	}

	public void setLocationUri(String locationUri) {
		this.locationUri = locationUri;
	}

}
