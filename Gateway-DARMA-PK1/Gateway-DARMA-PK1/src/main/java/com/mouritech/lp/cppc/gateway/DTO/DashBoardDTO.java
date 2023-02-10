package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class DashBoardDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String boardName;

	private String layoutJson;

	private DashBoardCategoryDTO dashboardCategoryDTO;

	/* private DashBoardClientDTO dashBoardClientDTO; */

	/*
	 * private Set<DashBoardWidgetDTO> dashBoardWidgetDTO = new
	 * HashSet<DashBoardWidgetDTO>();
	 */

	private Set<UserDashBoardLinkDTO> userDashBoardLinkDTO= new HashSet<>();;

	private StatusEnum status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getLayoutJson() {
		return layoutJson;
	}

	public void setLayoutJson(String layoutJson) {
		this.layoutJson = layoutJson;
	}

	public DashBoardCategoryDTO getDashboardCategoryDTO() {
		return dashboardCategoryDTO;
	}

	public void setDashboardCategoryDTO(
			DashBoardCategoryDTO dashboardCategoryDTO) {
		this.dashboardCategoryDTO = dashboardCategoryDTO;
	}

	/*
	 * public DashBoardClientDTO getDashBoardClientDTO() { return
	 * dashBoardClientDTO; }
	 * 
	 * public void setDashBoardClientDTO(DashBoardClientDTO dashBoardClientDTO)
	 * { this.dashBoardClientDTO = dashBoardClientDTO; }
	 */
	/*
	 * public Set<DashBoardWidgetDTO> getDashBoardWidgetDTO() { return
	 * dashBoardWidgetDTO; }
	 * 
	 * public void setDashBoardWidgetDTO(Set<DashBoardWidgetDTO>
	 * dashBoardWidgetDTO) { this.dashBoardWidgetDTO = dashBoardWidgetDTO; }
	 */

	public Set<UserDashBoardLinkDTO> getUserDashBoardLinkDTO() {
		return userDashBoardLinkDTO;
	}

	public void setUserDashBoardLinkDTO(
			Set<UserDashBoardLinkDTO> userDashBoardLinkDTO) {
		this.userDashBoardLinkDTO = userDashBoardLinkDTO;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DashBoardDTO [id=" + id + ", boardName=" + boardName
				+ ", layoutJson=" + layoutJson + ", dashboardCategoryDTO="
				+ dashboardCategoryDTO + ", userDashBoardLinkDTO="
				+ userDashBoardLinkDTO + ", status=" + status + "]";
	}

}
