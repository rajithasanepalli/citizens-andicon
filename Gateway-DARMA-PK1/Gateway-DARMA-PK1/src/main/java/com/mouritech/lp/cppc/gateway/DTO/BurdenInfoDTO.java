package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class BurdenInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private Boolean exclusion;

	private Boolean useActuals;
	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getExclusion() {
		return exclusion;
	}

	public void setExclusion(Boolean exclusion) {
		this.exclusion = exclusion;
	}

	public Boolean getUseActuals() {
		return useActuals;
	}

	public void setUseActuals(Boolean useActuals) {
		this.useActuals = useActuals;
	}

	@Override
	public String toString() {
		return "BurdenInfoDTO [id=" + id + ", exclusion=" + exclusion
				+ ", useActuals=" + useActuals + ", status=" + status + "]";
	}

}
