package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.tallysheet.DTO.CitiesDTO;
import com.mouritech.lp.cppc.gateway.tallysheet.DTO.ZipCodesDTO;

/**
 * @author akhileshv
 *
 */
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private String businessName;

	private String address;

	private CitiesDTO cityDTO;

	private StatesDTO stateDTO;

	private ZipCodesDTO zipCodeDTO;

	private CountriesDTO countryDTO;

	private String email;

	private String phone;

	private String businessPhone;

	private String mobile;

	private TypeOfAddressEnum typeOfAddressEnum;
	
	private AddressType addressType;

	private String extension;

	
	
	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CitiesDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CitiesDTO cityDTO) {
		this.cityDTO = cityDTO;
	}

	public StatesDTO getStateDTO() {
		return stateDTO;
	}

	public void setStateDTO(StatesDTO stateDTO) {
		this.stateDTO = stateDTO;
	}

	public ZipCodesDTO getZipCodeDTO() {
		return zipCodeDTO;
	}

	public void setZipCodeDTO(ZipCodesDTO zipCodeDTO) {
		this.zipCodeDTO = zipCodeDTO;
	}

	public CountriesDTO getCountryDTO() {
		return countryDTO;
	}

	public void setCountryDTO(CountriesDTO countryDTO) {
		this.countryDTO = countryDTO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public TypeOfAddressEnum getTypeOfAddressEnum() {
		return typeOfAddressEnum;
	}

	public void setTypeOfAddressEnum(TypeOfAddressEnum typeOfAddressEnum) {
		this.typeOfAddressEnum = typeOfAddressEnum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "AddressDTO [firstName=" + firstName + ", lastName=" + lastName
				+ ", businessName=" + businessName + ", address=" + address
				+ ", cityDTO=" + cityDTO + ", stateDTO=" + stateDTO
				+ ", zipCodeDTO=" + zipCodeDTO + ", countryDTO=" + countryDTO
				+ ", email=" + email + ", phone=" + phone + ", businessPhone="
				+ businessPhone + ", mobile=" + mobile + ", typeOfAddressEnum="
				+ typeOfAddressEnum + ", extension=" + extension + "]";
	}

}
