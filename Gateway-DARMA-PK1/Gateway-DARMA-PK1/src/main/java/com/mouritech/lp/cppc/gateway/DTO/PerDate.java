package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class PerDate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer totalTkts;

	private Integer ticketIssued;

	private Integer countofValidations;

	private Integer openTickets;

	private Integer unaccountedTickets;

	private LocalDate date;

	private List<NetRate> netRate = new ArrayList<NetRate>();

	public Integer getTotalTkts() {
		return totalTkts;
	}

	public void setTotalTkts(Integer totalTkts) {
		this.totalTkts = totalTkts;
	}

	public Integer getTicketIssued() {
		return ticketIssued;
	}

	public void setTicketIssued(Integer ticketIssued) {
		this.ticketIssued = ticketIssued;
	}

	public Integer getCountofValidations() {
		return countofValidations;
	}

	public void setCountofValidations(Integer countofValidations) {
		this.countofValidations = countofValidations;
	}

	public Integer getOpenTickets() {
		return openTickets;
	}

	public void setOpenTickets(Integer openTickets) {
		this.openTickets = openTickets;
	}

	public Integer getUnaccountedTickets() {
		return unaccountedTickets;
	}

	public void setUnaccountedTickets(Integer unaccountedTickets) {
		this.unaccountedTickets = unaccountedTickets;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<NetRate> getNetRate() {
		return netRate;
	}

	public void setNetRate(List<NetRate> netRate) {
		this.netRate = netRate;
	}

}
