package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.views.TallySheetView;

public class TimeParkDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(TallySheetView.DropdownGarages.class)
	private Integer ID;
	@JsonView(TallySheetView.DropdownGarages.class)
	private String Name;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "TimeParkDTO [ID=" + ID + ", Name=" + Name + "]";
	}

	
	
}