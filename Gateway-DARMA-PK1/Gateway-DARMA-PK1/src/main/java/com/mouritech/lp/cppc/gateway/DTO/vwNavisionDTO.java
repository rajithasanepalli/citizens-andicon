package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.LocalDateTime;


public class vwNavisionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String id;

	private String company;

	private String locationId;
	
	private String location;

	private String GLBaseAccount;

	private String CorE;
	
	private LocalDateTime revenueDate;

	
	private BigDecimal debits;
	
	private BigDecimal credits;
	
	
	private LocalDateTime postingDate;
	
	private LocalDateTime filterPostingDate;
	
	private LocalDateTime postednavisiondate;
	
	private LocalDateTime reconciledDate;
	
	private String BorG;

	private String description;

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	private String depositidentifier;
	
	private String postedBy;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGLBaseAccount() {
		return GLBaseAccount;
	}

	public void setGLBaseAccount(String gLBaseAccount) {
		GLBaseAccount = gLBaseAccount;
	}

	public String getCorE() {
		return CorE;
	}

	public void setCorE(String corE) {
		CorE = corE;
	}

	public LocalDateTime getRevenueDate() {
		return revenueDate;
	}

	public void setRevenueDate(LocalDateTime revenueDate) {
		this.revenueDate = revenueDate;
	}

	public BigDecimal getDebits() {
		return debits;
	}

	public void setDebits(BigDecimal debits) {
		this.debits = debits;
	}

	public BigDecimal getCredits() {
		return credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public LocalDateTime getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(LocalDateTime postingDate) {
		this.postingDate = postingDate;
	}

	public LocalDateTime getFilterPostingDate() {
		return filterPostingDate;
	}

	public void setFilterPostingDate(LocalDateTime filterPostingDate) {
		this.filterPostingDate = filterPostingDate;
	}

	public LocalDateTime getPostednavisiondate() {
		return postednavisiondate;
	}

	public void setPostednavisiondate(LocalDateTime postednavisiondate) {
		this.postednavisiondate = postednavisiondate;
	}

	public LocalDateTime getReconciledDate() {
		return reconciledDate;
	}

	public void setReconciledDate(LocalDateTime reconciledDate) {
		this.reconciledDate = reconciledDate;
	}

	public String getBorG() {
		return BorG;
	}

	public void setBorG(String borG) {
		BorG = borG;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepositidentifier() {
		return depositidentifier;
	}

	public void setDepositidentifier(String depositidentifier) {
		this.depositidentifier = depositidentifier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "vwNavisionDTO [id=" + id + ", company=" + company + ", locationId=" + locationId + ", location="
				+ location + ", GLBaseAccount=" + GLBaseAccount + ", CorE=" + CorE + ", revenueDate=" + revenueDate
				+ ", debits=" + debits + ", credits=" + credits + ", postingDate=" + postingDate
				+ ", filterPostingDate=" + filterPostingDate + ", postednavisiondate=" + postednavisiondate
				+ ", reconciledDate=" + reconciledDate + ", BorG=" + BorG + ", description=" + description
				+ ", depositidentifier=" + depositidentifier + ", postedBy=" + postedBy + "]";
	}

}
