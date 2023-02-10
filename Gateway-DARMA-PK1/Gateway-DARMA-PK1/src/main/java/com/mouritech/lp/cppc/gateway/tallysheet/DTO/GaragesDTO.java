package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.views.TallySheetView;

public class GaragesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(TallySheetView.DropdownGarages.class)
	private Integer Id;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String garageCode;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String manager;
	private String currentSupervisor;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String locationId;
	private String shortName;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String name;

	private String buildingname;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String address1;

	private String address2;

	private String garageEntrance;

	private String garage;

	private ZipCodesDTO Zip_CodeDTO;

	private Set<GarageBanksDTO> garageBanksDTO = new HashSet<GarageBanksDTO>();
	@JsonView(TallySheetView.DropdownGarages.class)
	private String garageEmail;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String garageSupervisiorEmail;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String garageFullAddress;
	@JsonView(TallySheetView.DropdownGarages.class)
	private Boolean isApplicableForTally;
	@JsonView(TallySheetView.DropdownGarages.class)
	private Boolean isApplicableForMonthly;
	
	@JsonView(TallySheetView.DropdownGarages.class)
	private Boolean isManualEntry;

	private String phone1;

	private String Phone2;

	private String phone3;

	private String fax;

	private String residentialAddr1;

	private String residentialAddr2;

	private String residentialAddr3;

	private Boolean elevatorFlag;

	private String elevatorType;

	private Integer noOfFloors;

	private Boolean ManLiftAvailableFlag;

	private String heightLimit;

	private Boolean vanAcceptanceFlag;

	private Boolean selfParkingFlag;

	private String garageHours;

	private Integer garageCapacity;

	private String licenseNumber;

	private String aRPersonCode;

	private Boolean activeFlag;

	private LocalDateTime garageStartDate;

	private LocalDateTime tempCloseDate;

	private LocalDateTime tempReopenDate;

	private Boolean manhattanExemptionFlag;

	private String federalTaxId;

	private Boolean servicesAvailableFlag;

	private BigDecimal lateFeeAmount;

	private String gLIntegrationCode;

	private Boolean autoCreditFlag;

	private String salesAccount;

	private String salesTaxAccount;

	private String monthlyAccountNumber;

	private String salesPaidoutAC;

	private String SalesOverAC;

	private String shareHolderImageName;

	private String payrollCode;

	private String garageNotes;

	private String ccExchangeMonthly;

	private Integer noOfelevators;

	private String serviceCompany;

	private BigDecimal postedRate;

	private LocalDateTime recentResidentIncrease;

	private LocalDateTime recentNonResidentIncrease;

	private LocalDateTime lastResidentIncrease;

	private LocalDateTime lastNonResidentIncrease;

	private Boolean crtExemptionFlag;

	private LocalDateTime garageClosedDate;

	private Boolean lateFeeFlag;

	private String altName;

	private String billingMethodID;

	private Boolean blockAccountMaintFee;

	private Boolean excludeFromTicketechChargeTicketImport;

	
	
	public Boolean getIsManualEntry() {
		return isManualEntry;
	}

	public void setIsManualEntry(Boolean isManualEntry) {
		this.isManualEntry = isManualEntry;
	}

	public Boolean getIsApplicableForTally() {
		return isApplicableForTally;
	}

	public void setIsApplicableForTally(Boolean isApplicableForTally) {
		this.isApplicableForTally = isApplicableForTally;
	}

	public Boolean getIsApplicableForMonthly() {
		return isApplicableForMonthly;
	}

	public void setIsApplicableForMonthly(Boolean isApplicableForMonthly) {
		this.isApplicableForMonthly = isApplicableForMonthly;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return Phone2;
	}

	public void setPhone2(String phone2) {
		Phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getResidentialAddr1() {
		return residentialAddr1;
	}

	public void setResidentialAddr1(String residentialAddr1) {
		this.residentialAddr1 = residentialAddr1;
	}

	public String getResidentialAddr2() {
		return residentialAddr2;
	}

	public void setResidentialAddr2(String residentialAddr2) {
		this.residentialAddr2 = residentialAddr2;
	}

	public String getResidentialAddr3() {
		return residentialAddr3;
	}

	public void setResidentialAddr3(String residentialAddr3) {
		this.residentialAddr3 = residentialAddr3;
	}

	public Boolean getElevatorFlag() {
		return elevatorFlag;
	}

	public void setElevatorFlag(Boolean elevatorFlag) {
		this.elevatorFlag = elevatorFlag;
	}

	public String getElevatorType() {
		return elevatorType;
	}

	public void setElevatorType(String elevatorType) {
		this.elevatorType = elevatorType;
	}

	public Integer getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(Integer noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public Boolean getManLiftAvailableFlag() {
		return ManLiftAvailableFlag;
	}

	public void setManLiftAvailableFlag(Boolean manLiftAvailableFlag) {
		ManLiftAvailableFlag = manLiftAvailableFlag;
	}

	public String getHeightLimit() {
		return heightLimit;
	}

	public void setHeightLimit(String heightLimit) {
		this.heightLimit = heightLimit;
	}

	public Boolean getVanAcceptanceFlag() {
		return vanAcceptanceFlag;
	}

	public void setVanAcceptanceFlag(Boolean vanAcceptanceFlag) {
		this.vanAcceptanceFlag = vanAcceptanceFlag;
	}

	public Boolean getSelfParkingFlag() {
		return selfParkingFlag;
	}

	public void setSelfParkingFlag(Boolean selfParkingFlag) {
		this.selfParkingFlag = selfParkingFlag;
	}

	public String getGarageHours() {
		return garageHours;
	}

	public void setGarageHours(String garageHours) {
		this.garageHours = garageHours;
	}

	public Integer getGarageCapacity() {
		return garageCapacity;
	}

	public void setGarageCapacity(Integer garageCapacity) {
		this.garageCapacity = garageCapacity;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getaRPersonCode() {
		return aRPersonCode;
	}

	public void setaRPersonCode(String aRPersonCode) {
		this.aRPersonCode = aRPersonCode;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public LocalDateTime getGarageStartDate() {
		return garageStartDate;
	}

	public void setGarageStartDate(LocalDateTime garageStartDate) {
		this.garageStartDate = garageStartDate;
	}

	public LocalDateTime getTempCloseDate() {
		return tempCloseDate;
	}

	public void setTempCloseDate(LocalDateTime tempCloseDate) {
		this.tempCloseDate = tempCloseDate;
	}

	public LocalDateTime getTempReopenDate() {
		return tempReopenDate;
	}

	public void setTempReopenDate(LocalDateTime tempReopenDate) {
		this.tempReopenDate = tempReopenDate;
	}

	public Boolean getManhattanExemptionFlag() {
		return manhattanExemptionFlag;
	}

	public void setManhattanExemptionFlag(Boolean manhattanExemptionFlag) {
		this.manhattanExemptionFlag = manhattanExemptionFlag;
	}

	public String getFederalTaxId() {
		return federalTaxId;
	}

	public void setFederalTaxId(String federalTaxId) {
		this.federalTaxId = federalTaxId;
	}

	public Boolean getServicesAvailableFlag() {
		return servicesAvailableFlag;
	}

	public void setServicesAvailableFlag(Boolean servicesAvailableFlag) {
		this.servicesAvailableFlag = servicesAvailableFlag;
	}

	public BigDecimal getLateFeeAmount() {
		return lateFeeAmount;
	}

	public void setLateFeeAmount(BigDecimal lateFeeAmount) {
		this.lateFeeAmount = lateFeeAmount;
	}

	public String getgLIntegrationCode() {
		return gLIntegrationCode;
	}

	public void setgLIntegrationCode(String gLIntegrationCode) {
		this.gLIntegrationCode = gLIntegrationCode;
	}

	public Boolean getAutoCreditFlag() {
		return autoCreditFlag;
	}

	public void setAutoCreditFlag(Boolean autoCreditFlag) {
		this.autoCreditFlag = autoCreditFlag;
	}

	public String getSalesAccount() {
		return salesAccount;
	}

	public void setSalesAccount(String salesAccount) {
		this.salesAccount = salesAccount;
	}

	public String getSalesTaxAccount() {
		return salesTaxAccount;
	}

	public void setSalesTaxAccount(String salesTaxAccount) {
		this.salesTaxAccount = salesTaxAccount;
	}

	public String getMonthlyAccountNumber() {
		return monthlyAccountNumber;
	}

	public void setMonthlyAccountNumber(String monthlyAccountNumber) {
		this.monthlyAccountNumber = monthlyAccountNumber;
	}

	public String getSalesPaidoutAC() {
		return salesPaidoutAC;
	}

	public void setSalesPaidoutAC(String salesPaidoutAC) {
		this.salesPaidoutAC = salesPaidoutAC;
	}

	public String getSalesOverAC() {
		return SalesOverAC;
	}

	public void setSalesOverAC(String salesOverAC) {
		SalesOverAC = salesOverAC;
	}

	public String getShareHolderImageName() {
		return shareHolderImageName;
	}

	public void setShareHolderImageName(String shareHolderImageName) {
		this.shareHolderImageName = shareHolderImageName;
	}

	public String getPayrollCode() {
		return payrollCode;
	}

	public void setPayrollCode(String payrollCode) {
		this.payrollCode = payrollCode;
	}

	public String getGarageNotes() {
		return garageNotes;
	}

	public void setGarageNotes(String garageNotes) {
		this.garageNotes = garageNotes;
	}

	public String getCcExchangeMonthly() {
		return ccExchangeMonthly;
	}

	public void setCcExchangeMonthly(String ccExchangeMonthly) {
		this.ccExchangeMonthly = ccExchangeMonthly;
	}

	public Integer getNoOfelevators() {
		return noOfelevators;
	}

	public void setNoOfelevators(Integer noOfelevators) {
		this.noOfelevators = noOfelevators;
	}

	public String getServiceCompany() {
		return serviceCompany;
	}

	public void setServiceCompany(String serviceCompany) {
		this.serviceCompany = serviceCompany;
	}

	public BigDecimal getPostedRate() {
		return postedRate;
	}

	public void setPostedRate(BigDecimal postedRate) {
		this.postedRate = postedRate;
	}

	public LocalDateTime getRecentResidentIncrease() {
		return recentResidentIncrease;
	}

	public void setRecentResidentIncrease(LocalDateTime recentResidentIncrease) {
		this.recentResidentIncrease = recentResidentIncrease;
	}

	public LocalDateTime getRecentNonResidentIncrease() {
		return recentNonResidentIncrease;
	}

	public void setRecentNonResidentIncrease(LocalDateTime recentNonResidentIncrease) {
		this.recentNonResidentIncrease = recentNonResidentIncrease;
	}

	public LocalDateTime getLastResidentIncrease() {
		return lastResidentIncrease;
	}

	public void setLastResidentIncrease(LocalDateTime lastResidentIncrease) {
		this.lastResidentIncrease = lastResidentIncrease;
	}

	public LocalDateTime getLastNonResidentIncrease() {
		return lastNonResidentIncrease;
	}

	public void setLastNonResidentIncrease(LocalDateTime lastNonResidentIncrease) {
		this.lastNonResidentIncrease = lastNonResidentIncrease;
	}

	public Boolean getCrtExemptionFlag() {
		return crtExemptionFlag;
	}

	public void setCrtExemptionFlag(Boolean crtExemptionFlag) {
		this.crtExemptionFlag = crtExemptionFlag;
	}

	public LocalDateTime getGarageClosedDate() {
		return garageClosedDate;
	}

	public void setGarageClosedDate(LocalDateTime garageClosedDate) {
		this.garageClosedDate = garageClosedDate;
	}

	public Boolean getLateFeeFlag() {
		return lateFeeFlag;
	}

	public void setLateFeeFlag(Boolean lateFeeFlag) {
		this.lateFeeFlag = lateFeeFlag;
	}

	public String getAltName() {
		return altName;
	}

	public void setAltName(String altName) {
		this.altName = altName;
	}

	public String getBillingMethodID() {
		return billingMethodID;
	}

	public void setBillingMethodID(String billingMethodID) {
		this.billingMethodID = billingMethodID;
	}

	public Boolean getBlockAccountMaintFee() {
		return blockAccountMaintFee;
	}

	public void setBlockAccountMaintFee(Boolean blockAccountMaintFee) {
		this.blockAccountMaintFee = blockAccountMaintFee;
	}

	public Boolean getExcludeFromTicketechChargeTicketImport() {
		return excludeFromTicketechChargeTicketImport;
	}

	public void setExcludeFromTicketechChargeTicketImport(Boolean excludeFromTicketechChargeTicketImport) {
		this.excludeFromTicketechChargeTicketImport = excludeFromTicketechChargeTicketImport;
	}

	public String getGarageFullAddress() {
		return garageFullAddress;
	}

	public void setGarageFullAddress(String garageFullAddress) {
		this.garageFullAddress = garageFullAddress;
	}

	public String getGarageEmail() {
		return garageEmail;
	}

	public void setGarageEmail(String garageEmail) {
		this.garageEmail = garageEmail;
	}

	public String getGarageSupervisiorEmail() {
		return garageSupervisiorEmail;
	}

	public void setGarageSupervisiorEmail(String garageSupervisiorEmail) {
		this.garageSupervisiorEmail = garageSupervisiorEmail;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getGarageCode() {
		return garageCode;
	}

	public void setGarageCode(String garageCode) {
		this.garageCode = garageCode;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuildingname() {
		return buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getGarageEntrance() {
		return garageEntrance;
	}

	public void setGarageEntrance(String garageEntrance) {
		this.garageEntrance = garageEntrance;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public ZipCodesDTO getZip_CodeDTO() {
		return Zip_CodeDTO;
	}

	public void setZip_CodeDTO(ZipCodesDTO zip_CodeDTO) {
		Zip_CodeDTO = zip_CodeDTO;
	}

	public Set<GarageBanksDTO> getGarageBanksDTO() {
		return garageBanksDTO;
	}

	public void setGarageBanksDTO(Set<GarageBanksDTO> garageBanksDTO) {
		this.garageBanksDTO = garageBanksDTO;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getCurrentSupervisor() {
		return currentSupervisor;
	}

	public void setCurrentSupervisor(String currentSupervisor) {
		this.currentSupervisor = currentSupervisor;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "GaragesDTO [Id=" + Id + ", garageCode=" + garageCode + ", manager=" + manager + ", currentSupervisor="
				+ currentSupervisor + ", locationId=" + locationId + ", shortName=" + shortName + ", name=" + name
				+ ", buildingname=" + buildingname + ", address1=" + address1 + ", address2=" + address2
				+ ", garageEntrance=" + garageEntrance + ", garage=" + garage + ", Zip_CodeDTO=" + Zip_CodeDTO
				+ ", garageBanksDTO=" + garageBanksDTO + ", garageEmail=" + garageEmail + ", garageSupervisiorEmail="
				+ garageSupervisiorEmail + ", garageFullAddress=" + garageFullAddress + ", isApplicableForTally="
				+ isApplicableForTally + ", isApplicableForMonthly=" + isApplicableForMonthly + ", phone1=" + phone1
				+ ", Phone2=" + Phone2 + ", phone3=" + phone3 + ", fax=" + fax + ", residentialAddr1="
				+ residentialAddr1 + ", residentialAddr2=" + residentialAddr2 + ", residentialAddr3=" + residentialAddr3
				+ ", elevatorFlag=" + elevatorFlag + ", elevatorType=" + elevatorType + ", noOfFloors=" + noOfFloors
				+ ", ManLiftAvailableFlag=" + ManLiftAvailableFlag + ", heightLimit=" + heightLimit
				+ ", vanAcceptanceFlag=" + vanAcceptanceFlag + ", selfParkingFlag=" + selfParkingFlag + ", garageHours="
				+ garageHours + ", garageCapacity=" + garageCapacity + ", licenseNumber=" + licenseNumber
				+ ", aRPersonCode=" + aRPersonCode + ", activeFlag=" + activeFlag + ", garageStartDate="
				+ garageStartDate + ", tempCloseDate=" + tempCloseDate + ", tempReopenDate=" + tempReopenDate
				+ ", manhattanExemptionFlag=" + manhattanExemptionFlag + ", federalTaxId=" + federalTaxId
				+ ", servicesAvailableFlag=" + servicesAvailableFlag + ", lateFeeAmount=" + lateFeeAmount
				+ ", gLIntegrationCode=" + gLIntegrationCode + ", autoCreditFlag=" + autoCreditFlag + ", salesAccount="
				+ salesAccount + ", salesTaxAccount=" + salesTaxAccount + ", monthlyAccountNumber="
				+ monthlyAccountNumber + ", salesPaidoutAC=" + salesPaidoutAC + ", SalesOverAC=" + SalesOverAC
				+ ", shareHolderImageName=" + shareHolderImageName + ", payrollCode=" + payrollCode + ", garageNotes="
				+ garageNotes + ", ccExchangeMonthly=" + ccExchangeMonthly + ", noOfelevators=" + noOfelevators
				+ ", serviceCompany=" + serviceCompany + ", postedRate=" + postedRate + ", recentResidentIncrease="
				+ recentResidentIncrease + ", recentNonResidentIncrease=" + recentNonResidentIncrease
				+ ", lastResidentIncrease=" + lastResidentIncrease + ", lastNonResidentIncrease="
				+ lastNonResidentIncrease + ", crtExemptionFlag=" + crtExemptionFlag + ", garageClosedDate="
				+ garageClosedDate + ", lateFeeFlag=" + lateFeeFlag + ", altName=" + altName + ", billingMethodID="
				+ billingMethodID + ", blockAccountMaintFee=" + blockAccountMaintFee
				+ ", excludeFromTicketechChargeTicketImport=" + excludeFromTicketechChargeTicketImport + "]";
	}

}