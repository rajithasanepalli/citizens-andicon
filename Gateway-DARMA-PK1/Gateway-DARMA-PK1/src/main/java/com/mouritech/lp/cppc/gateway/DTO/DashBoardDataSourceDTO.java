package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class DashBoardDataSourceDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String sourceName;
	private String sourceType;
	private String config;
	private DashBoardWidgetDTO dashBoardWidgetDTO;
	private StatusEnum status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public DashBoardWidgetDTO getDashBoardWidgetDTO() {
		return dashBoardWidgetDTO;
	}

	public void setDashBoardWidgetDTO(DashBoardWidgetDTO dashBoardWidgetDTO) {
		this.dashBoardWidgetDTO = dashBoardWidgetDTO;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DashBoardDataSourceDTO [id=" + id + ", sourceName="
				+ sourceName + ", sourceType=" + sourceType + ", config="
				+ config + ", dashBoardWidgetDTO=" + dashBoardWidgetDTO
				+ ", status=" + status + "]";
	}

}
