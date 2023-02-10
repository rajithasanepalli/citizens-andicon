package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.util.List;

public class CorrectionsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private String type;
	
	private String adjustMentReason;
	
	private  List<AdjustmentDTO> adjustMents;

	
	
	public String getAdjustMentReason() {
		return adjustMentReason;
	}

	public void setAdjustMentReason(String adjustMentReason) {
		this.adjustMentReason = adjustMentReason;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AdjustmentDTO> getAdjustMents() {
		return adjustMents;
	}

	public void setAdjustMents(List<AdjustmentDTO> adjustMents) {
		this.adjustMents = adjustMents;
	}

	@Override
	public String toString() {
		return "CorrectionsDTO [id=" + id + ", type=" + type + ", adjustMents="
				+ adjustMents + "]";
	}
	
	

	
}
