package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ResidentTypesDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;


	private String name;

	private Integer sortKey;
	
	private Boolean defaultFlag;
	
	
	private Boolean showInDelReportFlag;
	
	private Boolean residentCategoryFlag;
	
	private Boolean activeFlag;
	
	//private Set<TenantsDTO>tenantsDTO  = new HashSet<TenantsDTO>();

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSortKey() {
		return sortKey;
	}

	public void setSortKey(Integer sortKey) {
		this.sortKey = sortKey;
	}

	public Boolean getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(Boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public Boolean getShowInDelReportFlag() {
		return showInDelReportFlag;
	}

	public void setShowInDelReportFlag(Boolean showInDelReportFlag) {
		this.showInDelReportFlag = showInDelReportFlag;
	}

	public Boolean getResidentCategoryFlag() {
		return residentCategoryFlag;
	}

	public void setResidentCategoryFlag(Boolean residentCategoryFlag) {
		this.residentCategoryFlag = residentCategoryFlag;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	
	
	
	
	
	

	

}