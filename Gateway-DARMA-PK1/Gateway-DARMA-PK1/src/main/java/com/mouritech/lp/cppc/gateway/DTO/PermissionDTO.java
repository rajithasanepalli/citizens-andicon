package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



public class PermissionDTO implements Serializable{

	private static final long serialVersionUID = 1L;


	private Integer id;


	private String name;


	private Set<RoleDTO> roles = new HashSet<RoleDTO>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<RoleDTO> getRoles() {
		return roles;
	}


	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "PermissionDTO [id=" + id + ", name=" + name + ", roles="
				+ roles + "]";
	}
	
	

}
