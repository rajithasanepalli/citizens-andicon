package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;


public class PedDamageMarkDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String position;
	
	private String damageMark;
	
	private PedFormDTO pedForm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDamageMark() {
		return damageMark;
	}

	public void setDamageMark(String damageMark) {
		this.damageMark = damageMark;
	}

	public PedFormDTO getPedForm() {
		return pedForm;
	}

	public void setPedForm(PedFormDTO pedForm) {
		this.pedForm = pedForm;
	}
	
	



	
	
	
}