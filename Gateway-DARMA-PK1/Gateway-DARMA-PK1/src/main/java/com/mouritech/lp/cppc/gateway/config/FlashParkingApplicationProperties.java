package com.mouritech.lp.cppc.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to Client portal Application.
 *
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@Configuration
@ConfigurationProperties(prefix = "fp", ignoreUnknownFields = false)
public class FlashParkingApplicationProperties {

	private String fpApiKey;
	private String fpAccessTokenUri;
	private String flashparking;

	public String getFpApiKey() {
		return fpApiKey;
	}

	public void setFpApiKey(String fpApiKey) {
		this.fpApiKey = fpApiKey;
	}

	public String getFpAccessTokenUri() {
		return fpAccessTokenUri;
	}

	public void setFpAccessTokenUri(String fpAccessTokenUri) {
		this.fpAccessTokenUri = fpAccessTokenUri;
	}

	public String getFlashparking() {
		return flashparking;
	}

	public void setFlashparking(String flashparking) {
		this.flashparking = flashparking;
	}

}
