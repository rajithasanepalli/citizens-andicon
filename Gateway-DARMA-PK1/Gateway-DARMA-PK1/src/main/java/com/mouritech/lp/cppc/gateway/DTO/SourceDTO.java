package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import org.joda.time.LocalDateTime;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class SourceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private BankAccountsDTO bankAccountsDTO;

	private LocationDTO locationDTO;

	private RevenueTypesDTO revenueTypesDTO;

	private StatusEnum status;

	private TenderTypesDTO tenderTypesDTO;

	private UserDTO submittedBy;

	private UserDTO postedBy;

	private LocalDateTime transactionDate;

	private BigDecimal amount;

	private LocalDateTime reconciledDate;

	private LocalDateTime postingDate;

	private Character subAccountCode;

	private char deferredYn;

	private Short deferredMonth1;

	private Short deferredYear1;

	private BigDecimal deferredAmount1;

	private Short deferredMonth2;

	private Short deferredYear2;

	private BigDecimal deferredAmount2;

	private Short deferredMonth3;

	private Short deferredYear3;

	private BigDecimal deferredAmount3;

	private Short deferredMonth4;

	private Short deferredYear4;

	private BigDecimal deferredAmount4;

	private Short deferredMonth5;

	private Short deferredYear5;

	private BigDecimal deferredAmount5;

	private Short deferredMonth6;

	private Short deferredYear6;

	private BigDecimal deferredAmount6;

	private Short deferredMonth7;

	private Short deferredYear7;

	private BigDecimal deferredAmount7;

	private Short deferredMonth8;

	private Short deferredYear8;

	private BigDecimal deferredAmount8;

	private Short deferredMonth9;

	private Short deferredYear9;

	private BigDecimal deferredAmount9;

	private Short deferredMonth10;

	private Short deferredYear10;

	private BigDecimal deferredAmount10;

	private Short deferredMonth11;

	private Short deferredYear11;

	private BigDecimal deferredAmount11;

	private Short deferredMonth12;

	private Short deferredYear12;

	private BigDecimal deferredAmount12;

	private String depositIdentifier;

	private char correctiveYn;

	private String correctiveDescr;

	private LocalDateTime postedNavisionDate;

	private LocalDateTime exportNavisionDate;

	private Boolean pci;

	private LocalDateTime submittedDate;

	private Set<SourceNotesDTO> sourceNotesDTO = new HashSet<>(0);

	private RevenueDTO revenueDTO;

	private UserDTO exportNavisionBy;

	private BigDecimal bankAmount;// THIS IS ONLY FOR RECONCILE PURPOSE SHOULDN,T USE ANY WHERE...

	private String dueToLocation;
	private String payor;
	private String dueToLocAmount;
	private String checkNumber;

	public BigDecimal getBankAmount() {
		return bankAmount;
	}

	public void setBankAmount(BigDecimal bankAmount) {
		this.bankAmount = bankAmount;
	}

	public RevenueDTO getRevenueDTO() {
		return revenueDTO;
	}

	public void setRevenueDTO(RevenueDTO revenueDTO) {
		this.revenueDTO = revenueDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BankAccountsDTO getBankAccountsDTO() {
		return bankAccountsDTO;
	}

	public void setBankAccountsDTO(BankAccountsDTO bankAccountsDTO) {
		this.bankAccountsDTO = bankAccountsDTO;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public UserDTO getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(UserDTO submittedBy) {
		this.submittedBy = submittedBy;
	}

	public UserDTO getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(UserDTO postedBy) {
		this.postedBy = postedBy;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public RevenueTypesDTO getRevenueTypesDTO() {
		return revenueTypesDTO;
	}

	public void setRevenueTypesDTO(RevenueTypesDTO revenueTypesDTO) {
		this.revenueTypesDTO = revenueTypesDTO;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public TenderTypesDTO getTenderTypesDTO() {
		return tenderTypesDTO;
	}

	public void setTenderTypesDTO(TenderTypesDTO tenderTypesDTO) {
		this.tenderTypesDTO = tenderTypesDTO;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getReconciledDate() {
		return reconciledDate;
	}

	public void setReconciledDate(LocalDateTime reconciledDate) {
		this.reconciledDate = reconciledDate;
	}

	public LocalDateTime getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(LocalDateTime postingDate) {
		this.postingDate = postingDate;
	}

	public Character getSubAccountCode() {
		return subAccountCode;
	}

	public void setSubAccountCode(Character subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public char getDeferredYn() {
		return deferredYn;
	}

	public void setDeferredYn(char deferredYn) {
		this.deferredYn = deferredYn;
	}

	public Short getDeferredMonth1() {
		return deferredMonth1;
	}

	public void setDeferredMonth1(Short deferredMonth1) {
		this.deferredMonth1 = deferredMonth1;
	}

	public Short getDeferredYear1() {
		return deferredYear1;
	}

	public void setDeferredYear1(Short deferredYear1) {
		this.deferredYear1 = deferredYear1;
	}

	public BigDecimal getDeferredAmount1() {
		return deferredAmount1;
	}

	public void setDeferredAmount1(BigDecimal deferredAmount1) {
		this.deferredAmount1 = deferredAmount1;
	}

	public Short getDeferredMonth2() {
		return deferredMonth2;
	}

	public void setDeferredMonth2(Short deferredMonth2) {
		this.deferredMonth2 = deferredMonth2;
	}

	public Short getDeferredYear2() {
		return deferredYear2;
	}

	public void setDeferredYear2(Short deferredYear2) {
		this.deferredYear2 = deferredYear2;
	}

	public BigDecimal getDeferredAmount2() {
		return deferredAmount2;
	}

	public void setDeferredAmount2(BigDecimal deferredAmount2) {
		this.deferredAmount2 = deferredAmount2;
	}

	public Short getDeferredMonth3() {
		return deferredMonth3;
	}

	public void setDeferredMonth3(Short deferredMonth3) {
		this.deferredMonth3 = deferredMonth3;
	}

	public Short getDeferredYear3() {
		return deferredYear3;
	}

	public void setDeferredYear3(Short deferredYear3) {
		this.deferredYear3 = deferredYear3;
	}

	public BigDecimal getDeferredAmount3() {
		return deferredAmount3;
	}

	public void setDeferredAmount3(BigDecimal deferredAmount3) {
		this.deferredAmount3 = deferredAmount3;
	}

	public Short getDeferredMonth4() {
		return deferredMonth4;
	}

	public void setDeferredMonth4(Short deferredMonth4) {
		this.deferredMonth4 = deferredMonth4;
	}

	public Short getDeferredYear4() {
		return deferredYear4;
	}

	public void setDeferredYear4(Short deferredYear4) {
		this.deferredYear4 = deferredYear4;
	}

	public BigDecimal getDeferredAmount4() {
		return deferredAmount4;
	}

	public void setDeferredAmount4(BigDecimal deferredAmount4) {
		this.deferredAmount4 = deferredAmount4;
	}

	public Short getDeferredMonth5() {
		return deferredMonth5;
	}

	public void setDeferredMonth5(Short deferredMonth5) {
		this.deferredMonth5 = deferredMonth5;
	}

	public Short getDeferredYear5() {
		return deferredYear5;
	}

	public void setDeferredYear5(Short deferredYear5) {
		this.deferredYear5 = deferredYear5;
	}

	public BigDecimal getDeferredAmount5() {
		return deferredAmount5;
	}

	public void setDeferredAmount5(BigDecimal deferredAmount5) {
		this.deferredAmount5 = deferredAmount5;
	}

	public Short getDeferredMonth6() {
		return deferredMonth6;
	}

	public void setDeferredMonth6(Short deferredMonth6) {
		this.deferredMonth6 = deferredMonth6;
	}

	public Short getDeferredYear6() {
		return deferredYear6;
	}

	public void setDeferredYear6(Short deferredYear6) {
		this.deferredYear6 = deferredYear6;
	}

	public BigDecimal getDeferredAmount6() {
		return deferredAmount6;
	}

	public void setDeferredAmount6(BigDecimal deferredAmount6) {
		this.deferredAmount6 = deferredAmount6;
	}

	public Short getDeferredMonth7() {
		return deferredMonth7;
	}

	public void setDeferredMonth7(Short deferredMonth7) {
		this.deferredMonth7 = deferredMonth7;
	}

	public Short getDeferredYear7() {
		return deferredYear7;
	}

	public void setDeferredYear7(Short deferredYear7) {
		this.deferredYear7 = deferredYear7;
	}

	public BigDecimal getDeferredAmount7() {
		return deferredAmount7;
	}

	public void setDeferredAmount7(BigDecimal deferredAmount7) {
		this.deferredAmount7 = deferredAmount7;
	}

	public Short getDeferredMonth8() {
		return deferredMonth8;
	}

	public void setDeferredMonth8(Short deferredMonth8) {
		this.deferredMonth8 = deferredMonth8;
	}

	public Short getDeferredYear8() {
		return deferredYear8;
	}

	public void setDeferredYear8(Short deferredYear8) {
		this.deferredYear8 = deferredYear8;
	}

	public BigDecimal getDeferredAmount8() {
		return deferredAmount8;
	}

	public void setDeferredAmount8(BigDecimal deferredAmount8) {
		this.deferredAmount8 = deferredAmount8;
	}

	public Short getDeferredMonth9() {
		return deferredMonth9;
	}

	public void setDeferredMonth9(Short deferredMonth9) {
		this.deferredMonth9 = deferredMonth9;
	}

	public Short getDeferredYear9() {
		return deferredYear9;
	}

	public void setDeferredYear9(Short deferredYear9) {
		this.deferredYear9 = deferredYear9;
	}

	public BigDecimal getDeferredAmount9() {
		return deferredAmount9;
	}

	public void setDeferredAmount9(BigDecimal deferredAmount9) {
		this.deferredAmount9 = deferredAmount9;
	}

	public Short getDeferredMonth10() {
		return deferredMonth10;
	}

	public void setDeferredMonth10(Short deferredMonth10) {
		this.deferredMonth10 = deferredMonth10;
	}

	public Short getDeferredYear10() {
		return deferredYear10;
	}

	public void setDeferredYear10(Short deferredYear10) {
		this.deferredYear10 = deferredYear10;
	}

	public BigDecimal getDeferredAmount10() {
		return deferredAmount10;
	}

	public void setDeferredAmount10(BigDecimal deferredAmount10) {
		this.deferredAmount10 = deferredAmount10;
	}

	public Short getDeferredMonth11() {
		return deferredMonth11;
	}

	public void setDeferredMonth11(Short deferredMonth11) {
		this.deferredMonth11 = deferredMonth11;
	}

	public Short getDeferredYear11() {
		return deferredYear11;
	}

	public void setDeferredYear11(Short deferredYear11) {
		this.deferredYear11 = deferredYear11;
	}

	public BigDecimal getDeferredAmount11() {
		return deferredAmount11;
	}

	public void setDeferredAmount11(BigDecimal deferredAmount11) {
		this.deferredAmount11 = deferredAmount11;
	}

	public Short getDeferredMonth12() {
		return deferredMonth12;
	}

	public void setDeferredMonth12(Short deferredMonth12) {
		this.deferredMonth12 = deferredMonth12;
	}

	public Short getDeferredYear12() {
		return deferredYear12;
	}

	public void setDeferredYear12(Short deferredYear12) {
		this.deferredYear12 = deferredYear12;
	}

	public BigDecimal getDeferredAmount12() {
		return deferredAmount12;
	}

	public void setDeferredAmount12(BigDecimal deferredAmount12) {
		this.deferredAmount12 = deferredAmount12;
	}

	public String getDepositIdentifier() {
		return depositIdentifier;
	}

	public void setDepositIdentifier(String depositIdentifier) {
		this.depositIdentifier = depositIdentifier;
	}

	public char getCorrectiveYn() {
		return correctiveYn;
	}

	public void setCorrectiveYn(char correctiveYn) {
		this.correctiveYn = correctiveYn;
	}

	public String getCorrectiveDescr() {
		return correctiveDescr;
	}

	public void setCorrectiveDescr(String correctiveDescr) {
		this.correctiveDescr = correctiveDescr;
	}

	public LocalDateTime getPostedNavisionDate() {
		return postedNavisionDate;
	}

	public void setPostedNavisionDate(LocalDateTime postedNavisionDate) {
		this.postedNavisionDate = postedNavisionDate;
	}

	public Boolean isPci() {
		return pci;
	}

	public void setPci(Boolean pci) {
		this.pci = pci;
	}

	public LocalDateTime getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(LocalDateTime submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Set<SourceNotesDTO> getSourceNotesDTO() {
		return sourceNotesDTO;
	}

	public void setSourceNotesDTO(Set<SourceNotesDTO> sourceNotesDTO) {
		this.sourceNotesDTO = sourceNotesDTO;
	}

	public Boolean getPci() {
		return pci;
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

	public String getDueToLocation() {
		return dueToLocation;
	}

	public void setDueToLocation(String dueToLocation) {
		this.dueToLocation = dueToLocation;
	}

	public String getPayor() {
		return payor;
	}

	public void setPayor(String payor) {
		this.payor = payor;
	}

	public String getDueToLocAmount() {
		return dueToLocAmount;
	}

	public void setDueToLocAmount(String dueToLocAmount) {
		this.dueToLocAmount = dueToLocAmount;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Override
	public String toString() {
		return "SourceDTO [id=" + id + ", bankAccountsDTO=" + bankAccountsDTO + ", locationDTO=" + locationDTO
				+ ", revenueTypesDTO=" + revenueTypesDTO + ", status=" + status + ", tenderTypesDTO=" + tenderTypesDTO
				+ ", submittedBy=" + submittedBy + ", postedBy=" + postedBy + ", transactionDate=" + transactionDate
				+ ", amount=" + amount + ", reconciledDate=" + reconciledDate + ", postingDate=" + postingDate
				+ ", subAccountCode=" + subAccountCode + ", deferredYn=" + deferredYn + ", deferredMonth1="
				+ deferredMonth1 + ", deferredYear1=" + deferredYear1 + ", deferredAmount1=" + deferredAmount1
				+ ", deferredMonth2=" + deferredMonth2 + ", deferredYear2=" + deferredYear2 + ", deferredAmount2="
				+ deferredAmount2 + ", deferredMonth3=" + deferredMonth3 + ", deferredYear3=" + deferredYear3
				+ ", deferredAmount3=" + deferredAmount3 + ", deferredMonth4=" + deferredMonth4 + ", deferredYear4="
				+ deferredYear4 + ", deferredAmount4=" + deferredAmount4 + ", deferredMonth5=" + deferredMonth5
				+ ", deferredYear5=" + deferredYear5 + ", deferredAmount5=" + deferredAmount5 + ", deferredMonth6="
				+ deferredMonth6 + ", deferredYear6=" + deferredYear6 + ", deferredAmount6=" + deferredAmount6
				+ ", deferredMonth7=" + deferredMonth7 + ", deferredYear7=" + deferredYear7 + ", deferredAmount7="
				+ deferredAmount7 + ", deferredMonth8=" + deferredMonth8 + ", deferredYear8=" + deferredYear8
				+ ", deferredAmount8=" + deferredAmount8 + ", deferredMonth9=" + deferredMonth9 + ", deferredYear9="
				+ deferredYear9 + ", deferredAmount9=" + deferredAmount9 + ", deferredMonth10=" + deferredMonth10
				+ ", deferredYear10=" + deferredYear10 + ", deferredAmount10=" + deferredAmount10 + ", deferredMonth11="
				+ deferredMonth11 + ", deferredYear11=" + deferredYear11 + ", deferredAmount11=" + deferredAmount11
				+ ", deferredMonth12=" + deferredMonth12 + ", deferredYear12=" + deferredYear12 + ", deferredAmount12="
				+ deferredAmount12 + ", depositIdentifier=" + depositIdentifier + ", correctiveYn=" + correctiveYn
				+ ", correctiveDescr=" + correctiveDescr + ", postedNavisionDate=" + postedNavisionDate
				+ ", exportNavisionDate=" + exportNavisionDate + ", pci=" + pci + ", submittedDate=" + submittedDate
				+ ", sourceNotesDTO=" + sourceNotesDTO + ", revenueDTO=" + revenueDTO + ", exportNavisionBy="
				+ exportNavisionBy + ", bankAmount=" + bankAmount + ", dueToLocation=" + dueToLocation + ", payor="
				+ payor + ", dueToLocAmount=" + dueToLocAmount + ", checkNumber=" + checkNumber + ", getBankAmount()="
				+ getBankAmount() + ", getRevenueDTO()=" + getRevenueDTO() + ", getId()=" + getId()
				+ ", getBankAccountsDTO()=" + getBankAccountsDTO() + ", getLocationDTO()=" + getLocationDTO()
				+ ", getSubmittedBy()=" + getSubmittedBy() + ", getPostedBy()=" + getPostedBy()
				+ ", getRevenueTypesDTO()=" + getRevenueTypesDTO() + ", getStatus()=" + getStatus()
				+ ", getTenderTypesDTO()=" + getTenderTypesDTO() + ", getTransactionDate()=" + getTransactionDate()
				+ ", getAmount()=" + getAmount() + ", getReconciledDate()=" + getReconciledDate()
				+ ", getPostingDate()=" + getPostingDate() + ", getSubAccountCode()=" + getSubAccountCode()
				+ ", getDeferredYn()=" + getDeferredYn() + ", getDeferredMonth1()=" + getDeferredMonth1()
				+ ", getDeferredYear1()=" + getDeferredYear1() + ", getDeferredAmount1()=" + getDeferredAmount1()
				+ ", getDeferredMonth2()=" + getDeferredMonth2() + ", getDeferredYear2()=" + getDeferredYear2()
				+ ", getDeferredAmount2()=" + getDeferredAmount2() + ", getDeferredMonth3()=" + getDeferredMonth3()
				+ ", getDeferredYear3()=" + getDeferredYear3() + ", getDeferredAmount3()=" + getDeferredAmount3()
				+ ", getDeferredMonth4()=" + getDeferredMonth4() + ", getDeferredYear4()=" + getDeferredYear4()
				+ ", getDeferredAmount4()=" + getDeferredAmount4() + ", getDeferredMonth5()=" + getDeferredMonth5()
				+ ", getDeferredYear5()=" + getDeferredYear5() + ", getDeferredAmount5()=" + getDeferredAmount5()
				+ ", getDeferredMonth6()=" + getDeferredMonth6() + ", getDeferredYear6()=" + getDeferredYear6()
				+ ", getDeferredAmount6()=" + getDeferredAmount6() + ", getDeferredMonth7()=" + getDeferredMonth7()
				+ ", getDeferredYear7()=" + getDeferredYear7() + ", getDeferredAmount7()=" + getDeferredAmount7()
				+ ", getDeferredMonth8()=" + getDeferredMonth8() + ", getDeferredYear8()=" + getDeferredYear8()
				+ ", getDeferredAmount8()=" + getDeferredAmount8() + ", getDeferredMonth9()=" + getDeferredMonth9()
				+ ", getDeferredYear9()=" + getDeferredYear9() + ", getDeferredAmount9()=" + getDeferredAmount9()
				+ ", getDeferredMonth10()=" + getDeferredMonth10() + ", getDeferredYear10()=" + getDeferredYear10()
				+ ", getDeferredAmount10()=" + getDeferredAmount10() + ", getDeferredMonth11()=" + getDeferredMonth11()
				+ ", getDeferredYear11()=" + getDeferredYear11() + ", getDeferredAmount11()=" + getDeferredAmount11()
				+ ", getDeferredMonth12()=" + getDeferredMonth12() + ", getDeferredYear12()=" + getDeferredYear12()
				+ ", getDeferredAmount12()=" + getDeferredAmount12() + ", getDepositIdentifier()="
				+ getDepositIdentifier() + ", getCorrectiveYn()=" + getCorrectiveYn() + ", getCorrectiveDescr()="
				+ getCorrectiveDescr() + ", getPostedNavisionDate()=" + getPostedNavisionDate() + ", isPci()=" + isPci()
				+ ", getSubmittedDate()=" + getSubmittedDate() + ", getSourceNotesDTO()=" + getSourceNotesDTO()
				+ ", getPci()=" + getPci() + ", getExportNavisionDate()=" + getExportNavisionDate()
				+ ", getExportNavisionBy()=" + getExportNavisionBy() + ", getDueToLocation()=" + getDueToLocation()
				+ ", getPayor()=" + getPayor() + ", getDueToLocAmount()=" + getDueToLocAmount() + ", getCheckNumber()="
				+ getCheckNumber() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

}
