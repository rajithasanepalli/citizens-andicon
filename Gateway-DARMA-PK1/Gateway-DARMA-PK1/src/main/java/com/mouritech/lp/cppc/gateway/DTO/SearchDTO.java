package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SearchDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer page;

	private Integer per_page;
	
	private boolean isProcessed;

	private List<SortDTO> sort = new LinkedList<SortDTO>();

	public boolean getIsProcessed() {
		return isProcessed;
	}


	public void setIsProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
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


	public List<SortDTO> getSort() {
		return sort;
	}


	public void setSort(List<SortDTO> sort) {
		this.sort = sort;
	}


	@Override
	public String toString() {
		return "SearchDTO [page=" + page + ", per_page=" + per_page
				+ ", filterDTO=" + filterDTO + "]";
	}
	


}
