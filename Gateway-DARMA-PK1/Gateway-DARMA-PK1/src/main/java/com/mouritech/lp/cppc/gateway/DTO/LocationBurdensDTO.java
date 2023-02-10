package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class LocationBurdensDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private Set<BurdensDTO> burdensDTO = new HashSet<BurdensDTO>();
	private Set<ExclusionBurdensDTO> exclusionBurdensDTO = new HashSet<ExclusionBurdensDTO>();

	private BurdenInfoDTO burdenInfoDTO;

	private Set<vwAllocationsDTO> vwAllocationsDTO = new HashSet<vwAllocationsDTO>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<BurdensDTO> getBurdensDTO() {
		return burdensDTO;
	}

	public void setBurdensDTO(Set<BurdensDTO> burdensDTO) {
		this.burdensDTO = burdensDTO;
	}

	public Set<ExclusionBurdensDTO> getExclusionBurdensDTO() {
		return exclusionBurdensDTO;
	}

	public void setExclusionBurdensDTO(
			Set<ExclusionBurdensDTO> exclusionBurdensDTO) {
		this.exclusionBurdensDTO = exclusionBurdensDTO;
	}

	public BurdenInfoDTO getBurdenInfoDTO() {
		return burdenInfoDTO;
	}

	public void setBurdenInfoDTO(BurdenInfoDTO burdenInfoDTO) {
		this.burdenInfoDTO = burdenInfoDTO;
	}

	public Set<vwAllocationsDTO> getVwAllocationsDTO() {
		return vwAllocationsDTO;
	}

	public void setVwAllocationsDTO(Set<vwAllocationsDTO> vwAllocationsDTO) {
		this.vwAllocationsDTO = vwAllocationsDTO;
	}

	@Override
	public String toString() {
		return "LocationBurdensDTO [id=" + id + ", burdensDTO=" + burdensDTO
				+ ", exclusionBurdensDTO=" + exclusionBurdensDTO
				+ ", burdenInfoDTO=" + burdenInfoDTO + ", vwAllocationsDTO="
				+ vwAllocationsDTO + "]";
	}

}
