package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

public class vwSourcesForPostingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private BankAccountsDTO bankaccountDTO;

	private LocationDTO locationDTO;

	private TenderTypesDTO tenderTypeDTO;

	private RevenueTypesDTO revenueTypeDTO;

	private LocalDateTime transactionDate;

	private LocalDateTime submitteddate;

	private String amount;

	private LocalDateTime postingDate;

	private LocalDateTime reconciledDate;

	private LocalDateTime exportNavisionDate;

	private String regionid;

	private Character subAccountCode;

	private UserDTO submittedBy;

	private String subTotal;

	private String location;

	private char correctiveYn;

	private String depositIdentifier;
	
	private Boolean markForCorrection;

	public LocalDateTime getReconciledDate() {
		return reconciledDate;
	}

	public void setReconciledDate(LocalDateTime reconciledDate) {
		this.reconciledDate = reconciledDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BankAccountsDTO getBankaccountDTO() {
		return bankaccountDTO;
	}

	public void setBankaccountDTO(BankAccountsDTO bankaccountDTO) {
		this.bankaccountDTO = bankaccountDTO;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public TenderTypesDTO getTenderTypeDTO() {
		return tenderTypeDTO;
	}

	public void setTenderTypeDTO(TenderTypesDTO tenderTypeDTO) {
		this.tenderTypeDTO = tenderTypeDTO;
	}

	public RevenueTypesDTO getRevenueTypeDTO() {
		return revenueTypeDTO;
	}

	public void setRevenueTypeDTO(RevenueTypesDTO revenueTypeDTO) {
		this.revenueTypeDTO = revenueTypeDTO;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalDateTime getSubmitteddate() {
		return submitteddate;
	}

	public void setSubmitteddate(LocalDateTime submitteddate) {
		this.submitteddate = submitteddate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public LocalDateTime getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(LocalDateTime postingDate) {
		this.postingDate = postingDate;
	}

	public String getRegionid() {
		return regionid;
	}

	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}

	public Character getSubAccountCode() {
		return subAccountCode;
	}

	public void setSubAccountCode(Character subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public UserDTO getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(UserDTO submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public char getCorrectiveYn() {
		return correctiveYn;
	}

	public void setCorrectiveYn(char correctiveYn) {
		this.correctiveYn = correctiveYn;
	}

	public String getDepositIdentifier() {
		return depositIdentifier;
	}

	public void setDepositIdentifier(String depositIdentifier) {
		this.depositIdentifier = depositIdentifier;
	}

	public LocalDateTime getExportNavisionDate() {
		return exportNavisionDate;
	}

	public void setExportNavisionDate(LocalDateTime exportNavisionDate) {
		this.exportNavisionDate = exportNavisionDate;
	}

	public Boolean getMarkForCorrection() {
		return markForCorrection;
	}

	public void setMarkForCorrection(Boolean markForCorrection) {
		this.markForCorrection = markForCorrection;
	}

	@Override
	public String toString() {
		return "vwSourcesForPostingDTO [id=" + id + ", bankaccountDTO="
				+ bankaccountDTO + ", locationDTO=" + locationDTO
				+ ", tenderTypeDTO=" + tenderTypeDTO + ", revenueTypeDTO="
				+ revenueTypeDTO + ", transactionDate=" + transactionDate
				+ ", submitteddate=" + submitteddate + ", amount=" + amount
				+ ", postingDate=" + postingDate + ", reconciledDate="
				+ reconciledDate + ", exportNavisionDate=" + exportNavisionDate
				+ ", regionid=" + regionid + ", subAccountCode="
				+ subAccountCode + ", submittedBy=" + submittedBy
				+ ", subTotal=" + subTotal + ", location=" + location
				+ ", correctiveYn=" + correctiveYn + ", depositIdentifier="
				+ depositIdentifier + ", markForCorrection="
				+ markForCorrection + "]";
	}


}
