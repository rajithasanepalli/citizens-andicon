package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.DTO.enums.UserType;
import com.mouritech.lp.cppc.gateway.views.View;

public class RoleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonView(View.Role.class)
	private Integer id;

	private String name;

	@JsonView(View.Role.class)
	private String code;

	@JsonView(View.Role.class)
	private UserType usertype;

	@JsonView(View.Role.class)
	private String description;

	private Set<UserDTO> users = new HashSet<>();

	private Set<PermissionDTO> permissionsDTO = new HashSet<PermissionDTO>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer integer) {
		this.id = integer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}

	public Set<PermissionDTO> getPermissionsDTO() {
		return permissionsDTO;
	}

	public void setPermissionsDTO(Set<PermissionDTO> permissionsDTO) {
		this.permissionsDTO = permissionsDTO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", name=" + name + ", code=" + code
				+ ", usertype=" + usertype + ", description=" + description
				+ ", users=" + users + ", permissionsDTO=" + permissionsDTO
				+ "]";
	}

}
