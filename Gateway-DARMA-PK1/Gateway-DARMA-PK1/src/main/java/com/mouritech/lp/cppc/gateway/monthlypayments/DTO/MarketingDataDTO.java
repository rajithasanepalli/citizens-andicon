package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

/**
 * @author akhileshv
 *
 */
public class MarketingDataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	//CUSTOMER DETAILS
	

	private String fistName;

	private String lastName;

	private String middleName;

	private String homeAddress;

	private String apt;

	private String homeCity;

	private String homeState;

	private String homeZip;

	private String homeNumber;

	private String businessName;

	private String businessAddress;

	private String businessCity;

	private String businessState;

	private String businessZip;

	private String businessPhone;
	
	//CUSTOMER DETAILS

	//Authorized Drivers
	private String additional1;

	private String additionalLast1;
	
	private String additional2;
	
	private String additionalLast2;

	private String additional3;
	
	private String additionalLast3;
	//Authorized Drivers
	
	//VEHICLES
	private String plate;

	private String plateState;

	private String years;

	private String make;

	private String model;

	private String color;

	private String vin;
	//VEHICLES
	
	private String startDate;
	
	private String datePaid;

	private String locationName;

	private String cardtype;
	
	private String authCode;
	
	private String garageCode;
	
	private String email;
	
	private String sendBillTo;

	private String billingPreference;

	private String parkingHours;

	private String buildingResident;
	
	private String promoCode;
	
	private String parkNLock;
	

	//Reccurring Charges

	private String rate;
	
	private String taxRate;

	private String totalPaid;
	
	private String oversize;
	
	private String invoiceNum;

	private String parkingTax;
	
	private String totalRate;
	
	private String validUntil;

	private String netAmountSub;
	
	private String netAmount;

	private String grandTotal;

	//Reccurring Charges

	


	private String bestParking;

	private String dont_Invoice;

	private String increaseDate;

	private String increaseAmount;

	private String increaseComment;

	private String source;
	
	private String counter;

	private String sales2;

	private String accessStartDate;
	
	private String accessIncreaseDate;

	private String tenant_ID;

	private String importDate;

	private String voucherType;

	private String voucherNumber;

	private String voucherAmount;
	
	
	
	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public String getVoucherAmount() {
		return voucherAmount;
	}

	public void setVoucherAmount(String voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public String getAccessIncreaseDate() {
		return accessIncreaseDate;
	}

	public void setAccessIncreaseDate(String accessIncreaseDate) {
		this.accessIncreaseDate = accessIncreaseDate;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public String getHomeZip() {
		return homeZip;
	}

	public void setHomeZip(String homeZip) {
		this.homeZip = homeZip;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getBusinessCity() {
		return businessCity;
	}

	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}

	public String getBusinessState() {
		return businessState;
	}

	public void setBusinessState(String businessState) {
		this.businessState = businessState;
	}

	public String getBusinessZip() {
		return businessZip;
	}

	public void setBusinessZip(String businessZip) {
		this.businessZip = businessZip;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getAdditional1() {
		return additional1;
	}

	public void setAdditional1(String additional1) {
		this.additional1 = additional1;
	}

	public String getAdditionalLast1() {
		return additionalLast1;
	}

	public void setAdditionalLast1(String additionalLast1) {
		this.additionalLast1 = additionalLast1;
	}

	public String getAdditional2() {
		return additional2;
	}

	public void setAdditional2(String additional2) {
		this.additional2 = additional2;
	}

	public String getAdditionalLast2() {
		return additionalLast2;
	}

	public void setAdditionalLast2(String additionalLast2) {
		this.additionalLast2 = additionalLast2;
	}

	public String getAdditional3() {
		return additional3;
	}

	public void setAdditional3(String additional3) {
		this.additional3 = additional3;
	}

	public String getAdditionalLast3() {
		return additionalLast3;
	}

	public void setAdditionalLast3(String additionalLast3) {
		this.additionalLast3 = additionalLast3;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getPlateState() {
		return plateState;
	}

	public void setPlateState(String plateState) {
		this.plateState = plateState;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(String datePaid) {
		this.datePaid = datePaid;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	

	public String getGarageCode() {
		return garageCode;
	}

	public void setGarageCode(String garageCode) {
		this.garageCode = garageCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSendBillTo() {
		return sendBillTo;
	}

	public void setSendBillTo(String sendBillTo) {
		this.sendBillTo = sendBillTo;
	}

	public String getBillingPreference() {
		return billingPreference;
	}

	public void setBillingPreference(String billingPreference) {
		this.billingPreference = billingPreference;
	}

	public String getParkingHours() {
		return parkingHours;
	}

	public void setParkingHours(String parkingHours) {
		this.parkingHours = parkingHours;
	}

	public String getBuildingResident() {
		return buildingResident;
	}

	public void setBuildingResident(String buildingResident) {
		this.buildingResident = buildingResident;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getParkNLock() {
		return parkNLock;
	}

	public void setParkNLock(String parkNLock) {
		this.parkNLock = parkNLock;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	public String getOversize() {
		return oversize;
	}

	public void setOversize(String oversize) {
		this.oversize = oversize;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public String getParkingTax() {
		return parkingTax;
	}

	public void setParkingTax(String parkingTax) {
		this.parkingTax = parkingTax;
	}

	public String getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(String totalRate) {
		this.totalRate = totalRate;
	}

	public String getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(String validUntil) {
		this.validUntil = validUntil;
	}

	public String getNetAmountSub() {
		return netAmountSub;
	}

	public void setNetAmountSub(String netAmountSub) {
		this.netAmountSub = netAmountSub;
	}

	public String getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getBestParking() {
		return bestParking;
	}

	public void setBestParking(String bestParking) {
		this.bestParking = bestParking;
	}

	public String getDont_Invoice() {
		return dont_Invoice;
	}

	public void setDont_Invoice(String dont_Invoice) {
		this.dont_Invoice = dont_Invoice;
	}

	public String getIncreaseDate() {
		return increaseDate;
	}

	public void setIncreaseDate(String increaseDate) {
		this.increaseDate = increaseDate;
	}

	public String getIncreaseAmount() {
		return increaseAmount;
	}

	public void setIncreaseAmount(String increaseAmount) {
		this.increaseAmount = increaseAmount;
	}

	public String getIncreaseComment() {
		return increaseComment;
	}

	public void setIncreaseComment(String increaseComment) {
		this.increaseComment = increaseComment;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public String getSales2() {
		return sales2;
	}

	public void setSales2(String sales2) {
		this.sales2 = sales2;
	}

	public String getAccessStartDate() {
		return accessStartDate;
	}

	public void setAccessStartDate(String accessStartDate) {
		this.accessStartDate = accessStartDate;
	}

	public String getTenant_ID() {
		return tenant_ID;
	}

	public void setTenant_ID(String tenant_ID) {
		this.tenant_ID = tenant_ID;
	}

	public String getImportDate() {
		return importDate;
	}

	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}

	@Override
	public String toString() {
		return "MarketingDataDTO [fistName=" + fistName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", homeAddress=" + homeAddress + ", apt=" + apt + ", homeCity=" + homeCity + ", homeState="
				+ homeState + ", homeZip=" + homeZip + ", homeNumber=" + homeNumber + ", businessName=" + businessName
				+ ", businessAddress=" + businessAddress + ", businessCity=" + businessCity + ", businessState="
				+ businessState + ", businessZip=" + businessZip + ", businessPhone=" + businessPhone + ", additional1="
				+ additional1 + ", additionalLast1=" + additionalLast1 + ", additional2=" + additional2
				+ ", additionalLast2=" + additionalLast2 + ", additional3=" + additional3 + ", additionalLast3="
				+ additionalLast3 + ", plate=" + plate + ", plateState=" + plateState + ", years=" + years + ", make="
				+ make + ", model=" + model + ", color=" + color + ", vin=" + vin + ", startDate=" + startDate
				+ ", datePaid=" + datePaid + ", locationName=" + locationName + ", cardtype=" + cardtype + ", authCode="
				+ authCode + ", gargageCode=" + garageCode + ", email=" + email + ", sendBillTo=" + sendBillTo
				+ ", billingPreference=" + billingPreference + ", parkingHours=" + parkingHours + ", buildingResident="
				+ buildingResident + ", promoCode=" + promoCode + ", parkNLock=" + parkNLock + ", rate=" + rate
				+ ", taxRate=" + taxRate + ", totalPaid=" + totalPaid + ", oversize=" + oversize + ", invoiceNum="
				+ invoiceNum + ", parkingTax=" + parkingTax + ", totalRate=" + totalRate + ", validUntil=" + validUntil
				+ ", netAmountSub=" + netAmountSub + ", netAmount=" + netAmount + ", grandTotal=" + grandTotal
				+ ", bestParking=" + bestParking + ", dont_Invoice=" + dont_Invoice + ", increaseDate=" + increaseDate
				+ ", increaseAmount=" + increaseAmount + ", increaseComment=" + increaseComment + ", source=" + source
				+ ", counter=" + counter + ", sales2=" + sales2 + ", accessStartDate=" + accessStartDate
				+ ", tenant_ID=" + tenant_ID + ", importDate=" + importDate + "]";
	}


	

	
	
	
	
}