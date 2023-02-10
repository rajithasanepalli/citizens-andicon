package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.DTO.BrandDTO;
import com.mouritech.lp.cppc.gateway.DTO.RoleDTO;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;
import com.mouritech.lp.cppc.gateway.DTO.enums.UserType;
import com.mouritech.lp.cppc.gateway.views.View;

public class iParkUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonView(View.User.class)
	private String id;

	@JsonView(View.User.class)
	private String firstName;

	@JsonView(View.User.class)
	private String lastName;

	@JsonView(View.User.class)
	private String emailAddress;

	@JsonView(View.User.class)
	private String userName;

	@JsonView(View.User.class)
	private String phone;

	@JsonView(View.User.class)
	private StatusEnum status;

	@JsonView(View.User.class)
	private UserType usertype;

	@JsonView(View.User.class)
	private Set<RoleDTO> rolesDTO = new HashSet<>();

	private BrandDTO brandDTO;

	@JsonView(View.User.class)
	private String brandCode;

	@JsonView(View.User.class)
	private String displayName;

	@JsonView(View.User.class)
	private Boolean isAdministrator;
	
	@JsonView(View.User.class)
	private Boolean canCloseTheMonth;

	@JsonView(View.User.class)
	private Boolean isApplicableForMonthly;
	
	
	public Boolean getIsApplicableForMonthly() {
		return isApplicableForMonthly;
	}

	public void setIsApplicableForMonthly(Boolean isApplicableForMonthly) {
		this.isApplicableForMonthly = isApplicableForMonthly;
	}
	
	public Boolean getCanCloseTheMonth() {
		return canCloseTheMonth;
	}

	public void setCanCloseTheMonth(Boolean canCloseTheMonth) {
		this.canCloseTheMonth = canCloseTheMonth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public Set<RoleDTO> getRolesDTO() {
		return rolesDTO;
	}

	public void setRolesDTO(Set<RoleDTO> rolesDTO) {
		this.rolesDTO = rolesDTO;
	}

	public BrandDTO getBrandDTO() {
		return brandDTO;
	}

	public void setBrandDTO(BrandDTO brandDTO) {
		this.brandDTO = brandDTO;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Boolean getAdministrator() {
		return isAdministrator;
	}

	public void setAdministrator(Boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	@Override
	public String toString() {
		return "iParkUserDTO [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", userName=" + userName + ", phone=" + phone + ", status="
				+ status + ", usertype=" + usertype + ", rolesDTO=" + rolesDTO
				+ ", brandDTO=" + brandDTO + ", brandCode=" + brandCode
				+ ", displayName=" + displayName + ", isAdministrator="
				+ isAdministrator + "]";
	}

	

}
