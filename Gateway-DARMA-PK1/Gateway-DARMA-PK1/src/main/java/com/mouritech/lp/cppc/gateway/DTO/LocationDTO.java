package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.DTO.enums.LocationStatusEnum;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;
import com.mouritech.lp.cppc.gateway.views.View;

public class LocationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonView(View.DropdownLocation.class)
	private String id;

	@JsonView(View.DropdownLocation.class)
	private String locationID;

	@JsonView(View.DropdownLocation.class)
	private String name;

	@JsonView(View.Location.class)
	private String clientLegalName;

	@JsonView(View.Location.class)
	private String address1;

	@JsonView(View.Location.class)
	private String address2;

	@JsonView(View.Location.class)
	private String city;

	@JsonView(View.Location.class)
	private String county;

	@JsonView(View.Location.class)
	private String state;

	@JsonView(View.Location.class)
	private String zipCode;

	@JsonView(View.Location.class)
	private StatusEnum status;

	@JsonView(View.Location.class)
	private String phone;

	@JsonView(View.Location.class)
	private String cell;

	@JsonView(View.Location.class)
	private String fax;

	@JsonView(View.Location.class)
	private String ext;

	@JsonView(View.Location.class)
	private String companyName;

	@JsonView(View.Location.class)
	private String executive;

	@JsonView(View.Location.class)
	private String serviceType;

	@JsonView(View.Location.class)
	private String contractType;

	@JsonView(View.Location.class)
	private Integer noofSpaces;

	@JsonView(View.Location.class)
	private String subsidyType;

	@JsonView(View.Location.class)
	private String parentLocationID;

	@JsonView(View.Location.class)
	private String parentLocationName;

	@JsonView(View.Location.class)
	private String brandCode;

	@JsonView(View.Location.class)
	private Boolean applicableForDarma;

	private RegionDTO regionDTO;
	private Set<LocationNotesDTO> notesDTO = new HashSet<LocationNotesDTO>();
	private Set<TenderTypesLocationLinkDTO> tenderTypesLnkDTO = new HashSet<TenderTypesLocationLinkDTO>();
	private Set<RevenueTypesLocationLinkDTO> revenueTypesLnkDTO = new HashSet<RevenueTypesLocationLinkDTO>();
	private Set<BankAccountsLocationLinkDTO> bankAccountsLocationLinkDTO = new HashSet<>();
	private Set<BurdensDTO> burdensDTO = new HashSet<BurdensDTO>();
	private Set<PositionsAndBillingRatesDTO> rolesAndBillingRatesDTO = new HashSet<PositionsAndBillingRatesDTO>();
	private Set<LocationContactDTO> locationContactDTO = new HashSet<LocationContactDTO>();
	private BurdenInfoDTO burdenInfoDTO;
	private Set<ExclusionBurdensDTO> exclusionBurdensDTO = new HashSet<ExclusionBurdensDTO>();
	private LocationMoreInfoDTO locationMoreInfoDTO;
	private UserDTO darmaUser;
	private BrandDTO brandDTO;

	// new columns added
	@JsonView(View.Location.class)
	private LocationStatusEnum dataView;
	@JsonView(View.Location.class)
	private String hoursOfOperation;
	@JsonView(View.Location.class)
	private String noOfGarageLevels;
	@JsonView(View.Location.class)
	private String noOfEntryLanes;
	@JsonView(View.Location.class)
	private String noOfExitLanes;
	@JsonView(View.Location.class)
	private String parcsManufacture;
	@JsonView(View.Location.class)
	private LocalDateTime dateOfLastMonthlyRateIncrease;
	@JsonView(View.Location.class)
	private LocalDateTime dateOfLastTransientRateIncrease;
	@JsonView(View.Location.class)
	private String typeOfFacility;

	@JsonView(View.Location.class)
	private Integer dueDay;
	@JsonView(View.Location.class)
	private Integer settlementDay;

	@JsonView(View.Location.class)
	private String iconName;

	@JsonView(View.Location.class)
	private Boolean budget;

	public BrandDTO getBrandDTO() {
		return brandDTO;
	}

	public void setBrandDTO(BrandDTO brandDTO) {
		this.brandDTO = brandDTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserDTO getDarmaUser() {
		return darmaUser;
	}

	public void setDarmaUser(UserDTO darmaUser) {
		this.darmaUser = darmaUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RevenueTypesLocationLinkDTO> getRevenueTypesLnkDTO() {
		return revenueTypesLnkDTO;
	}

	public void setRevenueTypesLnkDTO(
			Set<RevenueTypesLocationLinkDTO> revenueTypesLnkDTO) {
		this.revenueTypesLnkDTO = revenueTypesLnkDTO;
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

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getSubsidyType() {
		return subsidyType;
	}

	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
	}

	public RegionDTO getRegionDTO() {
		return regionDTO;
	}

	public void setRegionDTO(RegionDTO regionDTO) {
		this.regionDTO = regionDTO;
	}

	public String getParentLocationID() {
		return parentLocationID;
	}

	public void setParentLocationID(String parentLocationID) {
		this.parentLocationID = parentLocationID;
	}

	public String getParentLocationName() {
		return parentLocationName;
	}

	public void setParentLocationName(String parentLocationName) {
		this.parentLocationName = parentLocationName;
	}

	public Set<LocationNotesDTO> getNotesDTO() {
		return notesDTO;
	}

	public void setNotesDTO(Set<LocationNotesDTO> notesDTO) {
		this.notesDTO = notesDTO;
	}

	public Set<TenderTypesLocationLinkDTO> getTenderTypesLnkDTO() {
		return tenderTypesLnkDTO;
	}

	public void setTenderTypesLnkDTO(
			Set<TenderTypesLocationLinkDTO> tenderTypesLnkDTO) {
		this.tenderTypesLnkDTO = tenderTypesLnkDTO;
	}

	public Set<BankAccountsLocationLinkDTO> getBankAccountsLocationLinkDTO() {
		return bankAccountsLocationLinkDTO;
	}

	public void setBankAccountsLocationLinkDTO(
			Set<BankAccountsLocationLinkDTO> bankAccountsLocationLinkDTO) {
		this.bankAccountsLocationLinkDTO = bankAccountsLocationLinkDTO;
	}

	public Set<BurdensDTO> getBurdensDTO() {
		return burdensDTO;
	}

	public void setBurdensDTO(Set<BurdensDTO> set) {
		this.burdensDTO = set;
	}

	public Set<PositionsAndBillingRatesDTO> getRolesAndBillingRatesDTO() {
		return rolesAndBillingRatesDTO;
	}

	public void setRolesAndBillingRatesDTO(
			Set<PositionsAndBillingRatesDTO> rolesAndBillingRatesDTO) {
		this.rolesAndBillingRatesDTO = rolesAndBillingRatesDTO;
	}

	public Set<LocationContactDTO> getLocationContactDTO() {
		return locationContactDTO;
	}

	public void setLocationContactDTO(Set<LocationContactDTO> locationContactDTO) {
		this.locationContactDTO = locationContactDTO;
	}

	public LocationMoreInfoDTO getLocationMoreInfoDTO() {
		return locationMoreInfoDTO;
	}

	public void setLocationMoreInfoDTO(LocationMoreInfoDTO locationMoreInfoDTO) {
		this.locationMoreInfoDTO = locationMoreInfoDTO;
	}

	public String getClientLegalName() {
		return clientLegalName;
	}

	public void setClientLegalName(String clientLegalName) {
		this.clientLegalName = clientLegalName;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getExecutive() {
		return executive;
	}

	public void setExecutive(String executive) {
		this.executive = executive;
	}

	public Integer getNoofSpaces() {
		return noofSpaces;
	}

	public void setNoofSpaces(Integer noofSpaces) {
		this.noofSpaces = noofSpaces;
	}

	public BurdenInfoDTO getBurdenInfoDTO() {
		return burdenInfoDTO;
	}

	public void setBurdenInfoDTO(BurdenInfoDTO burdenInfoDTO) {
		this.burdenInfoDTO = burdenInfoDTO;
	}

	public Set<ExclusionBurdensDTO> getExclusionBurdensDTO() {
		return exclusionBurdensDTO;
	}

	public void setExclusionBurdensDTO(
			Set<ExclusionBurdensDTO> exclusionBurdensDTO) {
		this.exclusionBurdensDTO = exclusionBurdensDTO;
	}

	public Boolean getApplicableForDarma() {
		return applicableForDarma;
	}

	public void setApplicableForDarma(Boolean applicableForDarma) {
		this.applicableForDarma = applicableForDarma;
	}

	public String getHoursOfOperation() {
		return hoursOfOperation;
	}

	public void setHoursOfOperation(String hoursOfOperation) {
		this.hoursOfOperation = hoursOfOperation;
	}

	public String getNoOfGarageLevels() {
		return noOfGarageLevels;
	}

	public void setNoOfGarageLevels(String noOfGarageLevels) {
		this.noOfGarageLevels = noOfGarageLevels;
	}

	public String getNoOfEntryLanes() {
		return noOfEntryLanes;
	}

	public void setNoOfEntryLanes(String noOfEntryLanes) {
		this.noOfEntryLanes = noOfEntryLanes;
	}

	public String getNoOfExitLanes() {
		return noOfExitLanes;
	}

	public void setNoOfExitLanes(String noOfExitLanes) {
		this.noOfExitLanes = noOfExitLanes;
	}

	public String getParcsManufacture() {
		return parcsManufacture;
	}

	public void setParcsManufacture(String parcsManufacture) {
		this.parcsManufacture = parcsManufacture;
	}

	public LocalDateTime getDateOfLastMonthlyRateIncrease() {
		return dateOfLastMonthlyRateIncrease;
	}

	public void setDateOfLastMonthlyRateIncrease(
			LocalDateTime dateOfLastMonthlyRateIncrease) {
		this.dateOfLastMonthlyRateIncrease = dateOfLastMonthlyRateIncrease;
	}

	public LocalDateTime getDateOfLastTransientRateIncrease() {
		return dateOfLastTransientRateIncrease;
	}

	public void setDateOfLastTransientRateIncrease(
			LocalDateTime dateOfLastTransientRateIncrease) {
		this.dateOfLastTransientRateIncrease = dateOfLastTransientRateIncrease;
	}

	public String getTypeOfFacility() {
		return typeOfFacility;
	}

	public void setTypeOfFacility(String typeOfFacility) {
		this.typeOfFacility = typeOfFacility;
	}

	public Integer getDueDay() {
		return dueDay;
	}

	public void setDueDay(Integer dueDay) {
		this.dueDay = dueDay;
	}

	public Integer getSettlementDay() {
		return settlementDay;
	}

	public void setSettlementDay(Integer settlementDay) {
		this.settlementDay = settlementDay;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public LocationStatusEnum getDataView() {
		return dataView;
	}

	public void setDataView(LocationStatusEnum dataView) {
		this.dataView = dataView;
	}

	public Boolean getBudget() {
		return budget;
	}

	public void setBudget(Boolean budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "LocationDTO [id=" + id + ", locationID=" + locationID
				+ ", name=" + name + ", clientLegalName=" + clientLegalName
				+ ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", county=" + county + ", state=" + state
				+ ", zipCode=" + zipCode + ", status=" + status + ", phone="
				+ phone + ", cell=" + cell + ", fax=" + fax + ", ext=" + ext
				+ ", companyName=" + companyName + ", executive=" + executive
				+ ", serviceType=" + serviceType + ", contractType="
				+ contractType + ", noofSpaces=" + noofSpaces
				+ ", subsidyType=" + subsidyType + ", parentLocationID="
				+ parentLocationID + ", parentLocationName="
				+ parentLocationName + ", brandCode=" + brandCode
				+ ", applicableForDarma=" + applicableForDarma + ", regionDTO="
				+ regionDTO + ", notesDTO=" + notesDTO + ", tenderTypesLnkDTO="
				+ tenderTypesLnkDTO + ", revenueTypesLnkDTO="
				+ revenueTypesLnkDTO + ", bankAccountsLocationLinkDTO="
				+ bankAccountsLocationLinkDTO + ", burdensDTO=" + burdensDTO
				+ ", rolesAndBillingRatesDTO=" + rolesAndBillingRatesDTO
				+ ", locationContactDTO=" + locationContactDTO
				+ ", burdenInfoDTO=" + burdenInfoDTO + ", exclusionBurdensDTO="
				+ exclusionBurdensDTO + ", locationMoreInfoDTO="
				+ locationMoreInfoDTO + ", darmaUser=" + darmaUser
				+ ", brandDTO=" + brandDTO + ", dataView=" + dataView
				+ ", hoursOfOperation=" + hoursOfOperation
				+ ", noOfGarageLevels=" + noOfGarageLevels
				+ ", noOfEntryLanes=" + noOfEntryLanes + ", noOfExitLanes="
				+ noOfExitLanes + ", parcsManufacture=" + parcsManufacture
				+ ", dateOfLastMonthlyRateIncrease="
				+ dateOfLastMonthlyRateIncrease
				+ ", dateOfLastTransientRateIncrease="
				+ dateOfLastTransientRateIncrease + ", typeOfFacility="
				+ typeOfFacility + ", dueDay=" + dueDay + ", settlementDay="
				+ settlementDay + ", iconName=" + iconName + "]";
	}

}
