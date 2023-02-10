package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class DashBoardClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String clientId;

	private String clientName;

	private UserDTO userId;

	private Set<DashBoardDTO> dashBoardDTO = new HashSet<DashBoardDTO>();

	private StatusEnum status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public UserDTO getUserId() {
		return userId;
	}

	public void setUserId(UserDTO userId) {
		this.userId = userId;
	}

	public Set<DashBoardDTO> getDashBoardDTO() {
		return dashBoardDTO;
	}

	public void setDashBoardDTO(Set<DashBoardDTO> dashBoardDTO) {
		this.dashBoardDTO = dashBoardDTO;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DashBoardClientDTO [id=" + id + ", clientId=" + clientId
				+ ", clientName=" + clientName + ", userId=" + userId
				+ ", dashBoardDTO=" + dashBoardDTO + ", status=" + status + "]";
	}

}
