package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.Set;

public class ExeSumAndUsrAndLocDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Set<UserDTO> users;
	private Set<UserDTO> externalUsers;
	private LocationDTO location;
	private ExecutiveSummaryDTO executiveSummaryDTO;

	public Set<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public ExecutiveSummaryDTO getExecutiveSummaryDTO() {
		return executiveSummaryDTO;
	}

	public void setExecutiveSummaryDTO(ExecutiveSummaryDTO executiveSummaryDTO) {
		this.executiveSummaryDTO = executiveSummaryDTO;
	}

	public Set<UserDTO> getExternalUsers() {
		return externalUsers;
	}

	public void setExternalUsers(Set<UserDTO> externalUsers) {
		this.externalUsers = externalUsers;
	}

}
