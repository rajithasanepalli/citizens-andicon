package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;
import com.mouritech.lp.cppc.gateway.DTO.enums.UserType;
import com.mouritech.lp.cppc.gateway.views.View;

public class UserDTO implements Serializable {

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

	private Set<UserLocationLinkDTO> usersLocationLinkDTO = new HashSet<>();

	private BrandDTO brandDTO;

	@JsonView(View.User.class)
	private String brandCode;

	@JsonView(View.User.class)
	private String displayName;
	@JsonView(View.User.class)
	private String designation;
	@JsonView(View.User.class)
	private String title;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public Set<UserLocationLinkDTO> getUsersLocationLinkDTO() {
		return usersLocationLinkDTO;
	}

	public void setUsersLocationLinkDTO(
			Set<UserLocationLinkDTO> usersLocationLinkDTO) {
		this.usersLocationLinkDTO = usersLocationLinkDTO;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/*
	 * public UserDesignationEnum getDesignation() { return designation; }
	 * 
	 * public void setDesignation(UserDesignationEnum designation) {
	 * this.designation = designation; }
	 */

	public String getTitle() {
		return title;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailAddress=" + emailAddress + ", userName="
				+ userName + ", phone=" + phone + ", status=" + status
				+ ", usertype=" + usertype + ", rolesDTO=" + rolesDTO
				+ ", usersLocationLinkDTO=" + usersLocationLinkDTO
				+ ", brandDTO=" + brandDTO + ", brandCode=" + brandCode
				+ ", displayName=" + displayName + ", designation="
				+ designation + ", title=" + title + "]";
	}

}
