package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillingExtractFileDTO implements Serializable {

	private static final long serialVersionUID = 1124869316564110072L;

	private String id;

	private String payPeriod;
	
	private String payGroup;
	
	private String brand;
	
	private Date fileTimestamp;
	
	private String inboundFileName;
	
	private String outboundFileName;
	
	private char isProcessed;
	
	private String execption;

	private List<BillingExtractDTO> billingExtracts = new ArrayList<>();
	
	private List<BillingExtractFileNotesDTO> notes = new ArrayList<>();
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}

	public String getPayGroup() {
		return payGroup;
	}

	public void setPayGroup(String payGroup) {
		this.payGroup = payGroup;
	}

	public String getInboundFileName() {
		return inboundFileName;
	}

	public void setInboundFileName(String inboundFileName) {
		this.inboundFileName = inboundFileName;
	}

	public String getOutboundFileName() {
		return outboundFileName;
	}

	public void setOutboundFileName(String outboundFileName) {
		this.outboundFileName = outboundFileName;
	}

	public char getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(char isProcessed) {
		this.isProcessed = isProcessed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getFileTimestamp() {
		return fileTimestamp;
	}

	public void setFileTimestamp(Date fileTimestamp) {
		this.fileTimestamp = fileTimestamp;
	}

	public List<BillingExtractDTO> getBilling() {
		return billingExtracts;
	}

	public void setBillingExtracts(List<BillingExtractDTO> billingExtracts) {
		this.billingExtracts = billingExtracts;
	}

	
	public String getExecption() {
		return execption;
	}

	public void setExecption(String execption) {
		this.execption = execption;
	}

	public List<BillingExtractFileNotesDTO> getNotes() {
		return notes;
	}

	public void setNotes(List<BillingExtractFileNotesDTO> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "BillingExtractFileDTO [id=" + id + ", payPeriod=" + payPeriod + ", payGroup=" + payGroup + ", brand=" + brand
				+ ", fileTimestamp=" + fileTimestamp + ", inboundFileName=" + inboundFileName + ", outboundFileName="
				+ outboundFileName + ", isProcessed=" + isProcessed + "]";
	}

}
