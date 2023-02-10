package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.mouritech.lp.cppc.gateway.tallysheet.DTO.GaragesDTO;

/**
 * @author akhileshv
 *
 */
public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 1 PAGE
	private GaragesDTO garagesDTO;// External DTO

	private String monthlyNumber;

	private VehicleMakesDTO vehicleMakesDTO;// External DTO

	private VehicleModelsDTO vehicleModelsDTO;// External DTO

	private Integer registrationYear;

	private String color;

	private String licencePlateNumber;

	private StatesDTO statesDTO;// External DTO

	private String vehicleSerialNumber;

	private TimeParkDTO parkingHours;// External DTO

	private LocalDateTime dateStartedParking;

	private BigDecimal monthlyRate;

	private String garageManager;

	private Integer rfidnumber;

	// 1 PAGE
	private List<AddressDTO> addressDTOs;

	private SendBillToEnum sendBillToEnum;

	private BillingPreferenceEnum billingPreferenceEnum;

	private String garageLocation;

	private Boolean isResident;

	private List<AuthorizedDriversDTO> authorizedDriversDTO;// External DTO

	private String customerSignature;

	private String customerAssignedSpaceSignature;

	private String garageManagerSignature;

	private String typeOfBusinessVehicleOwner;

	private String commRentRegNo;

	private String referenceId;

	private String authCode;

	private String transId;

	private String cardType;

	private String cardNumber;
	
	private String authCode2;

	private String cardType2;

	private String voucherAmount;

	private PaymentStatus paymentStatus;
	
	private ProcessType processType;
	
	private CustomerStatus customerStatus;
	
	private List<ResidentTypesDTO> residentTypesDTO;
	
	//References
	private Integer accountId;
	private Integer tenantId;
	private Integer recurringChargesId;
	private Integer rfidTagId;
	private Integer vehiclesId;
	private String isCRTAvailable;
	private Boolean isEmailGenerated;
	//References
	
	//Audit Columns
	private String createdBy;
	private String lastUpdatedBy;
	
	private Date createdDate;
	private Date lastUpdatedDate;
	//Audit Columns
	
	//Roaster Related Columns
	private String driverName;
	private String size;
	private String type;
	private BigDecimal currentBalance;
	//Roaster Related Columns
	

	//PED FORM
	private PedFormDTO pedFormDTO;
	//PED FORM
	
	
	
	
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public String getVoucherAmount() {
		return voucherAmount;
	}
	public void setVoucherAmount(String voucherAmount) {
		this.voucherAmount = voucherAmount;
	}
	public String getAuthCode2() {
		return authCode2;
	}
	public void setAuthCode2(String authCode2) {
		this.authCode2 = authCode2;
	}
	public String getCardType2() {
		return cardType2;
	}
	public void setCardType2(String cardType2) {
		this.cardType2 = cardType2;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Boolean getIsEmailGenerated() {
		return isEmailGenerated;
	}
	public void setIsEmailGenerated(Boolean isEmailGenerated) {
		this.isEmailGenerated = isEmailGenerated;
	}
	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getIsCRTAvailable() {
		return isCRTAvailable;
	}

	public void setIsCRTAvailable(String isCRTAvailable) {
		this.isCRTAvailable = isCRTAvailable;
	}

	public Integer getVehiclesId() {
		return vehiclesId;
	}

	public void setVehiclesId(Integer vehiclesId) {
		this.vehiclesId = vehiclesId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getRecurringChargesId() {
		return recurringChargesId;
	}

	public void setRecurringChargesId(Integer recurringChargesId) {
		this.recurringChargesId = recurringChargesId;
	}

	public Integer getRfidTagId() {
		return rfidTagId;
	}

	public void setRfidTagId(Integer rfidTagId) {
		this.rfidTagId = rfidTagId;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public ProcessType getProcessType() {
		return processType;
	}

	public void setProcessType(ProcessType processType) {
		this.processType = processType;
	}

	public GaragesDTO getGaragesDTO() {
		return garagesDTO;
	}

	public void setGaragesDTO(GaragesDTO garagesDTO) {
		this.garagesDTO = garagesDTO;
	}

	public String getMonthlyNumber() {
		return monthlyNumber;
	}

	public void setMonthlyNumber(String monthlyNumber) {
		this.monthlyNumber = monthlyNumber;
	}

	public VehicleMakesDTO getVehicleMakesDTO() {
		return vehicleMakesDTO;
	}

	public void setVehicleMakesDTO(VehicleMakesDTO vehicleMakesDTO) {
		this.vehicleMakesDTO = vehicleMakesDTO;
	}

	public VehicleModelsDTO getVehicleModelsDTO() {
		return vehicleModelsDTO;
	}

	public void setVehicleModelsDTO(VehicleModelsDTO vehicleModelsDTO) {
		this.vehicleModelsDTO = vehicleModelsDTO;
	}

	public Integer getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(Integer registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLicencePlateNumber() {
		return licencePlateNumber;
	}

	public void setLicencePlateNumber(String licencePlateNumber) {
		this.licencePlateNumber = licencePlateNumber;
	}

	public StatesDTO getStatesDTO() {
		return statesDTO;
	}

	public void setStatesDTO(StatesDTO statesDTO) {
		this.statesDTO = statesDTO;
	}

	public String getVehicleSerialNumber() {
		return vehicleSerialNumber;
	}

	public void setVehicleSerialNumber(String vehicleSerialNumber) {
		this.vehicleSerialNumber = vehicleSerialNumber;
	}

	public TimeParkDTO getParkingHours() {
		return parkingHours;
	}

	public void setParkingHours(TimeParkDTO parkingHours) {
		this.parkingHours = parkingHours;
	}

	public LocalDateTime getDateStartedParking() {
		return dateStartedParking;
	}

	public void setDateStartedParking(LocalDateTime dateStartedParking) {
		this.dateStartedParking = dateStartedParking;
	}

	public BigDecimal getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(BigDecimal monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public String getGarageManager() {
		return garageManager;
	}

	public void setGarageManager(String garageManager) {
		this.garageManager = garageManager;
	}

	public Integer getRfidnumber() {
		return rfidnumber;
	}

	public void setRfidnumber(Integer rfidnumber) {
		this.rfidnumber = rfidnumber;
	}

	public List<AddressDTO> getAddressDTOs() {
		return addressDTOs;
	}

	public void setAddressDTOs(List<AddressDTO> addressDTOs) {
		this.addressDTOs = addressDTOs;
	}

	public SendBillToEnum getSendBillToEnum() {
		return sendBillToEnum;
	}

	public void setSendBillToEnum(SendBillToEnum sendBillToEnum) {
		this.sendBillToEnum = sendBillToEnum;
	}

	public BillingPreferenceEnum getBillingPreferenceEnum() {
		return billingPreferenceEnum;
	}

	public void setBillingPreferenceEnum(
			BillingPreferenceEnum billingPreferenceEnum) {
		this.billingPreferenceEnum = billingPreferenceEnum;
	}

	public String getGarageLocation() {
		return garageLocation;
	}

	public void setGarageLocation(String garageLocation) {
		this.garageLocation = garageLocation;
	}

	public Boolean getIsResident() {
		return isResident;
	}

	public void setIsResident(Boolean isResident) {
		this.isResident = isResident;
	}

	public List<AuthorizedDriversDTO> getAuthorizedDriversDTO() {
		return authorizedDriversDTO;
	}

	public void setAuthorizedDriversDTO(
			List<AuthorizedDriversDTO> authorizedDriversDTO) {
		this.authorizedDriversDTO = authorizedDriversDTO;
	}

	public String getCustomerSignature() {
		return customerSignature;
	}

	public void setCustomerSignature(String customerSignature) {
		this.customerSignature = customerSignature;
	}

	public String getCustomerAssignedSpaceSignature() {
		return customerAssignedSpaceSignature;
	}

	public void setCustomerAssignedSpaceSignature(
			String customerAssignedSpaceSignature) {
		this.customerAssignedSpaceSignature = customerAssignedSpaceSignature;
	}

	public String getGarageManagerSignature() {
		return garageManagerSignature;
	}

	public void setGarageManagerSignature(String garageManagerSignature) {
		this.garageManagerSignature = garageManagerSignature;
	}

	public String getTypeOfBusinessVehicleOwner() {
		return typeOfBusinessVehicleOwner;
	}

	public void setTypeOfBusinessVehicleOwner(String typeOfBusinessVehicleOwner) {
		this.typeOfBusinessVehicleOwner = typeOfBusinessVehicleOwner;
	}

	public String getCommRentRegNo() {
		return commRentRegNo;
	}

	public void setCommRentRegNo(String commRentRegNo) {
		this.commRentRegNo = commRentRegNo;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public PedFormDTO getPedFormDTO() {
		return pedFormDTO;
	}
	public void setPedFormDTO(PedFormDTO pedFormDTO) {
		this.pedFormDTO = pedFormDTO;
	}
	public List<ResidentTypesDTO> getResidentTypesDTO() {
		return residentTypesDTO;
	}
	public void setResidentTypesDTO(List<ResidentTypesDTO> residentTypesDTO) {
		this.residentTypesDTO = residentTypesDTO;
	}
	


	
}
