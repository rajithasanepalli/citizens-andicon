package com.mouritech.lp.cppc.gateway.locationsync.dto;

import java.io.Serializable;
import java.util.List;

public class LocationPCIDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String locationID;

	private List<VendorDTO> listOfVendorDTO;

	private List<PaymentDevicesDTO> listOfPaymentDevices;

	private List<MidDTO> listOfMID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public List<VendorDTO> getListOfVendorDTO() {
		return listOfVendorDTO;
	}

	public void setListOfVendorDTO(List<VendorDTO> listOfVendorDTO) {
		this.listOfVendorDTO = listOfVendorDTO;
	}

	public List<PaymentDevicesDTO> getListOfPaymentDevices() {
		return listOfPaymentDevices;
	}

	public void setListOfPaymentDevices(List<PaymentDevicesDTO> listOfPaymentDevices) {
		this.listOfPaymentDevices = listOfPaymentDevices;
	}

	public List<MidDTO> getListOfMID() {
		return listOfMID;
	}

	public void setListOfMID(List<MidDTO> listOfMID) {
		this.listOfMID = listOfMID;
	}
}
