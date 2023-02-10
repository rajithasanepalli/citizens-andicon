package com.mouritech.lp.cppc.gateway.monthlypayments.DTO;

import java.io.Serializable;

/**
 * @author akhileshv
 *
 */
public class GarageRoasterView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String tenant;

	private String name;

	private String make;

	private String model;

	private String color;

	private Integer rfid;

	private Integer accountCode;

	private Integer garageId;

	public Integer getGarageId() {
		return garageId;
	}

	public void setGarageId(Integer garageId) {
		this.garageId = garageId;
	}

	public Integer getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(Integer accountCode) {
		this.accountCode = accountCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getRfid() {
		return rfid;
	}

	public void setRfid(Integer rfid) {
		this.rfid = rfid;
	}

	@Override
	public String toString() {
		return "GarageRoasterView [tenant=" + tenant + ", name=" + name + ", make=" + make + ", model=" + model
				+ ", color=" + color + ", rfid=" + rfid + "]";
	}

}
