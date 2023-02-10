package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;
import com.mouritech.lp.cppc.gateway.util.CustomDateTimeSerializer;

public class LocSyncLocationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String brand;

	private String siteOrSubsite;

	private String locationID;

	private String locationName;

	private String legalEntity;

	private List<PropertyAddressDTO> propertyAddress;

	private List<MailingAddressDTO> mailingAddress;

	private String operationType;

	private String facilityType;
	
	@NotNull(message = "startDate is required")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime startDate;

	private StatusEnum status;

	@NotNull(message = "endDate is required")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime endDate;

	private Integer noofSpaces;

	private String timeZone;

	private String region;

	private String businessUnitLevel;

	private String territoryLevel;

	private String locationManager;

	private String secondaryApprovingManager;

	private String svp;

	private String rvp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSiteOrSubsite() {
		return siteOrSubsite;
	}

	public void setSiteOrSubsite(String siteOrSubsite) {
		this.siteOrSubsite = siteOrSubsite;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public List<PropertyAddressDTO> getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(List<PropertyAddressDTO> propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public List<MailingAddressDTO> getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(List<MailingAddressDTO> mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getNoofSpaces() {
		return noofSpaces;
	}

	public void setNoofSpaces(Integer noofSpaces) {
		this.noofSpaces = noofSpaces;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBusinessUnitLevel() {
		return businessUnitLevel;
	}

	public void setBusinessUnitLevel(String businessUnitLevel) {
		this.businessUnitLevel = businessUnitLevel;
	}

	public String getTerritoryLevel() {
		return territoryLevel;
	}

	public void setTerritoryLevel(String territoryLevel) {
		this.territoryLevel = territoryLevel;
	}

	public String getLocationManager() {
		return locationManager;
	}

	public void setLocationManager(String locationManager) {
		this.locationManager = locationManager;
	}

	public String getSecondaryApprovingManager() {
		return secondaryApprovingManager;
	}

	public void setSecondaryApprovingManager(String secondaryApprovingManager) {
		this.secondaryApprovingManager = secondaryApprovingManager;
	}

	public String getSvp() {
		return svp;
	}

	public void setSvp(String svp) {
		this.svp = svp;
	}

	public String getRvp() {
		return rvp;
	}

	public void setRvp(String rvp) {
		this.rvp = rvp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
