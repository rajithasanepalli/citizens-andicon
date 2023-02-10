package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class RevenueDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private LocationDTO locationDTO;

	private BankAccountsDTO bankAccountsDTO;

	private UserDTO postedBy;

	private LocalDateTime postingDate;

	private StatusEnum status;

	private LocalDateTime revenueDate;

	private BigDecimal amount;

	private Integer numberOfDeposits;

	private UserDTO submittedBy;

	private LocalDateTime submittedDate;

	private LocalDateTime reconciledDate;

	private String depositIdentifier;

	private TenderTypesDTO tenderTypesDTO;

	private List<RevenueNotesDTO> notesDTO = new ArrayList<>(0);

	private List<SourceDTO> sourcesDTO = new ArrayList<>(0);

	private Boolean markForCorrection;

	private BigDecimal bankAmount;

	private StatusEnum verificationStatus;

	private LocalDateTime markForCorrectionDate;

	private LocalDateTime exportNavisionDate;

	private UserDTO exportNavisionBy;
	
	private Integer corrInc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public LocalDateTime getRevenueDate() {
		return revenueDate;
	}

	public void setRevenueDate(LocalDateTime revenueDate) {
		this.revenueDate = revenueDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public UserDTO getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(UserDTO postedBy) {
		this.postedBy = postedBy;
	}

	public LocalDateTime getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(LocalDateTime postingDate) {
		this.postingDate = postingDate;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getNumberOfDeposits() {
		return numberOfDeposits;
	}

	public void setNumberOfDeposits(Integer numberOfDeposits) {
		this.numberOfDeposits = numberOfDeposits;
	}

	public UserDTO getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(UserDTO submittedBy) {
		this.submittedBy = submittedBy;
	}

	public LocalDateTime getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(LocalDateTime submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getDepositIdentifier() {
		return depositIdentifier;
	}

	public void setDepositIdentifier(String depositIdentifier) {
		this.depositIdentifier = depositIdentifier;
	}

	public TenderTypesDTO getTenderTypesDTO() {
		return tenderTypesDTO;
	}

	public void setTenderTypesDTO(TenderTypesDTO tenderTypesDTO) {
		this.tenderTypesDTO = tenderTypesDTO;
	}

	public List<RevenueNotesDTO> getNotesDTO() {
		return notesDTO;
	}

	public void setNotesDTO(List<RevenueNotesDTO> notesDTO) {
		this.notesDTO = notesDTO;
	}

	public List<SourceDTO> getSourcesDTO() {
		return sourcesDTO;
	}

	public void setSourcesDTO(List<SourceDTO> sourcesDTO) {
		this.sourcesDTO = sourcesDTO;
	}

	public BankAccountsDTO getBankAccountsDTO() {
		return bankAccountsDTO;
	}

	public void setBankAccountsDTO(BankAccountsDTO bankAccountsDTO) {
		this.bankAccountsDTO = bankAccountsDTO;
	}

	public LocalDateTime getReconciledDate() {
		return reconciledDate;
	}

	public void setReconciledDate(LocalDateTime reconciledDate) {
		this.reconciledDate = reconciledDate;
	}

	public Boolean getMarkForCorrection() {
		return markForCorrection;
	}

	public void setMarkForCorrection(Boolean markForCorrection) {
		this.markForCorrection = markForCorrection;
	}

	public BigDecimal getBankAmount() {
		return bankAmount;
	}

	public void setBankAmount(BigDecimal bankAmount) {
		this.bankAmount = bankAmount;
	}

	public StatusEnum getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(StatusEnum verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public LocalDateTime getMarkForCorrectionDate() {
		return markForCorrectionDate;
	}

	public void setMarkForCorrectionDate(LocalDateTime markForCorrectionDate) {
		this.markForCorrectionDate = markForCorrectionDate;
	}

	public LocalDateTime getExportNavisionDate() {
		return exportNavisionDate;
	}

	public void setExportNavisionDate(LocalDateTime exportNavisionDate) {
		this.exportNavisionDate = exportNavisionDate;
	}

	public UserDTO getExportNavisionBy() {
		return exportNavisionBy;
	}

	public void setExportNavisionBy(UserDTO exportNavisionBy) {
		this.exportNavisionBy = exportNavisionBy;
	}

	public Integer getCorrInc() {
		return corrInc;
	}

	public void setCorrInc(Integer corrInc) {
		this.corrInc = corrInc;
	}

	@Override
	public String toString() {
		return "RevenueDTO [id=" + id + ", locationDTO=" + locationDTO
				+ ", bankAccountsDTO=" + bankAccountsDTO + ", postedBy="
				+ postedBy + ", postingDate=" + postingDate + ", status="
				+ status + ", revenueDate=" + revenueDate + ", amount="
				+ amount + ", numberOfDeposits=" + numberOfDeposits
				+ ", submittedBy=" + submittedBy + ", submittedDate="
				+ submittedDate + ", reconciledDate=" + reconciledDate
				+ ", depositIdentifier=" + depositIdentifier
				+ ", tenderTypesDTO=" + tenderTypesDTO + ", notesDTO="
				+ notesDTO + ", sourcesDTO=" + sourcesDTO
				+ ", markForCorrection=" + markForCorrection + ", bankAmount="
				+ bankAmount + ", verificationStatus=" + verificationStatus
				+ ", markForCorrectionDate=" + markForCorrectionDate
				+ ", exportNavisionDate=" + exportNavisionDate
				+ ", exportNavisionBy=" + exportNavisionBy + ", corrInc="
				+ corrInc + "]";
	}

	
}
