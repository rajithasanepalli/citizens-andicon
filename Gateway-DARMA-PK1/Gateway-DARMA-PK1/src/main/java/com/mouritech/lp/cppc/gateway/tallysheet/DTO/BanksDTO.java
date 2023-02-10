package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BanksDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ID;

	private String name;

	private String shortName;

	private String branchNo;

	private String abaNo;

	private String code;

	private String accountNo;

	private String transientNo;

	private String transientDeno;

	private String accountCode;

	private String glAccountNo;

	private String address1;

	private String address2;

	private String phone1;

	private String phone2;

	private Integer cashBalanceGroup;

	private Boolean inActiveFlag;

	private String city;

	private Boolean achBank;

	private ZipCodesDTO Zip_CodeDTO;

	private Set<GarageBanksDTO> garageBanksDTO = new HashSet<GarageBanksDTO>();

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getAbaNo() {
		return abaNo;
	}

	public void setAbaNo(String abaNo) {
		this.abaNo = abaNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getTransientNo() {
		return transientNo;
	}

	public void setTransientNo(String transientNo) {
		this.transientNo = transientNo;
	}

	public String getTransientDeno() {
		return transientDeno;
	}

	public void setTransientDeno(String transientDeno) {
		this.transientDeno = transientDeno;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getGlAccountNo() {
		return glAccountNo;
	}

	public void setGlAccountNo(String glAccountNo) {
		this.glAccountNo = glAccountNo;
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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Integer getCashBalanceGroup() {
		return cashBalanceGroup;
	}

	public void setCashBalanceGroup(Integer cashBalanceGroup) {
		this.cashBalanceGroup = cashBalanceGroup;
	}

	public Boolean getInActiveFlag() {
		return inActiveFlag;
	}

	public void setInActiveFlag(Boolean inActiveFlag) {
		this.inActiveFlag = inActiveFlag;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getAchBank() {
		return achBank;
	}

	public void setAchBank(Boolean achBank) {
		this.achBank = achBank;
	}

	public ZipCodesDTO getZip_CodeDTO() {
		return Zip_CodeDTO;
	}

	public void setZip_CodeDTO(ZipCodesDTO zip_CodeDTO) {
		Zip_CodeDTO = zip_CodeDTO;
	}

	public Set<GarageBanksDTO> getGarageBanksDTO() {
		return garageBanksDTO;
	}

	public void setGarageBanksDTO(Set<GarageBanksDTO> garageBanksDTO) {
		this.garageBanksDTO = garageBanksDTO;
	}

	@Override
	public String toString() {
		return "BanksDTO [ID=" + ID + ", name=" + name + ", shortName="
				+ shortName + ", branchNo=" + branchNo + ", abaNo=" + abaNo
				+ ", code=" + code + ", accountNo=" + accountNo
				+ ", transientNo=" + transientNo + ", transientDeno="
				+ transientDeno + ", accountCode=" + accountCode
				+ ", glAccountNo=" + glAccountNo + ", address1=" + address1
				+ ", address2=" + address2 + ", phone1=" + phone1 + ", phone2="
				+ phone2 + ", cashBalanceGroup=" + cashBalanceGroup
				+ ", inActiveFlag=" + inActiveFlag + ", city=" + city
				+ ", achBank=" + achBank + ", Zip_CodeDTO=" + Zip_CodeDTO
				+ ", garageBanksDTO=" + garageBanksDTO + "]";
	}

}
