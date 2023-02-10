package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.List;

public class CombineDepositsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String parentDI;

	private List<String> childDIs;

	public String getParentDI() {
		return parentDI;
	}

	public void setParentDI(String parentDI) {
		this.parentDI = parentDI;
	}

	public List<String> getChildDIs() {
		return childDIs;
	}

	public void setChildDIs(List<String> childDIs) {
		this.childDIs = childDIs;
	}

	@Override
	public String toString() {
		return "CombineDepositIdentifiersDTO [parentDI=" + parentDI
				+ ", childDIs=" + childDIs + "]";
	}
	

}
