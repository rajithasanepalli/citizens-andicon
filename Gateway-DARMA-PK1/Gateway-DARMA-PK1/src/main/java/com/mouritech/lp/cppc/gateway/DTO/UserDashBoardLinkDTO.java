package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;



public class UserDashBoardLinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private UserDTO userDTO;
	private DashBoardDTO dashBoardDTO;
	private StatusEnum status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public DashBoardDTO getDashBoardDTO() {
		return dashBoardDTO;
	}
	public void setDashBoardDTO(DashBoardDTO dashBoardDTO) {
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
		return "UserDashBoardLinkDTO [id=" + id + ", userDTO=" + userDTO
				+ ", dashBoardDTO=" + dashBoardDTO + ", status=" + status + "]";
	}
	
	
	
}
