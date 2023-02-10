package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String address1;

	private String address2;

	private String address3;

	private String city;

	private String zip;

	private String zip4;

	private boolean deleted;

	private String notes;

	private StateDTO state;

	private StatusEnum status;

	private List<ContactDTO> contactDTO = new ArrayList<>();

	public String getId() {
		return id;
	}

	public StateDTO getState() {
		return state;
	}

	public void setState(StateDTO state) {
		this.state = state;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZip4() {
		return zip4;
	}

	public void setZip4(String zip4) {
		this.zip4 = zip4;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<ContactDTO> getContactDTO() {
		return contactDTO;
	}

	public void setContactDTO(List<ContactDTO> contactDTO) {
		this.contactDTO = contactDTO;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
