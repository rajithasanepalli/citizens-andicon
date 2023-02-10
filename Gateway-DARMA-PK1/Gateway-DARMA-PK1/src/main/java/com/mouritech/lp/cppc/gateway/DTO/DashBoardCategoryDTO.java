package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class DashBoardCategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String categoryName;

	private StatusEnum status;

	// private UserDTO userId;

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

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DashBoardCategoryDTO [id=" + id + ", categoryName="
				+ categoryName + ", status=" + status + "]";
	}

}
