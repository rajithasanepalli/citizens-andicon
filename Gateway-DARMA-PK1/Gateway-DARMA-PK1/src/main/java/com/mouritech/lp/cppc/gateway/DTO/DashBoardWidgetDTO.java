package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class DashBoardWidgetDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String categoryName;
	private String widgetName;
	private String dataJson;
	// private DashBoardDataSourceDTO dashBoardDataSourceDTO;
	private DashBoardDTO dashBoardDTO;
	private StatusEnum status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getWidgetName() {
		return widgetName;
	}

	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}

	public String getDataJson() {
		return dataJson;
	}

	public void setDataJson(String dataJson) {
		this.dataJson = dataJson;
	}

	/*
	 * public DashBoardDataSourceDTO getDashBoardDataSourceDTO() { return
	 * dashBoardDataSourceDTO; } public void setDashBoardDataSourceDTO(
	 * DashBoardDataSourceDTO dashBoardDataSourceDTO) {
	 * this.dashBoardDataSourceDTO = dashBoardDataSourceDTO; }
	 */
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
		return "DashBoardWidgetDTO [id=" + id + ", categoryName="
				+ categoryName + ", widgetName=" + widgetName + ", dataJson="
				+ dataJson + ", dashBoardDTO=" + dashBoardDTO + ", status="
				+ status + "]";
	}

}
