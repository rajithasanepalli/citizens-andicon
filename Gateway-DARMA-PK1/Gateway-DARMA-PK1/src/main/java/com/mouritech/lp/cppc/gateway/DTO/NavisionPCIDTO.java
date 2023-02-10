package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.LocalDate;

/**
 * A DTO for the NavisionPCI entity.
 */
public class NavisionPCIDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -10344755501304060L;

	private String location_id;

	private String company;

	private String location;

	private String glBaseAccount;

	private String cOrE;

	private String revenueDate;

	private String bOrG;

	private String description;

	private BigDecimal debits;

	private BigDecimal credits;

	private String postingDate;

	private String reconciledDate;

	private String depositIdentifier;

	private String filterPostingDate;

	private LocalDate postedNavisionDate;

	private String comment;

	private Integer sortBy;

	private LocalDate exportNavisionDate;

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGlBaseAccount() {
		return glBaseAccount;
	}

	public void setGlBaseAccount(String glBaseAccount) {
		this.glBaseAccount = glBaseAccount;
	}

	public String getcOrE() {
		return cOrE;
	}

	public void setcOrE(String cOrE) {
		this.cOrE = cOrE;
	}

	public String getRevenueDate() {
		return revenueDate;
	}

	public void setRevenueDate(String revenueDate) {
		this.revenueDate = revenueDate;
	}

	public String getbOrG() {
		return bOrG;
	}

	public void setbOrG(String bOrG) {
		this.bOrG = bOrG;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getReconciledDate() {
		return reconciledDate;
	}

	public void setReconciledDate(String reconciledDate) {
		this.reconciledDate = reconciledDate;
	}

	public String getDepositIdentifier() {
		return depositIdentifier;
	}

	public void setDepositIdentifier(String depositIdentifier) {
		this.depositIdentifier = depositIdentifier;
	}

	public String getFilterPostingDate() {
		return filterPostingDate;
	}

	public void setFilterPostingDate(String filterPostingDate) {
		this.filterPostingDate = filterPostingDate;
	}

	public LocalDate getPostedNavisionDate() {
		return postedNavisionDate;
	}

	public void setPostedNavisionDate(LocalDate postedNavisionDate) {
		this.postedNavisionDate = postedNavisionDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getSortBy() {
		return sortBy;
	}

	public void setSortBy(Integer sortBy) {
		this.sortBy = sortBy;
	}

	public LocalDate getExportNavisionDate() {
		return exportNavisionDate;
	}

	public void setExportNavisionDate(LocalDate exportNavisionDate) {
		this.exportNavisionDate = exportNavisionDate;
	}

	@Override
	public String toString() {
		return "NavisionPCIDTO [location_id=" + location_id + ", company="
				+ company + ", location=" + location + ", glBaseAccount="
				+ glBaseAccount + ", cOrE=" + cOrE + ", revenueDate="
				+ revenueDate + ", bOrG=" + bOrG + ", description="
				+ description + ", debits=" + debits + ", credits=" + credits
				+ ", postingDate=" + postingDate + ", reconciledDate="
				+ reconciledDate + ", depositIdentifier=" + depositIdentifier
				+ ", filterPostingDate=" + filterPostingDate
				+ ", postedNavisionDate=" + postedNavisionDate + ", comment="
				+ comment + ", sortBy=" + sortBy + ", exportNavisionDate="
				+ exportNavisionDate + "]";
	}

}
