package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.DTO.enums.LocationStatusEnum;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;
import com.mouritech.lp.cppc.gateway.views.View;

public class CpLocationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonView(View.Statement.class)
	private String id;

	@JsonView(View.Statement.class)
	private String locationID;

	@JsonView(View.Statement.class)
	private String name;

	private String clientLegalName;

	@JsonView(View.Statement.class)
	private String address1;
	@JsonView(View.Statement.class)
	private String address2;
	@JsonView(View.Statement.class)
	private String city;
	@JsonView(View.Statement.class)
	private String county;
	@JsonView(View.Statement.class)
	private String state;
	@JsonView(View.Statement.class)
	private String zipCode;

	private StatusEnum status;
	@JsonView(View.Statement.class)
	private String phone;
	@JsonView(View.Statement.class)
	private String cell;
	@JsonView(View.Statement.class)
	private String fax;
	@JsonView(View.Statement.class)
	private String ext;
	@JsonView(View.Statement.class)
	private String companyName;

	private String executive;

	private String serviceType;

	private String contractType;

	private Boolean applicableForDarma;
	@JsonView(View.Statement.class)
	private Integer noofSpaces;

	private String subsidyType;
	private String parentLocationID;
	private String parentLocationName;
	private Set<LocationNotesDTO> notesDTO = new HashSet<LocationNotesDTO>();
	private Set<LocationContactDTO> locationContactDTO = new HashSet<LocationContactDTO>();
	private LocationMoreInfoDTO locationMoreInfoDTO;
	private UserDTO darmaUser;
	private String brandCode;
	private BrandDTO brandDTO;
	@JsonView(View.Statement.class)
	private Set<StatementsDTO> statementsDTO = new HashSet<StatementsDTO>();

	// new columns added
	@JsonView(View.Location.class)
	private LocationStatusEnum dataView;
	@JsonView(View.Statement.class)
	private String hoursOfOperation;

	public LocationStatusEnum getDataView() {
		return dataView;
	}

	public void setDataView(LocationStatusEnum dataView) {
		this.dataView = dataView;
	}

	@JsonView(View.Statement.class)
	private String noOfGarageLevels;
	@JsonView(View.Statement.class)
	private String noOfEntryLanes;
	@JsonView(View.Statement.class)
	private String noOfExitLanes;
	@JsonView(View.Statement.class)
	private String parcsManufacture;
	@JsonView(View.Statement.class)
	private LocalDateTime dateOfLastMonthlyRateIncrease;
	@JsonView(View.Statement.class)
	private LocalDateTime dateOfLastTransientRateIncrease;
	@JsonView(View.Statement.class)
	private String typeOfFacility;
	@JsonView(View.Statement.class)
	private Integer dueDay;
	@JsonView(View.Statement.class)
	private Integer settlementDay;
	@JsonView(View.Statement.class)
	private String iconName;
	@JsonView(View.Statement.class)
	private Boolean budget;
	@JsonView(View.Statement.class)
	private String locationClosedBy;
	
	@JsonView(View.Statement.class)
	private Boolean isFiscalYear;

	@JsonView(View.Statement.class)
	private Integer fyStartMonth;

	public Boolean getApplicableForDarma() {
		return applicableForDarma;
	}

	public void setApplicableForDarma(Boolean applicableForDarma) {
		this.applicableForDarma = applicableForDarma;
	}

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

	public String getClientLegalName() {
		return clientLegalName;
	}

	public void setClientLegalName(String clientLegalName) {
		this.clientLegalName = clientLegalName;
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

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExecutive() {
		return executive;
	}

	public void setExecutive(String executive) {
		this.executive = executive;
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

	public Integer getNoofSpaces() {
		return noofSpaces;
	}

	public void setNoofSpaces(Integer noofSpaces) {
		this.noofSpaces = noofSpaces;
	}

	public String getSubsidyType() {
		return subsidyType;
	}

	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
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

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public Set<StatementsDTO> getStatementsDTO() {
		return statementsDTO;
	}

	public void setStatementsDTO(Set<StatementsDTO> statementsDTO) {
		this.statementsDTO = statementsDTO;
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

	public Boolean getBudget() {
		return budget;
	}

	public void setBudget(Boolean budget) {
		this.budget = budget;
	}

	public String getLocationClosedBy() {
		return locationClosedBy;
	}

	public void setLocationClosedBy(String locationClosedBy) {
		this.locationClosedBy = locationClosedBy;
	}

	public Boolean getIsFiscalYear() {
		return isFiscalYear;
	}

	public void setIsFiscalYear(Boolean isFiscalYear) {
		this.isFiscalYear = isFiscalYear;
	}

	public Integer getFyStartMonth() {
		return fyStartMonth;
	}

	public void setFyStartMonth(Integer fyStartMonth) {
		this.fyStartMonth = fyStartMonth;
	}

}
