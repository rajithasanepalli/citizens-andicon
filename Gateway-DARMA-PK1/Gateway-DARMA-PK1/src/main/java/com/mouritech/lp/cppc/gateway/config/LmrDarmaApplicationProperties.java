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
@ConfigurationProperties(prefix = "lmrDarma", ignoreUnknownFields = false)
public class LmrDarmaApplicationProperties {

	private String lanierComapanyName;
	private String park1ComapanyName;
	private String ameriparkComapanyName;
	private String iParkComapanyName;
	private String lanierBrandCode;
	private String park1BrandCode;
	private String ameriparkBrandCode;
	private String iParkBrandCode;

	private String lanierParking;
	private String ameriPark;

	public String getLanierComapanyName() {
		return lanierComapanyName;
	}

	public void setLanierComapanyName(String lanierComapanyName) {
		this.lanierComapanyName = lanierComapanyName;
	}

	public String getPark1ComapanyName() {
		return park1ComapanyName;
	}

	public void setPark1ComapanyName(String park1ComapanyName) {
		this.park1ComapanyName = park1ComapanyName;
	}

	public String getAmeriparkComapanyName() {
		return ameriparkComapanyName;
	}

	public void setAmeriparkComapanyName(String ameriparkComapanyName) {
		this.ameriparkComapanyName = ameriparkComapanyName;
	}

	public String getLanierBrandCode() {
		return lanierBrandCode;
	}

	public void setLanierBrandCode(String lanierBrandCode) {
		this.lanierBrandCode = lanierBrandCode;
	}

	public String getPark1BrandCode() {
		return park1BrandCode;
	}

	public void setPark1BrandCode(String park1BrandCode) {
		this.park1BrandCode = park1BrandCode;
	}

	public String getAmeriparkBrandCode() {
		return ameriparkBrandCode;
	}

	public void setAmeriparkBrandCode(String ameriparkBrandCode) {
		this.ameriparkBrandCode = ameriparkBrandCode;
	}

	public String getLanierParking() {
		return lanierParking;
	}

	public void setLanierParking(String lanierParking) {
		this.lanierParking = lanierParking;
	}

	public String getAmeriPark() {
		return ameriPark;
	}

	public void setAmeriPark(String ameriPark) {
		this.ameriPark = ameriPark;
	}

	public String getiParkComapanyName() {
		return iParkComapanyName;
	}

	public void setiParkComapanyName(String iParkComapanyName) {
		this.iParkComapanyName = iParkComapanyName;
	}

	public String getiParkBrandCode() {
		return iParkBrandCode;
	}

	public void setiParkBrandCode(String iParkBrandCode) {
		this.iParkBrandCode = iParkBrandCode;
	}

}
