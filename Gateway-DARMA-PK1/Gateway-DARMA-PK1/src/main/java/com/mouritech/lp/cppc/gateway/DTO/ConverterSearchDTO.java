package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ConverterSearchDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer page;

	private Integer per_page;
	
	private String billingOrGl;
	
	
	
	

	public String getBillingOrGl() {
		return billingOrGl;
	}

	public void setBillingOrGl(String billingOrGl) {
		this.billingOrGl = billingOrGl;
	}

	private Set<FilterDTO> filterDTO = new HashSet<>();

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Set<FilterDTO> getFilterDTO() {
		return filterDTO;
	}

	public void setFilterDTO(Set<FilterDTO> filterDTO) {
		this.filterDTO = filterDTO;
	}

	@Override
	public String toString() {
		return "ConverterSearchDTO [page=" + page + ", per_page=" + per_page
				+ ", filterDTO=" + filterDTO + "]";
	}

	
	

}
